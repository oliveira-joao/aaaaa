var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Leitura = require('../models').Leitura;

router.get('/recuperarFuncionario/:fkEmpresa', function (req, res, next) {

	console.log(`Recuperando os monitoramentos dos funcionarios do gestor`);

	var fkEmpresa = req.params.fkEmpresa;

	const instrucaoSql = `SELECT *
	FROM (
				  SELECT  idFuncionario,
				  	      nomeFuncionario, 
						  porcentagemUsoCPU, 
						  porcentagemUsoRAM, 
						  porcentagemUsoDisco,
						  horarioLeitura,
						  ROW_NUMBER() OVER(PARTITION BY nomeFuncionario ORDER BY horarioLeitura DESC) rn
					  from Funcionario 
	  JOIN Computador on fkFuncionario = idFuncionario
	  JOIN LeituraHardware on fkComputador = idComputador
	  where permissaoAdmin = 0 and fkEmpresa = ${fkEmpresa}
				) a
  	WHERE rn = 1`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado);
			console.log(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});

});

router.get('/recuperarListaFuncionario/:fkEmpresa', function (req, res, next) {

	console.log(`Recuperando a lista de funcionários do gestor`);

	var fkEmpresa = req.params.fkEmpresa;

	const instrucaoSql = `SELECT *
	FROM (
				  SELECT  idFuncionario,
				  		  nomeFuncionario, 
						  sistemaOperacional, 
						  nomeCPU, 
						  modeloDisco,
						  totalRAM,
						  horarioLeitura,
						  ROW_NUMBER() OVER(PARTITION BY nomeFuncionario ORDER BY horarioLeitura DESC) rn
					  from Funcionario 
	  JOIN Computador on fkFuncionario = idFuncionario
	  JOIN LeituraHardware on fkComputador = idComputador
	  where permissaoAdmin = 0 and fkEmpresa = ${fkEmpresa}
				) a
  	WHERE rn = 1`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado);
			console.log(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

router.get('/recuperarListaRelatos/:fkEmpresa', function (req, res, next) {

	console.log('Recuperando a lista de relatos dos funcionários')

	var fkEmpresa = req.params.fkEmpresa;

	const instrucaoSql = `SELECT relatorio,
								 sentimento,
								 CONVERT (VARCHAR, momentoRelato, 23) as momentoRelato,
								 fkFuncionario
								 from [dbo].[Relato]
	JOIN [dbo].[Funcionario] on fkFuncionario = idFuncionario
	where permissaoAdmin = 0 and fkEmpresa = ${fkEmpresa}
	ORDER BY momentoRelato DESC`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado);
			console.log(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});

});

router.get('/recuperarFuncionarioHardware/:fkEmpresa/:idFuncionario', function (req, res) {

	console.log('Recuperando o monitoramento do funcionário')

	var fkEmpresa = req.params.fkEmpresa;
	var idFuncionario = req.params.idFuncionario;

	const instrucaoSql = `SELECT porcentagemUsoCPU, 
						 porcentagemUsoRAM, 
						 porcentagemUsoDisco,
						 horarioLeitura,
  						 fkFuncionario
 						 from [dbo].[LeituraHardware]
	JOIN Computador on fkComputador = idComputador
	JOIN [dbo].[Funcionario] on fkFuncionario = idFuncionario
	where permissaoAdmin = 0 and fkEmpresa = ${fkEmpresa} and idFuncionario = ${idFuncionario}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado);
			console.log(resultado);
		}).catch(erro => {
			// console.error(erro);
			res.status(500).send(erro.message);
		});


});


router.get('/recuperarListaRelatos/:fkEmpresa', function (req, res, next) {

	console.log('Recuperando quantidade de sentimentos do relato')

	var fkEmpresa = req.params.fkEmpresa;

	const instrucaoSql = `SELECT sentimento,
								 CONVERT (VARCHAR, momentoRelato, 23) as momentoRelato,
								 fkFuncionario
								 from [dbo].[Relato]
	JOIN [dbo].[Funcionario] on fkFuncionario = idFuncionario
	where permissaoAdmin = 0 and fkEmpresa = ${fkEmpresa}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			const contador = { feliz: 0, neutro: 0, triste: 0 }
			resultado.forEach(item => {
				contador[item.sentimento.toLowerCase()] = contador[item.sentimento.toLowerCase()] + 1
			});
			res.json(contador);
			console.log(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});

});

module.exports = router;

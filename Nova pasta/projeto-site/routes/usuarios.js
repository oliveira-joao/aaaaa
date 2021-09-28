var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Funcionario = require('../models').Funcionario;

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post('/autenticar', function(req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var loginFuncionario = req.body.loginFuncionario; // depois de .body, use o nome (name) do campo em seu formulário de login
	var senhaFuncionario = req.body.senhaFuncionario; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	let instrucaoSql = `select * from funcionario where loginFuncionario='${loginFuncionario}' and senhaFuncionario='${senhaFuncionario}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Funcionario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`); 

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.loginFuncionario);
			console.log('sessoes: ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('Login e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um usuário com o mesmo login e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Cadastrar usuário */
router.post('/cadastrar', function(req, res, next) {
	console.log('Criando um usuário');
	
	Funcionario.create({
		nomeFuncionario : req.body.nomeFuncionario,
		loginFuncionario : req.body.loginFuncionario,
		senhaFuncionario: req.body.senhaFuncionario,
		emailFuncionario : req.body.emailFuncionario,
		telefoneFuncionario : req.body.telefoneFuncionario,
		permissaoAdmin : 0,
		tipoFuncionario: 0,
		fkEmpresa : req.body.fkEmpresa
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


/* Verificação de usuário */
router.get('/sessao/:login', function(req, res, next) {
	let login = req.params.login;
	console.log(`Verificando se o usuário ${login} tem sessão...`);
	
	let tem_sessao = false;
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] == login) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${login} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}
	
});


/* Logoff de usuário */
router.get('/sair/:login', function(req, res, next) {
	let login = req.params.login;
	console.log(`Finalizando a sessão do usuário ${login}`);
	let nova_sessoes = []
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});


/* Recuperar todos os usuários */
router.get('/', function(req, res, next) {
	console.log('Recuperando todos os usuários');
	Funcionario.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

module.exports = router;

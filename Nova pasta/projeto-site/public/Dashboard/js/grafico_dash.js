function nome() {
    nomeFuncionario = sessionStorage.funcionario;

    funcionario.innerHTML = nomeFuncionario;
}

var dadosFuncionario;

var parametroData = null;


function obterGrafico() {

    var fkEmpresa = sessionStorage.getItem("fk_empresa_meuapp");
    var idFuncionario = sessionStorage.getItem("idFuncionario");
    var nomeFuncionario = sessionStorage.getItem("funcionario");

    console.log(nomeFuncionario);

    fetch(`../leituras/recuperarFuncionarioHardware/${fkEmpresa}/${idFuncionario}`)
        .then(resposta => {
            console.log('fetch')

            if (resposta.ok) {
                resposta.json().then(function (resposta_json) {
                    console.log(resposta_json)
                    dadosFuncionario = resposta_json
                    insertIntoChart(resposta_json, parametroData)

                });
            } else {

                console.error('deu ruim');
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados do computador p/ gráfico: ${error.message}`);
        });
}

setInterval(obterGrafico, 3000);

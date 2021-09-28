var respostaLeituraRelatos = []

function obterGrafico() {
    var fkEmpresa = sessionStorage.fk_empresa_meuapp;

    fetch(`../leituras/recuperarListaRelatos/${fkEmpresa}`)
        .then(resposta => {
            console.log('fetch')

            if (resposta.ok) {
                resposta.json().then(function (resposta_json) {
                    console.log(resposta_json)
                    respostaLeituraRelatos = resposta_json
                    obterSentimentosDoDia(resposta_json, myChart, 0)
                    obterSentimentosDoDia(resposta_json, meuDonutChart, 1)

                });
            } else {

                console.error('deu ruim');
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados do computador p/ gráfico: ${error.message}`);
        });
}



intervalo = setInterval(obterGrafico, 3000);
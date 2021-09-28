var fkEmpresa = sessionStorage.fk_empresa_meuapp;

function obterRelatos() {
    fetch(`/leituras/recuperarListaRelatos/${fkEmpresa}`)
        .then(resposta => {
            console.log('fetch')

            if (resposta.ok) {
                resposta.json().then(function (resposta_json) {
                    console.log(resposta_json)
                    listas = resposta_json;
                    incrementar.innerHTML = ``;
                    inserirRelatos();
                });
            } else {

                console.error('deu ruim');
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados para a lista dos funcionários: ${error.message}`);
        });
}

function inserirRelatos() {

    var parametro_humor = $("#sentimento").val()
    var parametro_data = $('#data').val()

    function filtrarListaPorHumor({ sentimento }) {
        return sentimento.toUpperCase().indexOf(parametro_humor.toUpperCase()) >= 0
    }

    function filtrarListaPorData({ momentoRelato }) {
        return !!parametro_data && momentoRelato.indexOf(parametro_data) >= 0
    }

    function filtrarListaPorAmbos({ sentimento, momentoRelato }) {
        return (
            sentimento.toUpperCase().indexOf(parametro_humor.toUpperCase()) >= 0 &&
            !!parametro_data && momentoRelato.indexOf(parametro_data) >= 0
        )
    }

    listaFiltrada = parametro_humor !== "selecione1"
        ? !parametro_data
            ? listas.filter(filtrarListaPorHumor)
            : listas.filter(filtrarListaPorAmbos)
        : !parametro_data
            ? listas
            : listas.filter(filtrarListaPorData)



    for (let i = 0; i < listaFiltrada.length; i++) {
        relatoFuncionario = listaFiltrada[i].relatorio;
        sentimentoFuncionario = listaFiltrada[i].sentimento;
        momentoRelato = listaFiltrada[i].momentoRelato;

        let imgSentimento;

        if (sentimentoFuncionario == "Triste") {
            imgSentimento = "./img/sad.svg";
        } else if (sentimentoFuncionario == "Neutro") {
            imgSentimento = "./img/impartial.svg"
        } else {
            imgSentimento = "./img/happy.svg"
        }


        incrementar.innerHTML += `
        <div id="quadrado-critico" class="conteudo-quadrado">
            <div class="relato-box">
                <div class="titulo-relato">
                    <h5>RELATO DE FUNCIONÁRIO</h5>

                </div>
                <div class="relato">
                    <label>${relatoFuncionario}</label>
                </div>

            </div>
            <div class="alerta-sentimento">
                <div class="sentimento">
                        <label>Sentindo-se ${sentimentoFuncionario}</label>
                        <label style="color: gray;">${momentoRelato}</label>
                </div>
                <div class="sentimento-img">
                <img src="${imgSentimento}">
                </div>
            </div>
        </div>
        `


    }
}
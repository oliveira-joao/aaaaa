var fkEmpresa = sessionStorage.fk_empresa_meuapp;

var listaFiltrada = []

function obterLista() {
    fetch(`/leituras/recuperarListaFuncionario/${fkEmpresa}`)
        .then(resposta => {
            console.log('fetch')

            if (resposta.ok) {
                resposta.json().then(function (resposta_json) {
                    console.log(resposta_json)
                    listas = resposta_json;
                    incrementar.innerHTML = ``;
                    inserirListas();
                });
            } else {

                console.error('deu ruim');
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados para a lista dos funcionários: ${error.message}`);
        });
}

function inserirListas() {
    listaFiltrada = listas.filter(({ nomeFuncionario }) => nomeFuncionario.toUpperCase().indexOf($("#filtro").val().toUpperCase()) >= 0)

    for (let i = 0; i < listaFiltrada.length; i++) {
        idFuncionario = listaFiltrada[i].idFuncionario;
        nomeFuncionario = listaFiltrada[i].nomeFuncionario;
        sistemaOperacional = listaFiltrada[i].sistemaOperacional;
        nomeCPU = listaFiltrada[i].nomeCPU;
        modeloDisco = listaFiltrada[i].modeloDisco;
        totalRAM = listaFiltrada[i].totalRAM;

        incrementar.innerHTML += `
            <a id="quadrado-critico" class="conteudo-quadrado" onclick="entrarNoGrafico(\'${nomeFuncionario}\', \'${idFuncionario}\')">
                <div class="usuario">
                    <img id="icon-usuario" src="img/icon-funcionario.svg" alt="">
                </div>
                <div class="nome-funcionario">
                    <h5>${nomeFuncionario}</h5>
                </div>
                <ul class="info-maquinas1">
                <li class="container-info-maquinas"><strong class="titulo-info-maquinas">CPU:
                        </strong>${nomeCPU}</li>
                    <li><strong class="titulo-info-maquinas">DISCO:
                        </strong>${modeloDisco}</li>
                </ul>
                <ul class="info-maquinas2">
                    <li class="container-info-maquinas"><strong class="titulo-info-maquinas">SO:
                        </strong>${sistemaOperacional}</li>
                    <li><strong class="titulo-info-maquinas">MEMÓRIA RAM:
                        </strong>${totalRAM} GB</li>
                </ul>
                <div class="alerta">
                </div>
            </a>
        `
        inserirCriticidade(nomeFuncionario, i);
    }
}

function obterCriticidade() {
    fetch(`/leituras/recuperarFuncionario/${fkEmpresa}`)
        .then(resposta => {
            console.log('fetch')

            if (resposta.ok) {
                resposta.json().then(function (resposta_json) {
                    console.log(resposta_json)
                    funcionarios = resposta_json;
                });
            } else {
                console.error('deu ruim');
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção da criticidade: ${error.message}`);
        });
}

function entrarNoGrafico(nomeFuncionario, idFuncionario) {
    sessionStorage.setItem("funcionario", nomeFuncionario)
    sessionStorage.setItem("idFuncionario", idFuncionario)
    window.location.href = '../Dashboard/historico.html';
}

function inserirCriticidade(nomeDoFuncionario, contador) {
    var referencia = document.getElementsByClassName('alerta')[contador];

    var itemCriticidade = funcionarios.find(({ nomeFuncionario }) => nomeFuncionario.toUpperCase().indexOf(nomeDoFuncionario.toUpperCase()) >= 0)
    if (Array.isArray(itemCriticidade)) itemCriticidade = itemCriticidade[contador]

    console.log(itemCriticidade)

    porcentagemCPU = itemCriticidade.porcentagemUsoCPU;
    porcentagemRAM = itemCriticidade.porcentagemUsoRAM;
    porcentagemDisco = itemCriticidade.porcentagemUsoDisco;

    // porcentagemCPU = funcionarios[contador].porcentagemUsoCPU;
    // porcentagemRAM = funcionarios[contador].porcentagemUsoRAM;
    // porcentagemDisco = funcionarios[contador].porcentagemUsoDisco;

    let corPorcentagemCPU;
    let corPorcentagemRAM;
    let corPorcentagemDisco;

    if (porcentagemCPU < 45) {
        corPorcentagemCPU = "green";
    } else if (porcentagemCPU >= 45 && porcentagemCPU < 75) {
        corPorcentagemCPU = "orange";
    } else {
        corPorcentagemCPU = "red";
    }

    if (porcentagemRAM < 45) {
        corPorcentagemRAM = "green";
    } else if (porcentagemRAM >= 45 && porcentagemRAM < 75) {
        corPorcentagemRAM = "orange";
    } else {
        corPorcentagemRAM = "red";
    }

    if (porcentagemDisco < 45) {
        corPorcentagemDisco = "green";
    } else if (porcentagemDisco >= 45 && porcentagemDisco < 75) {
        corPorcentagemDisco = "orange";
    } else {
        corPorcentagemDisco = "red";
    }

    if (
        (corPorcentagemCPU == "green" && corPorcentagemRAM == "green" && corPorcentagemDisco == "green") ||
        (corPorcentagemCPU == "orange" && corPorcentagemRAM == "green" && corPorcentagemDisco == "green") ||
        (corPorcentagemCPU == "green" && corPorcentagemRAM == "orange" && corPorcentagemDisco == "green") ||
        (corPorcentagemCPU == "green" && corPorcentagemRAM == "green" && corPorcentagemDisco == "orange")
    ) {
        referencia.innerHTML += `<div class="alerta-ok">
                                                                    <p>Ok</p>
                                                                </div>`

    } else
        if (
            (corPorcentagemCPU == "red" && corPorcentagemRAM == "green" && corPorcentagemDisco == "green") ||
            (corPorcentagemCPU == "green" && corPorcentagemRAM == "red" && corPorcentagemDisco == "green") ||
            (corPorcentagemCPU == "green" && corPorcentagemRAM == "green" && corPorcentagemDisco == "red") ||
            (corPorcentagemCPU == "orange" && corPorcentagemRAM == "orange" && corPorcentagemDisco == "orange") ||
            (corPorcentagemCPU == "green" && corPorcentagemRAM == "orange" && corPorcentagemDisco == "orange") ||
            (corPorcentagemCPU == "orange" && corPorcentagemRAM == "green" && corPorcentagemDisco == "orange") ||
            (corPorcentagemCPU == "orange" && corPorcentagemRAM == "orange" && corPorcentagemDisco == "green") ||

            (corPorcentagemCPU == "green" && corPorcentagemRAM == "orange" && corPorcentagemDisco == "red") ||
            (corPorcentagemCPU == "orange" && corPorcentagemRAM == "green" && corPorcentagemDisco == "red") ||

            (corPorcentagemCPU == "orange" && corPorcentagemRAM == "red" && corPorcentagemDisco == "green") ||
            (corPorcentagemCPU == "green" && corPorcentagemRAM == "red" && corPorcentagemDisco == "orange") ||

            (corPorcentagemCPU == "red" && corPorcentagemRAM == "green" && corPorcentagemDisco == "orange") ||
            (corPorcentagemCPU == "red" && corPorcentagemRAM == "orange" && corPorcentagemDisco == "green")
        ) {
            referencia.innerHTML += `<div class="alerta-moderado">
                                                                        <p>Moderado</p>
                                                                    </div>`
        } else {
            referencia.innerHTML += `<div class="alerta-critico">
                                                                        <p>Crítico</p>
                                                                    </div>`
        }
}
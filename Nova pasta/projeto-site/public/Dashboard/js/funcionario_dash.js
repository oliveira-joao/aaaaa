var status = "todos";

function critico() {
    status = "critico";
    incrementar.innerHTML = `<img src="./img/gifSmy.gif" style="height: 270px;" alt="">`;
    critico_button.style = "background-color: #FD7171; font-weight: 550; color: white; border: none;"
    moderado_button.style = "background-color: white; color:#424040; border-color:#424040;"
    ok_button.style = "background-color: white; color:#424040; border-color:#424040;"
    todos_button.style = "background-color: white; color:#424040; border: inset; border-width: 1px; border-color:#424040;"
}

function moderado() {
    status = "moderado";
    incrementar.innerHTML = `<img src="./img/gifSmy.gif" style="height: 270px;" alt="">`
    moderado_button.style = "background-color: orange; font-weight: 550; color: white; border: none;"
    critico_button.style = "background-color: white; color:#424040; border-color:#424040;"
    ok_button.style = "background-color: white; color:#424040; border-color:#424040;"
    todos_button.style = "background-color: white; color:#424040; border: inset; border-width: 1px; border-color:#424040;"
}

function ok() {
    status = "ok";
    incrementar.innerHTML = `<img src="./img/gifSmy.gif" style="height: 270px;" alt="">`
    ok_button.style = "background-color: green; font-weight: 550; color: white; border: none;"
    critico_button.style = "background-color: white; color:#424040; border-color:#424040;"
    moderado_button.style = "background-color: white; color:#424040; border-color:#424040;"
    todos_button.style = "background-color: white; color:#424040; border: inset; border-width: 1px; border-color:#424040;"
}

function todos() {
    status = "todos";
    incrementar.innerHTML = `<img src="./img/gifSmy.gif" style="height: 270px;" alt="">`
    ok_button.style = "background-color: white; color:#424040; border-color:#424040;"
    critico_button.style = "background-color: white; color:#424040; border-color:#424040;"
    moderado_button.style = "background-color: white; color:#424040; border-color:#424040;"
    todos_button.style = "background-color: #73CAF6;color: white; border:none;"
}

function inserirAlertas() {

    for (let i = 0; i < funcionarios.length; i++) {
        idFuncionario = funcionarios[i].idFuncionario;
        funcionario = funcionarios[i].nomeFuncionario;
        porcentagemCPU = funcionarios[i].porcentagemUsoCPU;
        porcentagemRAM = funcionarios[i].porcentagemUsoRAM;
        porcentagemDisco = funcionarios[i].porcentagemUsoDisco;

        let corPorcentagemCPU;
        let corPorcentagemRAM;
        let corPorcentagemDisco;
        let imgStatus;


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
            imgStatus = "./img/pc-ok.svg"
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
                imgStatus = "./img/pc-alerta.svg"
            } else {
                imgStatus = "./img/pc-critico.svg"
            }


        if (status == "todos") {
            incrementar.innerHTML += `
        <a class="computador" onclick="entrarNoGrafico(\'${idFuncionario}\', \'${funcionario}\')">
            <div class="container-pc">
                <div class="computador-estado">
                    <img src="${imgStatus}" alt="">
                </div>
                <div class="nome-funcionario">
                    <label id="nomeFuncionario">${funcionario}</label>
                </div>
                <div class="porcentagem-uso">
                    <div class="CPU">
                        <div class="label-cpu">
                            <img src="./img/cpu-icon.svg" alt="">
                            <label>CPU</label>
                        </div>
                        <div class="porcentagem-cpu">
                            <label id="usoCPU"style="color:${corPorcentagemCPU}">${porcentagemCPU}%</label>
                        </div>
                    </div>

                    <div class="RAM">
                        <div class="label-ram">
                            <img src="./img/ram-icon.svg" alt="">
                            <label>RAM</label>
                        </div>
                        <div class="porcentagem-ram">
                            <label id="usoRAM"style="color:${corPorcentagemRAM}">${porcentagemRAM}%</label>
                        </div>
                    </div>

                    <div class="DISCO">
                        <div class="label-disco">
                            <img src="./img/disk-icon.svg" alt="">
                            <label>Disco</label>
                        </div>
                        <div class="porcentagem-disco">
                            <label id="usoDisco" style="color:${corPorcentagemDisco}">${porcentagemDisco}%</label>
                        </div>
                    </div>
                </div>
            </div>
        </a>
        `
        } else if (status == "critico") {
            if (imgStatus == "./img/pc-critico.svg") {
                incrementar.innerHTML += `
        <a class="computador" onclick="entrarNoGrafico(\'${idFuncionario}\', \'${funcionario}\')">
            <div class="computador-estado">
                <img src="${imgStatus}" alt="">
            </div>
            <div class="nome-funcionario">
                <label id="nomeFuncionario">${funcionario}</label>
            </div>
            <div class="porcentagem-uso">
                <div class="CPU">
                    <div class="label-cpu">
                        <img src="./img/cpu-icon.svg" alt="">
                        <label>CPU</label>
                    </div>
                    <div class="porcentagem-cpu">
                        <label id="usoCPU"style="color:${corPorcentagemCPU}">${porcentagemCPU}%</label>
                    </div>
                </div>

                <div class="RAM">
                    <div class="label-ram">
                        <img src="./img/ram-icon.svg" alt="">
                        <label>RAM</label>
                    </div>
                    <div class="porcentagem-ram">
                        <label id="usoRAM"style="color:${corPorcentagemRAM}">${porcentagemRAM}%</label>
                    </div>
                </div>

                <div class="DISCO">
                    <div class="label-disco">
                        <img src="./img/disk-icon.svg" alt="">
                        <label>Disco</label>
                    </div>
                    <div class="porcentagem-disco">
                        <label id="usoDisco" style="color:${corPorcentagemDisco}">${porcentagemDisco}%</label>
                    </div>
                </div>
            </div>
        </a>
        `
            }
        } else if (status == "moderado") {
            if (imgStatus == "./img/pc-alerta.svg") {
                incrementar.innerHTML += `
        <a class="computador" onclick="entrarNoGrafico(\'${idFuncionario}\', \'${funcionario}\')">
            <div class="computador-estado">
                <img src="${imgStatus}" alt="">
            </div>
            <div class="nome-funcionario">
                <label id="nomeFuncionario">${funcionario}</label>
            </div>
            <div class="porcentagem-uso">
                <div class="CPU">
                    <div class="label-cpu">
                        <img src="./img/cpu-icon.svg" alt="">
                        <label>CPU</label>
                    </div>
                    <div class="porcentagem-cpu">
                        <label id="usoCPU"style="color:${corPorcentagemCPU}">${porcentagemCPU}%</label>
                    </div>
                </div>

                <div class="RAM">
                    <div class="label-ram">
                        <img src="./img/ram-icon.svg" alt="">
                        <label>RAM</label>
                    </div>
                    <div class="porcentagem-ram">
                        <label id="usoRAM"style="color:${corPorcentagemRAM}">${porcentagemRAM}%</label>
                    </div>
                </div>

                <div class="DISCO">
                    <div class="label-disco">
                        <img src="./img/disk-icon.svg" alt="">
                        <label>Disco</label>
                    </div>
                    <div class="porcentagem-disco">
                        <label id="usoDisco" style="color:${corPorcentagemDisco}">${porcentagemDisco}%</label>
                    </div>
                </div>
            </div>
        </a>
        `
            }
        } else if (status == "ok") {
            if (imgStatus == "./img/pc-ok.svg") {
                incrementar.innerHTML += `
        <a class="computador" onclick="entrarNoGrafico(\'${idFuncionario}\', \'${funcionario}\')">
            <div class="computador-estado">
                <img src="${imgStatus}" alt="">
            </div>
            <div class="nome-funcionario">
                <label id="nomeFuncionario">${funcionario}</label>
            </div>
            <div class="porcentagem-uso">
                <div class="CPU">
                    <div class="label-cpu">
                        <img src="./img/cpu-icon.svg" alt="">
                        <label>CPU</label>
                    </div>
                    <div class="porcentagem-cpu">
                        <label id="usoCPU"style="color:${corPorcentagemCPU}">${porcentagemCPU}%</label>
                    </div>
                </div>

                <div class="RAM">
                    <div class="label-ram">
                        <img src="./img/ram-icon.svg" alt="">
                        <label>RAM</label>
                    </div>
                    <div class="porcentagem-ram">
                        <label id="usoRAM"style="color:${corPorcentagemRAM}">${porcentagemRAM}%</label>
                    </div>
                </div>

                <div class="DISCO">
                    <div class="label-disco">
                        <img src="./img/disk-icon.svg" alt="">
                        <label>Disco</label>
                    </div>
                    <div class="porcentagem-disco">
                        <label id="usoDisco" style="color:${corPorcentagemDisco}">${porcentagemDisco}%</label>
                    </div>
                </div>
            </div>
        </a>
        `
            }
        }
    }


}

function obterNomeFunc() {

    var fkEmpresa = sessionStorage.fk_empresa_meuapp;

    // console.log('entrou na função')
    fetch(`/leituras/recuperarFuncionario/${fkEmpresa}`)
        .then(resposta => {
            console.log('fetch')

            if (resposta.ok) {
                resposta.json().then(function (resposta_json) {
                    console.log(resposta_json)
                    funcionarios = resposta_json;

                    incrementar.innerHTML = ``;

                    inserirAlertas()


                });
            } else {

                console.error('deu ruim');
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados do computador p/ gráfico: ${error.message}`);
        });
}

setInterval(obterNomeFunc, 3000);


function entrarNoGrafico(idFuncionario, nomeFuncionario) {
    sessionStorage.setItem("idFuncionario", idFuncionario)
    sessionStorage.setItem("funcionario", nomeFuncionario)
    window.location.href = '../Dashboard/historico.html';
}
let login_usuario;
let nome_usuario;

function redirecionar_login() {
    window.location.href = '../Site/login.html';
}

function verificar_autenticacao() {
    login_usuario = sessionStorage.login_usuario_meuapp;
    nome_usuario = sessionStorage.nome_usuario_meuapp;

    console.log(nome_usuario)
    
    if (login_usuario == undefined)  {
        redirecionar_login();
    } else {
        nome_funcionario.innerHTML = nome_usuario;
        validar_sessao();
        
    }
    
}

function logoff() {
    finalizar_sessao();
    sessionStorage.clear();
    redirecionar_login();
}

function validar_sessao() {
    fetch(`/usuarios/sessao/${login_usuario}`, {cache:'no-store'})
    .then(resposta => {
        if (resposta.ok) {
            resposta.text().then(texto => {
                console.log('Sessão :) ', texto);  
                  
            });
        } else {
            console.error('Sessão :.( ');
            console.log("PUTA 2")
            logoff();
        } 
    });    
}

function finalizar_sessao() {
    fetch(`/usuarios/sair/${login_usuario}`, {cache:'no-store'}); 
}
const menu = document.querySelector('.menu-lateral');
const conteudo = document.querySelector('.container')
const logo = document.querySelector('.logo-img-class')
const logoEnxuto = document.querySelector('.logo-img-class-enxuto');
const logoLinha = document.querySelector('.menu-logo-img')
const bemVindoIcone = document.querySelector('.bem-vindo-icone')
const bemVindoTexto = document.querySelector('.bem-vindo-conteudo')
const itemMenuTexto1 = document.querySelector('.item-label1')
const itemMenuTexto2 = document.querySelector('.item-label2')
const logout = document.querySelector('.logout-label')
const logoutEnxuto = document.querySelector('.logout-icone-img')

document.querySelector('.menu-logo').onclick = function () {
    this.classList.toggle('active');
    menu.classList.toggle('active');
    conteudo.classList.toggle('active');
    logo.classList.toggle('active');
    logoEnxuto.classList.toggle('active');
    logoLinha.classList.toggle('active')
    bemVindoIcone.classList.toggle('active');
    bemVindoTexto.classList.toggle('active');
    itemMenuTexto1.classList.toggle('active');
    itemMenuTexto2.classList.toggle('active');
    logout.classList.toggle('active');
    logoutEnxuto.classList.toggle('active');
}
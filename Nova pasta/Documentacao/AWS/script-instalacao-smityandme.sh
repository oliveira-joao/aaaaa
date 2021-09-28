#!/bin/bash

PURPLE='0;35'
NC='\033[0m'
VERSAO=11

echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Olá funcionario! Irei te auxiliar na instalação da nossa solução SmityAndMe!;"

echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Primeiro de tudo, precisamos instalar o Java, vamos verificar se você o possui instalado...;"

java -version

    if [ $? -eq 0 ]

        then

            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Legal! Você já tem o java instalado $(tput setaf 213)❤$(tput setaf 7)"
                
            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Agora iremos instalar o executável da nossa aplicação..."

            sleep 4

            wget https://github.com/Pederzini/SmityAndMe/raw/main/Aplicacao/aplicacao-smityandme/target/SmityAndMe.jar
            
            touch smity.cfg

            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Pronto! Agora nosso executável está instalado e você pode realizar seus monitoramentos. $(tput setaf 213)$(tput setaf 7)"

            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Para prosseguir com a nossa instalação, vamos fazer a instalação do nosso container com MySQL"

            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Antes de tudo, precisamos instalar o Docker, vamos verificar se você já o possui instalado...;"

            sleep 4

            clear

            docker --version

            if [ $? -eq 0 ]

                then

                        echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Muito bom! Você já possui o Docker instalado $(tput setaf 213)皿$(tput setaf 7) "
                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Obrigado por fazer a instalação da nossa aplicação e até a próxima! $(tput setaf 213)❤$(tput setaf 7)"

                    else

                        echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Não foi encontrado nenhuma versão do Docker, mas fique tranquilo que iremos instalar para você! "

                        echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Vamos primeiro certificar de que o seu sistema está atualizado, só um momento... "

                        sleep 4

                        sudo apt update

                        echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Pronto, agora vamos prosseguir com a instalação do Docker $(tput setaf 213)皿$(tput setaf 7) "

                        clear

                        sudo apt install docker.io

                        sudo systemctl start docker

                        sudo systemctl enable docker
                        
                        clear

                        docker --version

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Pronto, o nosso container está instalado e pronto para instalar o MySQL"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Instalando a imagem do MySQL no nosso container ..."

                        sleep 4

                        clear

                        sudo docker pull mysql:5.7

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Imagem instalada com sucesso!"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Vamos agora criar o banco de dados e as credenciais de acesso..."

                        sleep 4

                        sudo docker run -d -p 3306:3306 --name ContainerSmyBD -e "MYSQL_DATABASE=SmyDB" -e "MYSQL_USER=Smy" -e "MYSQL_PASSWORD=smy100" -e "MYSQL_ROOT_PASSWORD=smy100" -e "MYSQL_ROOT_HOST=172.17.0.1" mysql:5.7

                        clear
                        
cat > CredenciaisContainer.txt <<EOF
Container: ContainerSmyDB
Banco: SmyDB
Usuário: Smy
Senha: smy100
EOF

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Suas credenciais de acesso"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) --------------------------"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Container: ContainerSmyDB"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Banco: SmyDB"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Usuário: Smy"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Senha: smy100"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) --------------------------"
                        
                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Criamos um arquivo de texto chamado $(tput setaf 213)CredenciaisContainer.txt$(tput setaf 7) com as credenciais para você caso as esqueça! "

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Com isso finalizamos a instalação do nosso Docker implementado com o MySQL"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Só uma última coisa ... Não exclua o arquivo $(tput setaf 213)smity.cfg$(tput setaf 7), ele foi criado pelo script e é essencial para nossa aplicação funcionar!"

                        echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Agora sim, obrigado por fazer a instalação da nossa aplicação e até a próxima! $(tput setaf 213)❤$(tput setaf 7)"

                        fi

        else

            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Poxa, não encontrei nenhuma versão do Java instalada. Mas deixa conosco, que iremos instalar para você!"

            echo "$(tput setaf 213)[Smy assistant]:$(tput setaf 7) Só pra confirmar, você me autoriza a instalar o Java (S/N)?"

            read inst

            if [ \"$inst\" == \"s\" ] || [ \"$inst\" == \"S\" ]

                then

                    echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7)  Oba, você escolheu instalar o Java $(tput setaf 213)❤$(tput setaf 7)"

                    echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7)  Adicionando o repositório!"

                    sleep 2

                    sudo add-apt-repository ppa:webupd8team/java -y

                    clear

                    echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7)  Atualizando! Quase lá."

                    sleep 2

                    sudo apt update -y

                    clear

                    if [ $VERSAO -eq 11 ]

                        then

                            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Preparando para instalar a versão 11 do Java. Confirme a instalação quando solicitado ;D"

                            sudo apt install default-jre ; apt install openjdk-11-jre-headless; -y

                            clear

                            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Java instalado com sucesso!"

                            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Agora iremos instalar o executável da nossa aplicação..."

                            sleep 4

                            wget https://github.com/Pederzini/SmityAndMe/raw/main/Aplicacao/aplicacao-smityandme/target/SmityAndMe.jar
                            
                            touch smity.cfg

                            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Pronto! Agora nosso executável está instalado e você pode realizar seus monitoramentos. $(tput setaf 213)$(tput setaf 7)"

                            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Para prosseguir com a nossa instalação, vamos fazer a instalação do nosso container com MySQL"

                            echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Antes de tudo, precisamos instalar o Docker, vamos verificar se você já o possui instalado...;"

                            sleep 4

                            clear

                            docker --version

                            if [ $? -eq 0 ]

                                then

                                    echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Muito bom! Você já possui o Docker instalado $(tput setaf 213)皿$(tput setaf 7) "

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Obrigado por fazer a instalação da nossa aplicação e até a próxima! $(tput setaf 213)❤$(tput setaf 7)"

                                else

                                    echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Não foi encontrado nenhuma versão do Docker, mas fique tranquilo que iremos instalar para você! "

                                    echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Vamos primeiro certificar de que o seu sistema está atualizado, só um momento... "

                                    sleep 4

                                    sudo apt update

                                    echo "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Pronto, agora vamos prosseguir com a instalação do Docker $(tput setaf 213)皿$(tput setaf 7) "

                                    clear

                                    sudo apt install docker.io

                                    sudo systemctl start docker

                                    sudo systemctl enable docker
                                    
                                    clear

                                    docker --version

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Pronto, o nosso container está instalado e pronto para instalar o MySQL"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Instalando a imagem do MySQL no nosso container ..."

                                    sleep 4

                                    clear

                                    sudo docker pull mysql:5.7

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Imagem instalada com sucesso!"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Vamos agora criar o banco de dados e as credenciais de acesso..."

                                    sleep 4

                                    sudo docker run -d -p 3306:3306 --name ContainerSmyDB -e "MYSQL_DATABASE=SmyDB" -e "MYSQL_USER=Smy" -e "MYSQL_PASSWORD=smy100" -e "MYSQL_ROOT_PASSWORD=smy100" -e "MYSQL_ROOT_HOST=172.17.0.1" mysql:5.7

                                    clear
                                    
cat > CredenciaisContainer.txt <<EOF
Container: ContainerSmyDB
Banco: SmyDB
Usuário: Smy
Senha: smy100
EOF

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Suas credenciais de acesso"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) --------------------------"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Container: ContainerSmyDB"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Banco: SmyDB"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Usuário: Smy"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Senha: smy100"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) --------------------------"
                                    
                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Criamos um arquivo de texto chamado $(tput setaf 213)CredenciaisContainer.txt$(tput setaf 7) com as credenciais para você caso as esqueça!"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Com isso finalizamos a instalação do nosso Docker implementado com o MySQL"
                                    
                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Só uma última coisa ... Não exclua o arquivo $(tput setaf 213)smity.cfg$(tput setaf 7), ele foi criado pelo script e é essencial para nossa aplicação funcionar!"

                                    echo  "$(tput setaf 213)[Smy Assistant]:$(tput setaf 7) Agora sim, obrigado por fazer a instalação da nossa aplicação e até a próxima! $(tput setaf 213)❤$(tput setaf 7)"

                                fi

                            fi

                    else

                        echo "$(tput setaf 213)[Smy assistant]:$(tput setaf 7)  Você optou por não instalar o Java por enquanto, até a próxima então!"

            fi  

    fi

# ===================================================================
# Todos direitos reservados para o autor: Dra. Profa. Marise Miranda.
# Sob licença Creative Commons @2020
# Podera modificar e reproduzir para uso pessoal.
# Proibida a comercialização e a exclusão da autoria.
# ===================================================================


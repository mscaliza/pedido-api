# pedido-api

#Subir docker postgresql
docker run -p 5432:5432 -v /tmp/database:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres -d postgres

Comandos básicos do docker
docker pull postgres = baixa a imagem docker do postgres
docker ps = lista os container que estão rodando
docker ps -a = lista os container que estão rodando e estão parados
docker stop + nome do container = para execução do container
docker start + nome do container = inicia o container
docker rmi $(docker images -a -q) = remove imagem
docker run --rm image_name = remove um container
docker rm $(docker ps -a -f status=exited -q) = remove todos container
docker stop $(docker ps -a -q) = parar todos os container
docker rm $(docker ps -a -q) = remove todos os container
docker volume ls = lista todos os volumes
docker volume rm volume_name volume_name = remove o volume
docker volume prune = remove todos os volumes sem dó

#Criar repositório no github e lincar com a máquina local
echo "# pedido-api" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin 
git push -u origin main


#Comandos basicos do git
https://www.hostinger.com.br/tutoriais/comandos-basicos-de-git



"# pedido-api" 

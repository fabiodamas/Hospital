# Getting Started

### H2 CONSOLE
http://localhost:8080/h2-console

### Swagger
http://localhost:8080/swagger-ui.html#/

### Docker
docker build  -t teste . <br>
docker run -p 8080:8080 teste <br>
docker run -ti /bin/sh teste <br>
docker run -ti --entrypoint /bin/sh teste (Entrar no modo interativo linha de comando) <br>
docker run -d -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock portainer/portainer (Ferramenta do docker para ver os containers) <br>


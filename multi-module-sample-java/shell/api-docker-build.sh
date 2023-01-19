cd ..
docker stop spring-server-container
docker rm spring-server-container
docker rmi spring-server

docker build -f Dockerfile-api . -t spring-server
docker run -d -p 8080:8080 --name spring-server-container spring-server
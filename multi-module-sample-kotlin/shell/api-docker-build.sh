cd ..
docker stop spring-server-container
docker rm spring-server-container
docker rmi spring-server

docker build -f Dockerfile-api . -t kotlin-spring-server
docker run -d -p 8080:8080 --name kotlin-spring-server-container kotlin-spring-server
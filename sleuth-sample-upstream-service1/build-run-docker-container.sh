mvn clean package -P docker
docker build -t mdaros/sleuth-sample-upstream-service1 .
docker run --rm --name sleuth-sample-upstream-service1 -p 8080:8080 --net elk-stack_default mdaros/sleuth-sample-upstream-service1
mvn clean package -P docker
docker build -t mdaros/sleuth-sample-upstream-service2 .
docker run --rm --name sleuth-sample-upstream-service2 -p 9090:9090 --net elk-stack_default mdaros/sleuth-sample-upstream-service2
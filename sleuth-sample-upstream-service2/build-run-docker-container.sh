mvn clean package -P docker
docker build -t mdaros/sleuth-sample-upstream-service2 .
docker run --rm --name sleuth-sample-upstream-service2 -p 9090:9090 -v $PWD/../environment/logs/upstream-service2:/usr/share/logs/upstream-service2:rw --net elk-stack_default mdaros/sleuth-sample-upstream-service2
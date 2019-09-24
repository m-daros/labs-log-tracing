mvn clean package -P docker
docker build -t mdaros/sleuth-sample-upstream-service1 .

docker run --rm --name sleuth-sample-upstream-service1 -p 8080:8080 -v $PWD/../environment/elk-stack/logs/upstream-service1:/usr/share/logs/upstream-service1:rw --net elk-stack_default mdaros/sleuth-sample-upstream-service1
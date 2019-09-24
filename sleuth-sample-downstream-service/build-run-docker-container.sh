mvn clean package -P docker
docker build -t mdaros/sleuth-sample-downstream-service .

docker run --rm --name sleuth-sample-downstream-service -p 10090:10090 -v $PWD/../environment/elk-stack/logs/downstream-service:/usr/share/logs/downstream-service:rw --net elk-stack_default mdaros/sleuth-sample-downstream-service
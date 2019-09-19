mvn clean package -P docker
docker build -t mdaros/sleuth-sample-downstream-service .
docker run --rm --name sleuth-sample-downstream-service -p 10090:10090 --net elk-stack_default mdaros/sleuth-sample-downstream-service
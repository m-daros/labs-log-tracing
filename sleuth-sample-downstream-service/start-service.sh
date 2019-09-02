export LOG_PATH=../environment/elk-stack/logs/downstream-service
export LOG_FILE=sleuth-sample-downstream-service.log
APM_AGENT_PATH=../environment/elk-stack/elastic-apm-agent-1.9.0.jar

#java -javaagent:$APM_AGENT_PATH -Delastic.apm.service_name=sleuth-sample-downstream-service -Delastic.apm.server_urls=http://http://localhost:8200/ -Delastic.apm.secret_token= -Delastic.apm.application_packages=mdaros.labs -jar target/sleuth-sample-downstream-service-0.0.1-SNAPSHOT.jar
java -javaagent:../environment/elk-stack/elastic-apm-agent-1.9.0.jar -Delastic.apm.service_name=sleuth-sample-downstream-service -Delastic.apm.server_urls=http://http://localhost:8200/ -Delastic.apm.secret_token= -Delastic.apm.application_packages=mdaros.labs -jar target/sleuth-sample-downstream-service-0.0.1-SNAPSHOT.jar
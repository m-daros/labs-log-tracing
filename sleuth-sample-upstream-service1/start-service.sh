export LOG_PATH=../environment/elk-stack/logs/upstream-service1
export LOG_FILE=sleuth-sample-upstream-service1
APM_AGENT_PATH=../environment/elk-stack/elastic-apm-agent-1.9.0.jar

#java -javaagent:$APM_AGENT_PATH -Delastic.apm.service_name=sleuth-sample-upstream-service1 -Delastic.apm.server_url=http://localhost:8200 -Delastic.apm.secret_token= -Delastic.apm.application_packages=mdaros.labs -jar target/sleuth-sample-upstream-service1-0.0.1-SNAPSHOT.jar
java -javaagent:../environment/elk-stack/elastic-apm-agent-1.9.0.jar -Delastic.apm.service_name=sleuth-sample-upstream-service1 -Delastic.apm.server_urls=http://localhost:8200 -Delastic.apm.secret_token= -Delastic.apm.application_packages=mdaros.labs -jar target/sleuth-sample-upstream-service1-0.0.1-SNAPSHOT.jar
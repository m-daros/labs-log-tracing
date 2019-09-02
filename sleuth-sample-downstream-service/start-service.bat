SET LOG_PATH=..\environment\elk-stack\logs\downstream-service
SET LOG_FILE=sleuth-sample-downstream-service
SET APM_AGENT_PATH=..\environment\elk-stack\elastic-apm-agent-1.9.0.jar

java -javaagent:%APM_AGENT_PATH% -Delastic.apm.service_name=sleuth-sample-downstream-service -Delastic.apm.server_urls=http://http://192.168.99.100:8200/ -Delastic.apm.secret_token= -Delastic.apm.application_packages=mdaros.labs -jar target\sleuth-sample-downstream-service-0.0.1-SNAPSHOT.jar
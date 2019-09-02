SET LOG_PATH=..\environment\elk-stack\logs\upstream-service1
SET LOG_FILE=sleuth-sample-upstream-service1
SET APM_AGENT_PATH=..\environment\elk-stack\elastic-apm-agent-1.9.0.jar

java -javaagent:%APM_AGENT_PATH% -Delastic.apm.service_name=sleuth-sample-upstream-service1 -Delastic.apm.server_urls=http://192.168.99.100:8200 -Delastic.apm.secret_token= -Delastic.apm.application_packages=mdaros.labs -jar target\sleuth-sample-upstream-service1-0.0.1-SNAPSHOT.jar
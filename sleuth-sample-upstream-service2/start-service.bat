SET LOG_PATH=..\environment\elk-stack\logs\upstream-service2
SET LOG_FILE=sleuth-sample-upstream-service2
SET APM_AGENT_PATH=..\environment\elk-stack\elastic-apm-agent-1.9.0.jar

java -javaagent:%APM_AGENT_PATH% -Delastic.apm.service_name=sleuth-sample-upstream-service2 -Delastic.apm.server_urls=http://192.168.99.10:8200 -Delastic.apm.secret_token= -Delastic.apm.application_packages=mdaros.labs -jar target\sleuth-sample-upstream-service2-0.0.1-SNAPSHOT.jar
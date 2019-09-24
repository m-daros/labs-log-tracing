FROM java:8-jdk-alpine

COPY ./target/sleuth-sample-upstream-service2-0.0.1-SNAPSHOT.jar /usr/app/
COPY ./target/elastic-apm-agent-1.9.0.jar /usr/app/

WORKDIR /usr/app

ENV LOG_PATH=/usr/share/logs/upstream-service2
ENV LOG_FILE=sleuth-sample-upstream-service2.log
ENV APM_AGENT_PATH=./elastic-apm-agent-1.9.0.jar

VOLUME [ "/usr/share/logs/upstream-service2" ]

RUN sh -c 'touch sleuth-sample-upstream-service2-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java", "-javaagent:./elastic-apm-agent-1.9.0.jar", "-Delastic.apm.service_name=sleuth-sample-upstream-service2", "-Delastic.apm.server_urls=http://http://elk-stack_apm-server_1:8200/", "-Delastic.apm.secret_token=", "-Delastic.apm.application_packages=mdaros.labs", "-Dspring.profiles.active=docker", "-jar", "sleuth-sample-upstream-service2-0.0.1-SNAPSHOT.jar"]
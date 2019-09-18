# labs-log-tracing

The aims of this lab is to reason about complexity related to decomposition of  an application in small microservices having each one multiple instances, its own log files an every one interacting to one or more service in order to offer a broader functionality.

We address two concerns:

- **Logs aggregation**

  When an application is decomposed in small pieces and every service can have one or more instances how can we retrieve the necessary info on log files in order to debug a problem? Can we find the location of every log file, can we access every one and find what we're searching for? 

  Obviously not: we need a single well known place where all logs are collected and accessible and we also need a way to search the info we need.

  

- **Distributed Tracing**

  If our application is affected by poor throughput, all computations takes long time to complete, or everyting is fine but sometime something happens and we can observe performance degradation, how can we found where is the problem if the degraded use case is spanned across many and many microservices? Is there one of the pieces where we have a bottleneck? How can we found where a transaction is taking the majority of the computation time?



Our sample application is composed by one downstream microservice that call other two upstream microservices

- **downstream-service**
- **upstream-service1**
- **upstream-service2**



The downstream service exposes a REST endpoint [http://localhost:10090/customers-info/{customer-id}](http://localhost:10090/customers-info/{customer-id}) and retrieves info related to a Customer given the customer id

The needed info are retrieved calling the upstream services in order to retrieve info related to:

Customers [http://localhost:8080/customers/{customer-id}](http://localhost:8080/customers/{customer-id})

Customer addresses [http://localhost:9090/addresses/customer/{customer-id}](http://localhost:9090/addresses/customer/{customer-id})



The info are composed and returned to the client

The application is described in the following picture:



![](docs/images/labs-log-tracing.png)



In our lab we can support both **logs aggregation** and **distributed tracing** using the **Elastic stack**

http://elastic.co as described in the following image



![](docs/images/elastic-stack-with-apm.png)

Related to logs aggregation perspective:

Logs are collected by Beats (FIlebeat in our case) on every microservice machine or container, elaborated by Logstash (Extract Transform Load), ingested into Elasticsearch and then managed and visualized on Kibana in order to search the needed informations collected into logs.



Related to distributed tracing:

The Elastic APM stack can get trace info on every microservice machine or container using APM agents and collect them in Elasticsearch through an APM server.

APM data dan be visualized in Kibana using dedicated APM dashboards.



### Prerequisites

- Java 8
- Docker
- Docker Compose



### How to  start the Elastic stack

The Elastic stack is provided as a set of Docker containers and managed as Docker Compose file **environment/elk-stack/docker-compose.yml**

In order to start the Elastic search, please open a shell window and type the following commands

`cd $PROJECT_HOME/environment/elk-stack`

`docker-compose up`



Docker Compose will start a set of Docker containers for the following components

**Elasticsearch** on ports 9200, 9300

**Kibana** on port 5601

**Logstash** on ports 5400, 9600



**Filebeat**

Filebeat is configured to scan log files on your laptop on folder $PROJECT_HOME/environments/logs/*/\*.log

This scan log files with .log extension on every subfolder on $PROJECT_HOME/environments/logs



**APM Server** on port 8200



### How to start microservices

The application is a Maven project composed by  the following maven modules

- **downstream-service**
- **upstream-service1**
- **upstream-service2**

every one is a **Spring Boot** microservice



In order to start the microservices, open 3 different shell windows and type the following commands

**TODO Rename microservices folders on project structure** !!



On first shell window

`cd $PROJECT_HOME/downstream-service``

`./start-service.sh`



On second shell window

`cd $PROJECT_HOME/upstream-service1`

`./start-service.sh`



On third shell window

`cd $PROJECT_HOME/upstream-service2`

`./start-service.sh`
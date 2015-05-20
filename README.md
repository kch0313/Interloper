This project is the Spring REST API for deleting Activiti process instances that are in flight.
## Getting Started

-- This is an STS project, it runs Spring boot. 

### Prerequisites

* MySQL
* Activiti 5.1.17
* RabbitMQ - https://www.rabbitmq.com/download.html

### Run the Application

Make sure the application properties point to a Valid MySQL database.  The database is not actually used
at this point, but put there as placeholder for future use.

Ensure that Rabbit MQ is installed and running.  The application uses RabbitMQ to create an async request that can be handled and scaled beyond the capabilities of the web rest interface. 

from the command line:
mvn clean install -- builds the application

mvn spring-boot:run

### Invoke the Interloper Killer

Find the activti process you want to kill

http://localhost:8080/activiti-rest/service/runtime/process-instances/

{"data":[{"id":"15016","url":"http://localhost:8080/activiti-rest/service/runtime/process-instances/15016","businessKey":null,"suspended":false,"ended":false,"processDefinitionId":"fixSystemFailure:1:37","processDefinitionUrl":"http://localhost:8080/activiti-rest/service/repository/process-definitions/fixSystemFailure:1:37","activityId":null,"variables":[],"tenantId":"","completed":false}],"total":1,"start":0,"sort":"id","order":"asc","size":1}

locate the id, in the case above it is:id":"15016

Invoke the interloper:
http://localhost:8081/killproc?id=15016
If the request was successfully handed off to the queue you will see the a status code of 200 Success.

### Debugging
mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

# Interloper

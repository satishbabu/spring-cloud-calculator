# Spring Cloud Microservices
This project will have microservices using spring cloud.  Following Microservices is being planned
* Calculator - Calculates price of a Trade
* Market Data - Provides stock price
* Gateway - Uses to keep the services location independent.  Spring uses Netflix Zuul under the hood
* Tracer - Used to help tracing.  Spring uses zipkin under the hood

Also, I may add the Spring configuration server to hold the prorperties across environments.  Holding off on that to keep things simple 



## Ports

| Service | Port |
| ------- | ---- |
| Calculator | 8080 |
| Market Data | 8090 |
| Gateway | 8765 |
| Zipkin | 9411 |




## Development Plan

I plan to build it in layers using git branches.  Imagine onion and the initial version will be core and every layer will add small functionality


## Added JPA to market data service (branch add_jpa_to_market_data)
Add the JPA.  Uses H2 in memory database.  The data.sql inserts data afer creating H2 database.  Also, the H2 database is created automatically.

## Tie things together using RestClient (branch rest_client)
Visti http://localhost:8080/calculatePrice/intl/100 to get the price for 100 intl shares.  The url is of the format http://localhost:8080/calculatePrice/{symbol}/{quantity}

## add_feign_proxy
Calling service using RestClient is ugly.  Replaced it with OpenFeign from Netflix.  All we need to do is create an interface and spring cloud will create the implementation for calling the microservice.

## add_zuul_api_gateway
Added Zuul API Gateway.  Updated Proxy in Calculator to use API gateway when it calls Market Data Service.  Added a filter in gateway to log all calls.  Visit http://localhost:8765/calculator-service/calculatePrice/intl/100 to get price for 100 intl shares.  The url is of the format http://localhost:8080/{application-name}/calculatePrice/{symbol}/{quantity}

## add_sleuth_distributed_tracing
Added Sleuth to all 3 projects.  Added log statement where missing.  An ID is generated at the api gate way and it is propagated to calculator service and market data service.  Visit http://localhost:8765/calculator-service/calculatePrice/intl/100 and check out the logs on all 3 services.  They all will have same span id.


## add_zipkin
Updated the pom.xml files on all 3 projects to include the zipkin libraries and springboot takes care of rest.  The spring.application.name was in-correct and it was corrected so that sleuth start writing the application name into logs.

Download zipkin from maven using URL https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec.  Then start zipkin server using java -jar zipkin-server-xxx.jar.  Visit http://localhost:9411/zipkin/ and click on Find Traces.  If Traces doesn't show up then restart services of all 3 services so that they can find zipkin and get ready to send information over.

Good talk on Zipkin by Adrian Cole (@adrianfcole) https://www.youtube.com/watch?v=f9J1Av8rwCE.  Advice is start small, fail fast avoid using plugins that you dont need.
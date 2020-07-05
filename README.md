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




## Development Plan

I plan to build it in layers using git branches.  Imagine onion and the initial version will be core and every layer will add small functionality


## Added JPA to market data service (branch add_jpa_to_market_data)
Add the JPA.  Uses H2 in memory database.  The data.sql inserts data afer creating H2 database.  Also, the H2 database is created automatically.

## Tie things together using RestClient (branch rest_client)
Visti http://localhost:8080/calculatePrice/intl/100 to get the price for 100 intl stocks.  The url is of the format http://localhost:8080/calculatePrice/{symbol}/{quantity}


# Market Data Service
This project will host a market data service.  The service provide the current price of the ticker symbols

### Use 
Hit end point http://localhost:8090/price/msft to get the current price of msft

Hit end point http://localhost:8090/h2-console to see what is in H2 database. This requires property spring.h2.console.enabled set to true. The data in insert.sql is populated automatically when the service is launched. 


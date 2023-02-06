# Environment Requirments
 * JDK 1.8
 * Maven
 * PostgreSQL server
# Steps to RUN and DEPLOY
The steps below are development env deployments.
 * Clone the repo.
 * If you already have a PostgreSQL server setup change the server properties in the application-local.properties accordingly otherwise
    use those properties to setup a new instance and create a database called anyminddb in both cases.
 * open a command line in the /points/ directory.

 * Run the following command:
    ```bash
    mvn spring-boot:run -Dspring.profiles.active=local
    ```
Now the application supposed to be up and running on localhost:8080.
# Interaction And Testing:
Now that the application is up and running we can interact with our api endpoints through integrated GraphQL UI provided by Spring Boot.
In order to do that we have to access this URL http://localhost:8080/graphiql?path=/graphql .
 * To test adding a payment use the below query:

 ```graphql
 mutation payment{
	pay(price:100,priceModifier:0.95,paymentMethod:MASTERCARD,datetime:"2023-01-01T00:00:00z"){
    points
    finalPrice
  }
} 
 ```
 * To Test getting the sales by hour within a certain range use the below query:

 ```graphql
query  {
  sales:salesPerHour(startDateTime: "2022-09-01T00:00:00z",endDateTime:"2022-09-01T04:00:00z"){
    datetime
    sales
    points
  }
  
}
  ```
# Technical Debt and improvement:
 * dividing the application into 2 separate service one for payments and the other is for sales analytics and use another jar module for common methods and logic.
 * Dockerization
 * Improve unit tests coverage

# Weather Manager REST API Project
### 📋The Brief
Project based on a public API to meet a set of requirements as detailed below :    
> - Weather API – Get weather information for a given location  
> - Create advice to determine how the user should prepare for a day outside (i.e. clothes/sunscreen/umbrella/coat etc)  

>> Additional Features implemented:
- Get advice for weather forecast of the next 4 calendar days (additional days require uprade to paid public API service
- Provide set of APIs for system administrator to add, modify or delete the busienss rules for generating advice based on weather condition
- Use Twilio API service to send weather advice of a location via SMS to an input mobile phone number 
-
## Table of contents
* [Acceptance criteria and assumptions](#acceptance-criteria-and-assumptions)
* [Technologies](#technologies)
* [How to run the project](#how-to-run-the-project)
* [System Design](#system-design)
* [Product Demo](#product-demo)
* [Project Presentation](#project-presentation-slides)

## Acceptance Criteria and Assumptions
Weather service should provide current weather conditions for a given location  
The advice message should provide the following information:  
 - Current temperature with suggested clothing for comfort and protection
 - Current wind speed with suggested precaution for driving
 - Current raining or snowing condition for using umbrella or snow precaution shoe
 - Current humidity level with advice of health precaution and comfort level

## Technologies
- java version 17
- apache-maven-3.9.0
- Spring/Spring Boot
- Postgres DB/Postgres SQL 42.5.1
- Swagger
  - http://localhost:8080/v3/api-docs
  - http://localhost:8080/swagger-ui.html
- Health check using Spring Boot Actuator
- Twilio SDK 8.8.0

## How to run the project
- On the command line execute :  
  `mvn spring-boot:run`

## System Design
https://app.diagrams.net/#Hweatherapiproject2023%2Fweather_api%2Fmain%2Fweather_api_get_request.drawio

## Product Demo
The following Youtube link provides a demo of the WeatherManager API:

https://www.youtube.com/watch?v=8ouwlSUoMQc

## Project Presentation Slides

https://github.com/weatherapiproject2023/weather_api/blob/main/Weather%20API-group-3.pdf


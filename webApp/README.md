# Objective:
The objective of this project is to build a web application that can provide
a more accurate delay prediction for OSU CABS(Campus Area Bus Service) riders.
With information provided by [CABS API], we are using java to fetch, clean, 
and process the data and then store it to a 1 * 96 vector, which each index
means a 15 minutes grid, since 15min*96=24hrs. Each grid will contain information
of average time from each stop pairs(A to B, B to C...), and store then using NoSQL 
for later increasing functionalities.


# Tasks:
- ## Frontend
  - ### Create a webpage using bootstrap 
    - `More tasks needed`
- ## Backend
  - ### Use docker to create a MongoDB and MongoDB Express `DONE` 
    - ### Create a Spring Boot project
      - #### Use MVC design 
      - `More tasks needed`





[CABS API]: <https://content.osu.edu/v2/bus/routes/CC/vehicles>
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
    - #### Input
      - #### There should be form for user to enter the start point and destination
    - #### Output
      - #### The application should return the estimate time to get to the destination with whether it might be faster to walk. 
    - #### fetch data from Google map API for comparision
      - #### fetch the time needed for walking and compare with the data from the backend.
    - `This is just basic functionalities for now.`
- ## Backend
  - ### Use docker to create a MongoDB and MongoDB Express `DONE` 
  - ### Create a Spring Boot project
    - #### use MVC design 
    - #### create REST API
    - ##### Process data and do daily update on the database
      - ###### a Bson file will be stored in the DB，and the Json will look like following
        - {
          "ID": "`ID`", \
          "clockWise": [ \
          { \
          "stopName": "`Ohio Union (Southbound)`", \
           "timeInSec": "`Time in second`", \
           }, \
          { \
          "stopName": "`Siebert Hall`", \
          "timeInSec": "`Time in second`", \
          }, \
          { \
          "stopName": "`Mack Hall`", \
          "timeInSec": "`Time in second`", \
          }, \
          { \
          "stopName": "`Herrick Transit Hub`", \
          "timeInSec": "`Time in second`", \
          }, \
          { \
          "stopName": "`Towers`", \
          "timeInSec": "`Time in second`", \
          }, \
          { \
          "stopName": "`St. John Arena (Westbound)`", \
          "timeInSec": "`Mid West Campus (Westbound)`", \
          }, \
          { \
          "stopName": "`Mid West Campus (Westbound)`", \
          "timeInSec": "`Mid West Campus (Westbound)`", \
          }, \
          { \
          "stopName": "`Bevis Hall`", \
          "timeInSec": "`Mid West Campus (Westbound)`", \
          }, \
          { \
          "stopName": "`Carmack 5 + Stop 1`", \
          "timeInSec": "`Mid West Campus (Westbound)`", \
          }, \
          ### `...`
          ], \
          "counterClockWise": [ \
          ### `...`
          ], \
          "storeDate": "`Date of the file stored`", \
          }
          - ###### The sequence is following:
            Stop Name = Ohio Union (Southbound) \
            Stop Name = Siebert Hall \
            Stop Name = Mack Hall \
            Stop Name = Herrick Transit Hub \
            Stop Name = Towers \
            Stop Name = St. John Arena (Westbound) \
            Stop Name = Mid West Campus (Westbound) \
            Stop Name = Bevis Hall \
            Stop Name = Carmack 5 + Stop 1 \
            Stop Name = Carmack 5 + Stop 2 \
            Stop Name = Research Center \
            Stop Name = Kinnear Road Lot \
            Stop Name = Blankenship Hall \
            Stop Name = Mid West Campus (Eastbound) \
            Stop Name = St. John East Bound \
            Stop Name = Knowlton Hall \
            Stop Name = Fontana Lab \
            Stop Name = Stillman Hall \
  - ### Set up Oracle cloud VM
    - #### configure spring boot application on the VM.
  - `More tasks needed`





[CABS API]: <https://content.osu.edu/v2/bus/routes/CC/vehicles>
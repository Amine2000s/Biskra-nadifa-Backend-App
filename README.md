# REST API For Biskra Nadifa Platform 

 "Biskra Nadifa "(means a Clean Biskra) , is a Waste Managment platform aims to Solve the Random trash Problem that Biskra City is  Struglling with through the Last years


## Platform Quick Explanation 

 our platform Targets 3 Categories :  

 - Citizens : who are  the citizens of biskra city , their Responsibiltiy is to report about the trash when they find it(sending that type of Trash , its Location , a Picture of it and an Optional Description of it if needed) and provide feedback by sending suggestions through our Mobile App

 
 - Driver : their main mission is to Go and clean the tasks that they were assigned to and update the status of that task when finished cleaning  and that happen also using our mobile App


 - System User : they are the Link between citizens Reports , and Driver's Tasks , from a side they do validate the citizen reports ,(specifically by checking on  the uploded picture of the trash ) and From the other Side Delegate the most suitable Trash Truck Driver to Clean it 

## General Architecture 
![general Architecture](/diagrams/general_architecture.png)

## ER Diagram 
![Entity Relation Diagram ](/diagrams/ER_diagram.png)
## Tech Stack
- Java
- Maven
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
## Modules
- System User Module
- Truck Driver Module
- Citizen Module Module
## Features
  
  * System User Features : 
    * Administrator Role of the entire Application
    * Checks the Validation of Submitted Reports 
    * Creates Tasks and Assign them to the suitable Driver


 * Citizen Features : 
   * Submit Reports With All Details (Report Type , Location , Picture for Proof ...)
   * Submit Suggestion for FeedBack
   

 * Driver Features : 
    * View All Assigned Tasks to the Driver 
    * Update Assigned Tasks Status (Completed , Not Completed, on Proccess ...)
## Installation & Run 

* Before running the API server, you should update the database config inside the [application.properties](E-Commerce-Backend\src\main\resources\application.properties) file.


* By Default the Api's Will be running on port 8083


* Update the port number, username and password as per your local database config.

```
    server.port=8083

    spring.datasource.url=jdbc:mysql://localhost:3306/biskranadifa_database
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint 

`https://localhost:8083/`

`http://localhost:8083/swagger-ui/index.html#/`



## API Module Endpoint 

### Citizen Module :

* `POST /citizens/Report ` : Upload a report 
* `POST /citizens/suggestion/{citizenId} ` : Upload a Suggestion
* `GET /citizens/bins ` : Get all Bins
* `GET /citizens/trash-collection-schedule ` : Get all trash collection schedule


### Truck Driver Module  : 

*  `GET /drivers/{driverId}/tasks`: Get all Tasks Assigned to the Driver with Given ID
*  `PATCH /drivers/{driverId}/{taskId}/update-task-status `: Update the status of given task  

### System Admin Module : 

* `GET /dashboard/drivers` : Get all Drivers
* `POST /dashboard/driver/create` : Create a Driver
* `GET /dashboard/reports` : Get all Reports
* `GET /dashboard/reports/{reportId}` : Get Report with given ID
* `DELETE /dashboard/reports/{reportId}` : Delete Report with Given ID
* `GET /dashboard/suggestions` : Get all Suggestions
* `GET /dashboard/tasks` : Get all Tasks
* `GET /dashboard/task/{taskId}` : Get Task with given ID
* `PUT /dashboard/assignTask/{reportId}/{systemuserId}/{driverId}` : Create Task with given Report ID, System User ID and Driver ID
* `PATCH /dashboard/tasks/{taskId}/modifiy-driver` : modify the Assigned Driver of Task with a New Driver
* `GET /dashboard/citizens` : Get all citizens
* `GET /dashboard/systemusers` : Get all system Users 
* `GET /dashboard/bins` : Get all bins
* `POST /dashboard/bin/create` : create a Bin
* `DELETE /dashboard/bin/{binId}` : delete a Bin with given ID
* `GET /dashboard/trashcollectionSchedule` : Get a list of All trash Collection Schedules 
* `GET /dashboard/trashcollectionSchedule/create` : create a trash Collection Schedule 

"Adding Project Startup flow" 

Pre Requisite :
================
1. Java-8
2. Maven
3. MySQL : version 5.x onwards
4. Server : Tomcat



Steps : 
===========

1. Download the Project from this repository.

2. Run/Execute the DB Scripts **(/resources/TradeManagementDBscript.sql)** in your MySQL DB.

3. Modify the application.yml as below : 

     uri : localhost: Provide your URL

     username: Provide your DB username.

     password: Provide your DB password.

3. Do Maven clean and install of this java project.

    a. From the command line : Go inside the project directory:  run the command maven clean install

    b. if you are using any tools like eclipse/sts/intellij, import the project as maven project. And then run maven clean and install.

4. Run the project as SpringBoot Application: 

  a. From command line: Go inside the project directory:  run the command **mvn spring-boot:run**

  b. if you are using

      I. Eclipse : Go inside the class which is annotated with @SpringBootApplication, run the main method as java project.


5. Hit the API from  :

 a. Postman: Postman collections are already available in **[/resources/TradesManagement.postman_collection.json**

 b. Swagger : Open the URL **[localhost:8080/swagger-ui.html]**.




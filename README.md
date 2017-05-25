
## About the App

  This is an application which does Album Management functionality. User can add an Album, which will be added to his Album list. User can read the list of his Albums, edit any of the Album in the Album list. User can delete any of his Album from the Album list.
  
# About the Framework - Spring BOOT

  Spring Boot makes it very easy to create Spring-powered application with a minimum of work. An application created with Spring Boot can be largely auto-configured with some sensible defaults, and among its many other features, the application requires no XML configuration
  
  
# About the DB - MongoDB

Use Mongo DB for a flexible data model if your database schema can evolve with business requirements. You can have the flexibility to create records without first defining the structure, such as the fields or the types of their values. Also, it removes the complex object relational mapping layer.

You can change the structure of records, called the documents, simply by adding new fields or deleting existing ones. This data model give you the ability to represent hierarchical relationships, to store arrays, and other more complex structures easily.

MongoDB is ideal for bigdata, content management, mobile and social infrastructure.
  
- MongoRepository provided by MongoDB handles the VCAP parsing for DB connection details, of MongoDB
 - Spring Boot usage in collaboration with the above Repository classes, abstracts the DB connection details parsing from the developer, thus reducing considerable effort for the developer
  
# Application Build

  This application uses Maven as the build tool.
  
# Dependency Management

  This application uses Maven to manage the dependent libraries. Maven’s pom.xml specifies the dependent libraries. 
 
# Prerequisite for enhancing the code locally
  
  * IDE like Eclipse
  * JDK should be installed 
  * CloudFoundry Eclipse Plugin or suitable IDE plugin
  * DB service instance should be created 
  * Maven setup 

# High level steps for building the application

  Go the directory where pom.xml is placed
  * Run the below commands:
            mvn clean
            mvn install
  * The application will be packaged as a war/jar file 

# High level steps for deploying the application in PaaS
    
## Using Eclipse: 
  - Install cloud foundry plugin in.
  - Login into your pivotal(api.run.pivotal.io)/bluemix(api.ng.bluemix.net) account
  - Drag and drop app to push an app into CF
  - Select and bind a service to your app 
  - Click finish button to complete your deployment
  
## Using Command line tool: 
  - Install the Cloud Foundry command line tool

  - For Pivotal CF login follow the below CLI command :
```sh
  $ cf login -a api.run.pivotal.io
```
  - For IBM Bluemix CF login follow the below CLI command :
```sh
  $ cf login -a api.ng.bluemix.net
```
  - For DigiFabricPAAS CF login follow the below CLI command :
```sh
  $ cf login -a api.mvp2.cognizantone.org
```
- Push the app :
```sh
  $ cf push <APPNAME> --no-start
```
 - Create a DB service :

```sh
  $ cf create-service <SERVICE> <PLAN> <SERVICE_INSTANCE>
```
 - Bind the service to the app :

```sh
  $ cf bind-service <YOUR-APP> <YOUR-SERVICE-INSTANCE>
```
 - Restage the the app :

```sh
  $ cf restage <APPNAME>
```
# Unit test case execution

  Junit test cases have been written for this app, and it is placed inside the /src/test/java package. 
  Using Eclipse and STS:
  Right click on the test, you will get a option as Run as Junit Test. Select the option to run it. 
  
# Code Analysis
  Code analysis tools like PMD, Findbugs can be run on the code. Simple way, is to, add these plugins to the IDE, and then generate the report from the IDE.

# Package Description

  The App has the below prominent layers:
  - Controller: Acting as a routing layer to receive incoming requests
  - Service: Acting as a layer to handle the business logic
  - Repositories: Acting as a layer to handle database connection
  - Domain: A POJO object to hold the domain data

 
## How to Run Application in local:
 - Uncomment the connection properties in application property file
 - Update the connection properties like host , port , username ,password and DB name
 - Remove the CloudConfig class, in order to avoid cloud DB connection.



## RabbitMQ
RabbitMQ is a messaging broker - an intermediary for messaging. It gives your applications a common platform to send and receive messages, and your messages a safe place to live until received.
### Using RabbitMQ
The RabbitMQ related tasks are present in the file
* `src\main\java\com\starterkit\mq\RabbitMQConfiguration.java` - In this file, the beans are made for making queue,exchangeand making connection in cloud.
* `src\main\java\com\starterkit\mq\RabbitMQMessagePublisher.java` - The file to publish the messages  the queue messages.
* `src\main\java\com\starterkit\service\AlbumService.java` - The file to call RabbitMQMessagePublisher to publish messages.

#### RabbitMQ Management Interface
The RabbitMQ dashboard allows you to show the current message rate, which queues and exchanges you have, and the bindings between them. You can also queue and pop messages manually, among other things.
### Creating and Deploying the RabbitMQ application
The following denotes the steps required to deploy the application to PAAS systems like Pivotal and Bluemix.
When deployed in the cloud foundry through starter kit, there are no changes to be done in the code.
##### Logging in to Cloud Foundry
  - For Pivotal Web Services follow the below CLI commands for login :

```sh
$ cf login -a api.run.pivotal.io
```
  - For IBM Bluemix Web Services follow the below CLI commands :
```sh
$ cf login -a api.ng.bluemix.net
```

##### Creating RabbitMQ service

 IBM Bluemix & Pivotal Web Services offer the RabbitMQ service with different plans.
  - If you are using IBM Bluemix or Pivotal Web Services, run
```sh
$ cf create-service CloudAMQP lemur service_instance_name
$ cf bind-service AppName service_instance_name
```
##### Pushing the application to cloud foundry
The following command has to be executed to push the application to cloud foundry.

```sh
$ cf push <app name>
```

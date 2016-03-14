A web application to demonstrate how to use the UH CAS service. 

##### Build Tool
First, you need to download and install maven (version 3.2.1+). 

Be sure to set up a M2_REPO environment variable.

##### Java 
You'll need a Java JDK to build and run the project (version 1.8).

##### Apache Tomcat
Install Apache Tomcat. 
This demonstration application was developed with version 7.0.42.

The files for the project are kept in a code repository, 
available from here:

https://github.com/fduckart/uh-casdemo

##### Building
Install the necessary project dependencies:

    $ mvn install

To build a deployable war file for local development:

    $ mvn clean package

You should have a deployable war file in the target directory. 
Deploy as usual in a servlet container, e.g. tomcat.

To build a deployable war file for a specified environment:

    $ mvn -Dmaven.test.skip=true -Denv=test clean package

You should have a deployable war file in the target directory. 
Deploy as usual in a servlet container.


_Important Note:_    
If you are setting up tomcat for the first time, 
make sure you enable SSL and add any necessary certificates.

Here are instructions for Tomcat 8, for example:  
https://tomcat.apache.org/tomcat-8.0-doc/ssl-howto.html

##### Deploying to Production
Copy the casdemo.war file into the webapps directory of Tomcat. 

##### Running Unit Tests
The project includes Unit Tests for various parts of the system.  
For this project, Unit Tests are defined as those tests that will 
rely on only the local development computer.  
A development build of the application will run the Unit Tests.  
A test and production build of the application will run both the 
Unit Tests and the System Tests (which may require network access).  
You can also run specific Unit Tests using the appropriate command 
line arguments.

To run the Unit Tests with a standard build:

    $ mvn -Denv=dev clean test

To run a test class:

    $ mvn clean test -Dtest=RoleTest

To run a single method in a test class:

    $ mvn clean test -Dtest=RoleTest#longName

##### Running System Tests
The project files include a handful of System Tests.  
For this project, System Tests are defined as those tests that may 
call live remote systems, such as a search against the production 
LDAP server. A standard build of the application will exclude the 
System Tests, but you can explicitly run them by specifying the 
appropriate command line argument.

To run the System Tests:

    $ mvn -Denv=dev -Dtest=*SystemTest clean test

**Running the Application locally**

http://localhost:8080/casdemo/

**Important Note**

The UH Number is restricted by University of Hawaii policy, so be sure not to expose it on any public page.

A web application to demonstrate how to use the UH CAS service.

[![Build Status](https://travis-ci.org/fduckart/uh-casdemo.png?branch=master)](https://travis-ci.org/fduckart/uh-casdemo)
[![Coverage Status](https://coveralls.io/repos/github/fduckart/uh-casdemo/badge.svg)](https://coveralls.io/github/fduckart/uh-casdemo)
##### Build Tool
First, you need to download and install maven (version 3.2.1+).

Be sure to set up a M2_REPO environment variable.

##### Java
You'll need a Java JDK to build and run the project (version 1.8).

The files for the project are kept in a code repository,
available from here:

https://github.com/fduckart/uh-casdemo

##### Building
Install the necessary project dependencies:

    $ ./mvnw install

To run the Application from the Command Line:

    $ ./mvnw clean spring-boot:run

To build a deployable war file for local development, if preferred:

    $ ./mvnw clean package

You should have a deployable war file in the target directory.
Deploy as usual in a servlet container, e.g. tomcat.

##### Running Unit Tests
The project includes Unit Tests for various parts of the system.
For this project, Unit Tests are defined as those tests that will
rely on only the local development computer.
A development build of the application will run the Unit Tests.

To run the unit tests:

    $ ./mvnw clean test

To run a test single test class:

    $ ./mvnw clean test -Dtest=StringsTest

To run a single method in a test class:

    $ ./mvnw clean test -Dtest=StringsTest#trunctate

##### Running the Application locally

http://localhost:8080/holidays/


To build a deployable war file for deployment:

    $ mvn clean package

You should have a deployable war file in the target directory.
Deploy as usual in a servlet container, e.g. tomcat.

_Important Note:_
If you are setting up tomcat for the first time,
make sure you enable SSL and add any necessary certificates.

Here are instructions for Tomcat 8, for example:
https://tomcat.apache.org/tomcat-8.0-doc/ssl-howto.html

##### Deploying to Environment
Copy the casdemo.war file into the webapps directory of Tomcat.


**Important Note**

The UH Number is restricted by University of Hawaii policy, so be sure not to expose it on any public page.

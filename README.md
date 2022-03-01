A web application to demonstrate how to use the UH CAS service.

[![Build and Test](https://github.com/fduckart/uh-casdemo/actions/workflows/build-test.yml/badge.svg)](https://github.com/fduckart/uh-casdemo/actions/workflows/build-test.yml)
[![Coverage](https://github.com/fduckart/uh-casdemo/blob/badges/jacoco.svg)](https://github.com/fduckart/uh-casdemo/actions/workflows/coverage.yml)

##### Java

You'll need a Java JDK to build and run the project (version 1.8). If necessary, be sure to set your JAVA_HOME
environment variable.

##### Building

Install the necessary project dependencies from the command line:

|    <!-- -->  | <!-- -->                          |
|--------------|-----------------------------------|
| maven        | `$ ./mvnw install               ` |
| gradle       | `$ ./gradlew publishToMavenLocal` |

To start the application:

|    <!-- -->  | <!-- -->                         |
|--------------|----------------------------------|
| maven        | `$ ./mvnw clean spring-boot:run` |
| gradle       | `$ ./gradlew bootRun           ` |

After the application starts, navigate to here in a web browser:

<http://localhost:8080/casdemo>

##### Running Unit Tests

The project includes Unit Tests for various parts of the system. For this project, Unit Tests are defined as those tests
that will rely on only the local development computer. A development build of the application will run the Unit Tests.

To run the unit tests:

|    <!-- -->  | <!-- -->              |
|--------------|-----------------------|
| maven        | `$ ./mvnw clean test` |
| gradle       | `$ ./gradlew test   ` |

To run a test single test class:

|    <!-- -->  | <!-- -->                                         |
|--------------|--------------------------------------------------|
| maven        | `$ ./mvnw clean test -Dtest=StringsTest        ` |
| gradle       | `$ ./gradlew test --tests StringsTest.trunctate` |

To run a single method in a test class:

|    <!-- -->  | <!-- -->                                           |
|--------------|----------------------------------------------------|
| maven        | `$ ./mvnw clean test -Dtest=StringsTest#trunctate` |
| gradle       | `$ ./gradlew test --tests StringsTest.trunctate  ` |

##### Build to deploy to an Environment

To build a deployable war file for deployment:

|    <!-- -->  | <!-- -->                 |
|--------------|--------------------------|
| maven        | `$ ./mvnw clean package` |
| gradle       | (Not yet implemented)    |

You should have a deployable war file in the target directory. Deploy as usual in a servlet container, e.g. tomcat.

_Important Note:_
If you are setting up tomcat for the first time, make sure you enable SSL and add any necessary certificates.

Here are instructions for Tomcat 8, for example:
<https://tomcat.apache.org/tomcat-8.0-doc/ssl-howto.html>

Copy the casdemo.war file into the webapps directory of Tomcat.

##### Build Tool (Optional)

Download and install maven (version 3.2.1+) or Gradle (version 7.3.3+).

##### Source Repository

The files for the project are kept here:

<https://github.com/fduckart/uh-casdemo>

##### Important Note

The UH Number is restricted by University of Hawaii policy, so be sure not to expose it on any public page.

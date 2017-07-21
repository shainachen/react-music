React Music
===========

This is the backend application for React Music, a sample application demonstrating the use of database services on 
[Cloud Foundry](http://cloudfoundry.org). This application uses [Spring Boot](http://projects.spring.io/spring-boot/) 
and the [Spring Framework](http://spring.io) to make use of [bean profiles](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-profiles.html)
which configure the application.

To run the full React Music application, refer to the [React Music Frontend](https://github.com/shainachen/react-music-js).

To begin, clone this repository onto your machine. 

## Running the Application Locally

Start the application by navigating into the project directory and using the following command:
~~~
$ ./gradlew clean assemble && java -jar build/libs/gs-spring-boot-0.1.0.jar
~~~

The application will be started on the default port localhost:8080/.

## Deploying the Application to Cloud Foundry

Install the 'cf' [command-line interface for Cloud Foundry](http://docs.cloudfoundry.org/cf-cli/), target a Cloud Foundry instance,
and log in to Cloud Foundry. Then, the application can be built and pushed with these commands:

~~~
$ ./gradlew clean assemble
$ cf push YOUR_APP_NAME
~~~

Access your application (built with the specifications from the 'manifest.yml' file) by curling the URL given near the end
of the output from the command.

To run the full React Music Application, be sure to push the [frontend](https://github.com/shainachen/react-music-js) to
Cloud Foundry, as well. You will then be ready to add services!
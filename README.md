Fullstack development of a Todo list with Spring Boot, Maven, Thymeleaf, Eurika, Hystrix, H2 DB

Project description

Installation
Dependencies
Git, of course, installed on your local machine.
Maven to compile and run the project.
Spring dependencies:
Assuming you have Git and Maven on your local machine you will run the following commands. On the terminal of your choice change directories to where you want the cloned project files to download and run:

git clone URL
Since we are using Maven to run/build this project you will execute the following at the project root.

mvn spring-boot:run
This will compile and startup a Tomcat server on your localhost. In your Web browser go to http://localhost:8080/ and check it out.

Docker Setup
- Copy `docker-compose.yml.dist` into `docker-compose.yml`
- Run `docker-compose build`
- Run `docker-compose up`

Backend
Spring
H2 DB
As mentioned Spring Boot is the foundation for the server side. An H2 (in memory Java-based) SQL database is used as the data store. The choice of H2 was solely for simplicity of the demo, since no installation is required. Also included is the Spring implementation of the Java Persistence API (JPA). This allows for easy DB access using annotations and *Repository interfaces. Rounding off the backend is the REST Spring Boot Starter to support the RESTful APIs our React Javascript is going to call. You can read more about Spring Boot Starters and get a list of the many that are provided at the link provided. In short though, as stated:

MVC
We are following the typical layout specified in the Spring Boot Docs with an Application class on the root package using a @SpringBootApplication annotation to explicitly identify our main application class. This class does two things of interest. First it kicks off our Spring Boot app and second imports our WebConfiguration class.

The WebConfiguration is also very simple doing one thing. By extending the RepositoryRestConfigurerAdapter class and overriding its configureRepositoryRestConfiguration method it routes all of the RESTful API endpoints through the "/api" path.

http://localhost:8080/api/persons
There is a single controller class in the project, AboutController, that routes requests to the root path to the "index.html" page. Which is actually our one Mustache-templated page. It also looks for the first Person in our database and puts it as the model for Mustache to use.

Database Population
With Spring Boot there is no need for reading and loading in a SQL file, we can do everything we need to populate or H2 database - right in Java. Spring has various events that you can hook into and the AboutLoader class takes advantage of ContextRefreshedEvent that is triggered when the ApplicationContext gets initialized or refreshed.

This class does a couple things. First it used the AutoWired annotation to inject in instances of our *Repository JPA classes and set them to corresponding fields. The second is overrdiding the onApplicationEvent method and it is in this method that we use all of those Builder static nested classes to populate the database with content.

Frontend
The frontend is built using React and Material-UI, which is a set of React components following Google's Material Design. The React components call the JPA fed REST endpoints to populate themselves. CSS is generated at build time from the LESS files in the "styles" directory.

Webpack2 is used to build and bundle up our Javascript as well as compiling our LESS files into CSS and injecting into the HTML head element. The POM file also contains a plugin that will install Node, Node Package Manager (NPM) and execute the Webpack build.

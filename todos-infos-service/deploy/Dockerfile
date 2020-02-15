FROM openjdk:8-jdk-alpine

RUN mkdir /build

COPY . /build

WORKDIR /build

RUN MVNW_VERBOSE=true ./mvnw package

RUN mv target/*.jar /app.jar

WORKDIR /

RUN rm -r /build

ENTRYPOINT ["java","-jar","/app.jar"]
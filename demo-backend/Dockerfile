FROM maven:3-openjdk-11 as build
WORKDIR /app

COPY ./pom.xml .
RUN mvn dependency:go-offline

COPY src src

RUN mvn clean package spring-boot:repackage -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target ./target/
ENTRYPOINT ["java","-jar","target/demo-backend-0.0.1-SNAPSHOT.jar"]
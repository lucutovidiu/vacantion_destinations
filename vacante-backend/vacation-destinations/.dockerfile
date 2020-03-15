FROM maven:3.6.0-jdk-8-alpine
WORKDIR /vacante-be
COPY . .
CMD mvn clean | mvn install
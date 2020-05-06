FROM maven:3.6.0-jdk-8-alpine
WORKDIR /vacante-be
COPY . .
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
# RUN mvn clean install
# ENTRYPOINT [ "java", "-jar", "./web/target/vacation-destinations.jar" ]
# CMD cd /vacante-be/web && mvn spring-boot:run
ENTRYPOINT [ "bash", "-c", "./entrypoint.sh" ]
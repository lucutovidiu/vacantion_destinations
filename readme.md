#RUN Project in development mode
cd /vacante_docker 
docker-compose up -d
sql scripts will get inserted into database for creating tabels and inserting default users


#IntelliJ string example
--For Windows--
spring.profiles.active=local-windows
--For Linux--
spring.profiles.active=local-linux

#.env settings example
POSTGRES_PASSWORD=password
POSTGRES_USER=root
POSTGRES_DB=vacante
ACTIVE_PROFILE=dev
urlForCrossOrigin=http://localhost:4200

#Default User
daniel



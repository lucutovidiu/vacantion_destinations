#RUN Project in development mode
cd /vacante_docker 
docker-compose up -d
sql scripts will get inserted into database for creating tabels and inserting default users


#IntelliJ string example
DATABASE_HOST=192.168.99.100;DATABASE_PORT=5432;DATABASE_USER=root;DATABASE_PASSWORD=password;DATABASE_NAME=vacante;ACTIVE_PROFILE=dev;urlForCrossOrigin=http://localhost:4200

#.env settings example
POSTGRES_PASSWORD=password
POSTGRES_USER=root
POSTGRES_DB=vacante
ACTIVE_PROFILE=dev
urlForCrossOrigin=http://localhost:4200

#Default User
daniel



FROM node:10.17.0-alpine3.9 as angular-image
RUN npm i -g @angular/cli
WORKDIR /vacante-fe
COPY package.json .
RUN npm install
COPY . .
CMD ng serve --disableHostCheck --host 0.0.0.0
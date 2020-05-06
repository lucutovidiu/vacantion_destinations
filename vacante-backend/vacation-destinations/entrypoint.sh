#!/bin/bash
# kill -9 $(ps aux | grep "java -jar ./web/target/vacation-destinations.jar" |  grep -v grep | awk '{print $2}')
mvn clean install
java -jar ./web/target/vacation-destinations.jar
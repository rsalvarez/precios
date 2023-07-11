# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM adoptopenjdk/openjdk11
RUN adduser appuser 
#RUN addgroup heros && adduser heros -G heros
USER appuser:appuser
ARG RESOURCES=src/main/resources
COPY ${RESOURCES}/application.properties .
ARG JAR_FILE=target/Prices-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Prices-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Prices-0.0.1-SNAPSHOT.jar"]

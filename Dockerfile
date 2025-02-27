FROM openjdk:22-slim-bullseye

ARG PORT=8080
ARG APP_HOME='/app'
ENV SERVER_FILE='server.jar'

RUN mkdir ${APP_HOME}
ADD target/*.jar ${APP_HOME}/server.jar

EXPOSE ${PORT}

WORKDIR ${APP_HOME}
CMD java -jar ${SERVER_FILE}
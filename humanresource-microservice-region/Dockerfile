FROM openjdk:15-jdk-alpine
LABEL "mantainer"="renators"
ARG PROFILE
ENV PROFILE=${PROFILE:-local}

RUN addgroup -S humanresource && adduser -S humanresource -G humanresource
USER humanresource:humanresource
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} humanresource.jar
ENTRYPOINT java -Dspring.profiles.active=$(echo ${PROFILE}) -jar /humanresource.jar
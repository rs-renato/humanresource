FROM arm64v8/openjdk:18-jdk
LABEL "mantainer"="renators"
ARG PROFILE
ENV PROFILE=${PROFILE:-local}

## Add the wait script to the image
RUN echo "[HRS REGION] Downloading wait script..."
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait

ARG JAR_FILE=humanresource-microservice-region/target/*.jar
COPY ${JAR_FILE} humanresource.jar

RUN echo "[HRS REGION] Running profile: $PROFILE"
RUN echo "[HRS REGION] Application jar file located at: $JAR_FILE"

CMD /wait && java -Dspring.profiles.active=$(echo ${PROFILE}) -jar /humanresource.jar
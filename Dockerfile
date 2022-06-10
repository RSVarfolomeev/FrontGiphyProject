FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=build/libs/Front-1.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} giphyprojectfront.jar
ENTRYPOINT ["java", "-jar", "giphyprojectfront.jar"]
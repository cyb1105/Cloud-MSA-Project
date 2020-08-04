FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/CrawlingApi-0.0.1-SNAPSHOT.jar CrawlingApi.jar
ENTRYPOINT ["java", "-jar", "CrawlingApi.jar"]
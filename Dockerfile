FROM openjdk:11.0

COPY build/libs/awssqssample-0.0.1-SNAPSHOT.jar /app.jar

CMD ["java", "-jar", "/app.jar"]

EXPOSE 8080


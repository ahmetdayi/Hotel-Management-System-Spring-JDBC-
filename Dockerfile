FROM openjdk:14.0.2
ADD target/hotelmanagementsystem-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
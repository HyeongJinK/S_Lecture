FROM openjdk:14-slim

EXPOSE  8082

ADD ./target/*.jar apiDoc.jar

ENTRYPOINT ["java","-jar","/apiDoc.jar"]

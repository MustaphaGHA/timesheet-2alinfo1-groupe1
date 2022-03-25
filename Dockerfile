# Create the image
FROM openjdk:8-jdk-alpine
#COPY --from=Stage1 /home/app/target/timesheet-2alinfo1-groupe1.war timesheet-2alinfo1-groupe1.war
ADD target/timesheet-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

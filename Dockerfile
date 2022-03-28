# Create the image
FROM openjdk:8-jdk-alpine
EXPOSE 8082
#COPY --from=Stage1 /home/app/target/timesheet-2alinfo1-groupe1.war timesheet-2alinfo1-groupe1.war
ADD target/*.war app.war
ENTRYPOINT ["java","-jar","app.war"]

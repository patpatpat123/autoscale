FROM openjdk:11
COPY target/autoscale-1.1.jar /app/autoscale-1.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/autoscale-1.1.jar"]

FROM openjdk:17-jre-slim

WORKDIR /app

COPY target/bread-1.0.jar /app/bread.jar

EXPOSE 8080

CMD ["java", "-jar", "bread.jar"]
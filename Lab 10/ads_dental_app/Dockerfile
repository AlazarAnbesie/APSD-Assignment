FROM openjdk:17

RUN mkdir /app

COPY target/*.jar /app/ads_dental_app.jar

WORKDIR /app

CMD ["java", "-jar", "./ads_dental_app.jar"]

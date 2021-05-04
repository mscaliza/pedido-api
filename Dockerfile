FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/pedido-api-1.0.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]
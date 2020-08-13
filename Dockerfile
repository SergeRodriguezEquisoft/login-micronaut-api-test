FROM openjdk:14-alpine
COPY build/libs/login-api-*-all.jar login-api.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "login-api.jar"]
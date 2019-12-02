FROM openjdk:12-jdk
VOLUME /tmp
ADD ./build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Duser.timezone=America/Bogota","-jar","/app.jar"]
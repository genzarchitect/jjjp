FROM openjdk:17
WORKDIR user/lib
EXPOSE 8011
ADD ./target/user-service-0.0.1-SNAPSHOT.jar  /user/lib/user-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","user-service-0.0.1-SNAPSHOT.jar"]
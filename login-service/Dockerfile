FROM openjdk:17
WORKDIR user/lib
EXPOSE 8007
ADD ./target/login-service-0.0.1-SNAPSHOT.jar  /user/lib/login-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","login-service-0.0.1-SNAPSHOT.jar"]
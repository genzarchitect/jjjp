FROM openjdk:17
WORKDIR user/lib
EXPOSE 8007
ADD ./target/ground-service-0.0.1-SNAPSHOT.jar  /user/lib/ground-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ground-service-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17
WORKDIR user/lib
EXPOSE 8091
ADD ./target/apiGateway-0.0.1-SNAPSHOT.jar  /user/lib/apiGateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","apiGateway-0.0.1-SNAPSHOT.jar"]
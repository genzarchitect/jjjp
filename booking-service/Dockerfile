FROM openjdk:17
WORKDIR user/lib
EXPOSE 8003
ADD ./target/booking-service-0.0.1-SNAPSHOT.jar  /user/lib/booking-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","booking-service-0.0.1-SNAPSHOT.jar"]
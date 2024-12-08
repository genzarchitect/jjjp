FROM openjdk:17
WORKDIR user/lib
EXPOSE 8013
ADD ./target/product-webapp-service-0.0.1-SNAPSHOT.jar  /user/lib/product-webapp-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","product-webapp-service-0.0.1-SNAPSHOT.jar"]
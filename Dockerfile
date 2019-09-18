FROM java:8-jdk-alpine


RUN mkdir /usr/app
COPY ./target/learn-quarkus-1.0.0.ALPHA-runner.jar /usr/app
WORKDIR /usr/app

EXPOSE 9090
ENTRYPOINT ["java","-jar","learn-quarkus-1.0.0.ALPHA-runner.jar"]
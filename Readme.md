You can start the application with two ways that mvn or docker.

First of all, you have to run that mvn command to build jar files

`mvn compile quarkus:build`

If you don't have docker, you can use 

`mvn compile quarkus:dev -Dquarkus.profile=dev`

If you have installed docker you can use 

`docker build -t quarkus-example -f Dockerfile .`


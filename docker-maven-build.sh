# build image via maven cli, bypasses Dockerfile
# Warning, Kubernetes has issues accessing images created by this command.
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=reindeer-service-image
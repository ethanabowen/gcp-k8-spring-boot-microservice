# gcp-k8-spring-boot-microservice
Creating a spring boot application that will run in GKE.

The service itself is a simple CRUD service that returns information about Santa's Reindeer: reindeer-service

Pre-requistite:
Set your PROJECT_ID environmental variable to your Google Cloud Provider's Project Id. (example: ``set PROJECT-ID=example-project-id``)

To build image: ``./docker/docker-cli-build.sh``

To deploy to K8s locally: ``./kubernetes/kubernetes-full-deploy.cmd``

To deploy to K8s GKE: ``sh ./kubernetes/kubernetes-gcp-deploy.sh``

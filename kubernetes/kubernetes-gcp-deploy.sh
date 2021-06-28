gcloud config set compute/zone us-east1-b
gcloud container clusters create reindeer-cluster
kubectl get nodes

# Ensure that you are connected to the newly created GKE cluster.
gcloud container clusters get-credentials reindeer-cluster --zone

# Deploy kubernetes based on configs
./kubernetes-full-deploy.sh

# View Kubernetes details
kubectl get service
kubectl get deployments
kubectl get pods
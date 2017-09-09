#!/bin/bash

VERSION=$(git log --pretty=format:'%h' -n 1)
URL='077077460384.dkr.ecr.ap-southeast-2.amazonaws.com/scala-template'
# Authenticate against our Docker registry
eval $(aws ecr get-login --region=ap-southeast-2)
#aws ecr get-login --region ap-southeast-2
#run aws configure if any login issues. //credentials can be found in ~/.aws/credentials

#VERSION="latest"
# Build and push the image
docker build -t scala-template:$VERSION .
docker tag scala-template:latest 077077460384.dkr.ecr.ap-southeast-2.amazonaws.com/scala-template:latest
docker push 077077460384.dkr.ecr.ap-southeast-2.amazonaws.com/scala-template:latest

#Deploy, Rolling update to cluster
kubectl --kubeconfig=kubeconfig set image deployment/node-api scala-template=$URL:$VERSION
#kubectl --kubeconfig=kubeconfig set image deployment/node-api scala-template=077077460384.dkr.ecr.ap-southeast-2.amazonaws.com/scala-template:$VERSION
#Untested
#minikube start
#kubectl run scala-template --image=191618872039.dkr.ecr.ap-southeast-2.amazonaws.com/bootcamp/node-api:$VERSION --port=5000

#kubectl expose deployment scala-template --type=5000

#kubectl get pod

# curl $(minikube service hello-minikube --url)


### PREREQUISITES

* java 11
* docker
* minikube started
* helm 3

### BUILD DOCKER IMAGES

* `cd stakater`
* `./gradlew clean build`
* `eval $(minikube docker-env)` // use local docker to pull images
* `docker build -t stakater-backend:latest -f docker/backend/Dockerfile .`
* `docker build -t stakater-ui:latest -f docker/ui/Dockerfile .`

### DEPLOY TO K8S

* `kubectl create ns stakater`
* `helm upgrade --install -n stakater stakater helm/stakater`
* `kubectl port-forward svc/stakater-ui-svc 5555:80`
*  open link http://localhost:5555
* `kubectl delete ns stakater`
 
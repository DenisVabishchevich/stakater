FROM openjdk:11-jre-slim
COPY service/build/libs/backend.jar /usr/src/k8s-web/service/
WORKDIR /usr/src/k8s-web/service/
CMD ["java", "-jar", "backend.jar"]
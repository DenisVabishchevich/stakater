FROM openjdk:11-jre-slim
COPY vaadin-ui/build/libs/ui.jar /usr/src/k8s-web/ui/
WORKDIR /usr/src/k8s-web/ui/
CMD ["java", "-jar", "ui.jar"]
FROM openjdk:17-jdk-slim
ARG JAR_FILE=CalculatingFrequencyOfCharacters.jar  
WORKDIR /opt/app  
COPY ${JAR_FILE} app.jar  
ENTRYPOINT ["java","-jar","app.jar"] 
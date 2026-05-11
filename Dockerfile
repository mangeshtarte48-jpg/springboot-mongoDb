FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar springboot-mongoDb.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","springboot-mongoDb.jar"]
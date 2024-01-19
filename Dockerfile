FROM maven:3-eclipse-temurin-17 AS mvn_build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alpine
COPY --from=mvn_build /target/ipl-dashboard-service-0.0.1-SNAPSHOT.jar ipl-dashboard-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "ipl-dashboard-service.jar"]
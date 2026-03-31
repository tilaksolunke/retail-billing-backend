FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Debug: list files (important)
COPY --from=build /app/target /app/target

RUN ls /app/target

# Copy jar dynamically
RUN cp /app/target/*SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
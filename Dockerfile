# Étape 1 : Construire le projet
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Créer l'image d'exécution
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
# Utilisez le chemin correct pour copier le fichier JAR
COPY --from=build /app/target/Preval4-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]

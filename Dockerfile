FROM openjdk:8
ARG JAR_FILE
COPY ${JAR_FILE} LeagueStanding.jar
ENTRYPOINT ["java", "-jar", "/LeagueStanding.jar"]
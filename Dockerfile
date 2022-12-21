FROM openjdk:17
ADD target/file-service.jar //
ARG ACTIVE_PROFILE=default
ENV SPRING_PROFILES_ACTIVE ${ACTIVE_PROFILE}
ENTRYPOINT [ "sh", "-c", "java  -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -Dserver.port=8080 -jar /file-service.jar" ]

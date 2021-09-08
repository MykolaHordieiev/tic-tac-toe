FROM adoptopenjdk/openjdk8

ENV APP_JAR_NAME="boot-demo-1.0-SNAPSHOT.jar"
ENV JAVA_OPTS="-Xms512m -Xmx512m"
ENV SPRINGBOOT_ARGS="--spring.config.location=classpath:/,/opt/springboot/config/"

WORKDIR /opt
COPY target/$APP_JAR_NAME $APP_JAR_NAME

EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -jar $APP_JAR_NAME $SPRINGBOOT_ARGS
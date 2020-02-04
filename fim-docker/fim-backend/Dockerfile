FROM java:8

MAINTAINER gradyjiang "jiangzhongjin@hotmail.com"

ENV PARENT_DIR .

COPY $PARENT_DIR/fim-backend-*.jar app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", "> /log/app.log"]

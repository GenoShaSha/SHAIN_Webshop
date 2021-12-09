FROM gradle:7.2.0-jdk11

WORKDIR /Backend

COPY build.gradle /Backend
RUN gradle init

COPY src /Backend/src

EXPOSE 8000

CMD ["gradle","build", "-x", "test"]

CMD ["gradle", "--stacktrace", "run"]

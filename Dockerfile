
FROM hseeberger/scala-sbt

VOLUME [ "/app" ]
# Define working directory
WORKDIR /app

COPY . /app/
EXPOSE  5000

ENTRYPOINT ["sbt" ]
CMD ["run"]

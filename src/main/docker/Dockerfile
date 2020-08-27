FROM java:8
VOLUME /tmp
ADD /target/github-1.0-SNAPSHOT.jar github.jar
EXPOSE 9999
ENTRYPOINT ["java","-jar","/github.jar"]
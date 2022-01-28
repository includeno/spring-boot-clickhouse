FROM openjdk:11.0.10-jdk

EXPOSE 8080
WORKDIR /app

#Version
ENV VERSION="1.0.0"
ENV NAME="mybatis-plus-clickhouse"

#server
ENV server_port="8080"

#clickhouse
ENV clickhouse_url="jdbc:clickhouse://127.0.0.1:8123/default"
ENV clickhouse_username="default"
ENV clickhouse_password=""

#add jar file
ADD ${NAME}/target/${NAME}-${VERSION}.jar /app/application.jar
#ENTRYPOINT ["java","-jar","/app/application.jar","--dockerconfig=true"]
CMD java -jar /app/application.jar --server.port=${server_port} \
 --spring.datasource.url=${clickhouse_url} \
 --spring.datasource.username=${clickhouse_username} \
 --spring.datasource.password=${clickhouse_password}

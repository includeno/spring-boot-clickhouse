# spring-boot-clickhouse
mybatis-plus结合clickhouse

# 环境 
```
springboot 2.3.12.RELEASE
clickhouse 21.11.11.1
mybatis-plus
```

# clickhouse 数据库表
environmnet/clickhouse/user.sql
```
-- auto-generated definition
create table user
(
    id          UInt64,
    username    String,
    password    String,
    email       String,
    create_time DateTime64,
    update_time DateTime64,
    partition Date
)
engine = MergeTree
partition by toYYYYMMDD(partition)
primary key (id)
order by (id,create_time);
```

# clickhouse docker部署脚本
environmnet/clickhouse/clickhouse.md

# app docker部署脚本
app/docker-compose/docker-compose-app-withenv.command.md

需要自己填写私密信息
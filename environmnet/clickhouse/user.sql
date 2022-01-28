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
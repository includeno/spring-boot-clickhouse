# dockercompose command for clickhouse



## pull
```
docker pull clickhouse/clickhouse-server:21.11.11.1
```

## run
```
cd clickhouse
docker-compose --env-file app.env -f docker-compose-clickhouse.yml  up -d
```

## inspect
```
docker-compose -f docker-compose-clickhouse.yml logs -f server
docker-compose -f docker-compose-clickhouse.yml logs -f client

docker-compose -f docker-compose-clickhouse.yml exec server /bin/bash
docker-compose -f docker-compose-clickhouse.yml exec client /bin/bash
```

## stop&remove container
```
docker-compose -f docker-compose-clickhouse.yml stop
docker-compose -f docker-compose-clickhouse.yml down
```

## remove image
```
docker image rm clickhouse/clickhouse-server:21.11.11.1
```
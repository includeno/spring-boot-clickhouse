# dockercompose command for app

cd app/docker-compose

## pull
```
docker pull openjdk:11.0.10-jdk
```

## run
```
docker-compose --env-file app.env -f docker-compose-app-withenv.yml  up -d
```

## inspect
```
docker-compose -f docker-compose-app-withenv.yml logs server

docker-compose -f docker-compose-app-withenv.yml logs -f server

```

## stop&remove container
```
docker-compose -f docker-compose-app-withenv.yml stop
docker-compose -f docker-compose-app-withenv.yml down
```

## remove image
```
docker image rm includeno/mybatis-plus-clickhouse
```
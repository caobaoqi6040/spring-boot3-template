# redis

- https://hub.docker.com/_/redis
- https://redis.tinycraft.cc/
- https://download.redis.io/releases/

## install

> docker

```yaml
services:
  redis:
    image: redis:8.2.1
    restart: "no"
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
      - redis.conf:/usr/local/etc/redis
    healthcheck:
      test: redis-cli ping
      interval: 10s
      timeout: 5s
      start_period: 10s
      retries: 5
volumes:
  redis_data:
```

> source build

```shell
wget https://download.redis.io/releases/redis-8.2.1.tar.gz
tar zxf ./redis-8.2.1.tar.gz
mv ./redis-8.2.1.tar.gz /usr/local/redis
cd /usr/local/redis
make && make install
```

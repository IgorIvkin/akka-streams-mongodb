# Пример использования Akka Streams + MongoDB

Это демо-приложение написано на Spring Boot как пример использования
Akka Streams. Мы генерируем (случайно) курсы криптовалют, фильтруем их 
и сохраняем в MongoDB, используя концепцию, которая называется Flow Process 
в Akka Streams.

### Как запустить

Я советую вам использовать какой-нибудь 
docker-образ MongoDB. Я сам пользовался [образом](https://github.com/bitnami/bitnami-docker-mongodb)
от **Bitnami**.

После того, как заведётся докер, зайдите в командную строку контейнера и введите:

    > cd /opt/bitnami/mongo/bin
    > mongo

    use cryptodatabase
    db.createCollection("crypto")

Команды создадут базу данных с именем `cryptodatabase` и коллекцию `crypto`, внутри
этой базы данных.

Проверить работу приложения вы можете по URL:

    http://localhost:8089/sink/

...а потом в командой строке контейнера введите:

    db.crypto.find({})

Вы увидите что-то вроде:

    { "_id" : ObjectId("6027afb3ab20aef6faed4ae3"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "USDT", "rateToUSD" : 0.8321748553177893 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4ae5"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "DeFi", "rateToUSD" : 0.4589989871509448 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4ae7"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "USDT", "rateToUSD" : 0.6981889533438449 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4ae9"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "USDT", "rateToUSD" : 0.0071151180203335995 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4aeb"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "ETH", "rateToUSD" : 0.7098834856981644 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4aed"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "ETH", "rateToUSD" : 0.2567091007933938 }

### Полезные ссылки
* [Документация по Akka Streams](https://doc.akka.io/docs/akka/current/stream/index.html)
* [Документация по Akka Streams + MongoDB](https://doc.akka.io/docs/alpakka/current/mongodb.html)
* [Официальная документация по MongoDB](https://docs.mongodb.com/manual/)
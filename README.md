# Akka Streams to MongoDB example

It is a small demo-application based on Spring Boot that demonstrates
the concept of Akka Streams. It generates the rates of cryptocurrencies,
filters them and stores to MongoDB using the Flow process of Akka Streams.

### How to run it?

I recommend to use docker image of MongoDB to check out how this app works.
Personally me I used **Bitnami**'s [docker image](https://github.com/bitnami/bitnami-docker-mongodb).

After you will start your docker open a command line of container and type the following:

    > cd /opt/bitnami/mongo/bin
    > mongo

    use cryptodatabase
    db.createCollection("crypto")

It will create the database named `cryptodatabase` and collection `crypto` 
inside of it.

To test the application you can proceed to 

    http://localhost:8089/sink/

...and then run the following command in your docker's command line:

    db.crypto.find({})

You will see something similar to:

    { "_id" : ObjectId("6027afb3ab20aef6faed4ae3"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "USDT", "rateToUSD" : 0.8321748553177893 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4ae5"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "DeFi", "rateToUSD" : 0.4589989871509448 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4ae7"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "USDT", "rateToUSD" : 0.6981889533438449 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4ae9"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "USDT", "rateToUSD" : 0.0071151180203335995 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4aeb"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "ETH", "rateToUSD" : 0.7098834856981644 }
    { "_id" : ObjectId("6027afb3ab20aef6faed4aed"), "createdAt" : ISODate("2021-02-13T10:53:39.924Z"), "cryptoName" : "ETH", "rateToUSD" : 0.2567091007933938 }

### Useful links
* [Documentation of Akka Streams](https://doc.akka.io/docs/akka/current/stream/index.html)
* [Documentation of Akka Streams + MongoDB](https://doc.akka.io/docs/alpakka/current/mongodb.html)
* [MongoDB official spec](https://docs.mongodb.com/manual/)
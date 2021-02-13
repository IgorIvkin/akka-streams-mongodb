package com.igorivkin.akkastreamsmongodb.config;

import com.igorivkin.akkastreamsmongodb.entities.CryptoRate;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.codecs.ValueCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
@Slf4j
public class MongoDBConfig {

    @Value("${application.mongo-database-name}")
    private String mongoDatabaseName;

    @Value("${application.mongo-database-collection-name}")
    private String mongoCollectionName;

    @Value("${application.mongo-url}")
    private String mongoUrl;

    private CodecRegistry codecRegistry;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<CryptoRate> cryptoRateCollection;

    @PostConstruct
    public void initializeMongoDBConfigs() {
        PojoCodecProvider codecProvider = PojoCodecProvider.builder().register(CryptoRate.class).build();
        this.codecRegistry = CodecRegistries.fromProviders(codecProvider, new ValueCodecProvider());

        this.mongoClient = MongoClients.create(this.mongoUrl);
        this.mongoDatabase = this.mongoClient.getDatabase(this.mongoDatabaseName);
        this.cryptoRateCollection = this.mongoDatabase.getCollection(this.mongoCollectionName, CryptoRate.class).withCodecRegistry(this.codecRegistry);

        log.info("MongoDB pre-initialization is done");
    }

    public MongoDBConfig() {
    }

    @Bean
    public CodecRegistry codecRegistry() {
        return this.codecRegistry;
    }

    @Bean
    public MongoClient mongoClient() {
        return this.mongoClient;
    }

    @Bean
    public MongoDatabase mongoDatabase() {
        return this.mongoDatabase;
    }

    @Bean(name = "cryptoRateCollection")
    public MongoCollection<CryptoRate> cryptoRateCollection() {
        return this.cryptoRateCollection;
    }
}

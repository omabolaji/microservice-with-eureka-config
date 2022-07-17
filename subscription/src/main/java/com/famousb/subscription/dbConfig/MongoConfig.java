package com.famousb.subscription.dbConfig;


import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.mongodb.host}")
    private String host;
    @Value("${spring.mongodb.port}")
    private int port;
    @Value("${spring.mongodb.user}")
    private String username;
    @Value("${spring.mongodb.password}")
    private String password;
    @Value("${spring.mongodb.db}")
    private String dbName;

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(new ConnectionString("mongodb://"+host+":"+port+"/admin?retryWrites=true&w=majority"));
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    protected boolean autoIndexCreation(){
        return true;
    }


    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }
}

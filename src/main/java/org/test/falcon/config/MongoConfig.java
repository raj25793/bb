package org.test.falcon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.db.host}")
    private String  host;

    @Value("${mongo.db.port}")
    private Integer port;

    @Value("${mongo.db.name}")
    private String  database;

    @Value("${mongo.db.auth.name}")
    private String  authDatabase;

    @Value("${mongo.db.user}")
    private String  username;

    @Value("${mongo.db.pass}")
    private String  password;

    @Value("${mongo.write.concern}")
    private Integer writeConcern;

    @Override
    protected String getDatabaseName() {
        return this.database;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(this.host, this.port);
    }

    @Override
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(
                new MongoProperties(this.host, this.authDatabase, this.username, this.password.toCharArray())
                        .createMongoClient(null),
                getDatabaseName());
    }


    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        mongoTemplate.setWriteConcern(new WriteConcern(writeConcern));
        return mongoTemplate;
        
    }

}

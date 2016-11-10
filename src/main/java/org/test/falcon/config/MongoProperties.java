package org.test.falcon.config;

/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoProperties {

    /**
     * Default port used when the configured port is {@code null}.
     */
    public static final int DEFAULT_PORT = 27017;

    /**
     * Mongo server host.
     */
    private String          host;

    /**
     * Mongo server port.
     */
    private Integer         port;

    /**
     * Database name.
     */
    private String          database;

    /**
     * Authentication database name.
     */
    private String          authenticationDatabase;

    /**
     * Login user of the mongo server.
     */
    private String          username;

    /**
     * Login password of the mongo server.
     */
    private char[]          password;

    public MongoProperties(String host, String database, String username, char[] password) {
        super();
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public MongoProperties() {
        super();
    }

    public void clearPassword() {
        if (this.password == null) {
            return;
        }
        for (int i = 0; i < this.password.length; i++) {
            this.password[i] = 0;
        }
    }

    public String getMongoClientDatabase() {
        return this.database;
    }

    /**
     * Creates a {@link MongoClient} using the given {@code options} and
     * {@code environment}. If the configured port is zero, the value of the
     * {@code local.mongo.port} property retrieved from the {@code environment}
     * is used to configure the client.
     *
     * @param options
     *            the options
     * @return the Mongo client
     * @throws UnknownHostException
     *             if the configured host is unknown
     */
    public MongoClient createMongoClient(MongoClientOptions options) throws UnknownHostException {
        try {
            if (options == null) {
                options = MongoClientOptions.builder().build();
            }
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            String database =
                    this.authenticationDatabase == null ? getMongoClientDatabase() : this.authenticationDatabase;
            credentials.add(MongoCredential.createCredential(this.username, database, this.password));
            String host = this.host == null ? "localhost" : this.host;
            int port = determinePort();
            return new MongoClient(Arrays.asList(new ServerAddress(host, port)), credentials, options);
        }
        finally {
            clearPassword();
        }
    }

    private int determinePort() {
        if (this.port == null) {
            return DEFAULT_PORT;
        }

        return this.port;
    }

}
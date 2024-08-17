
package org.eventure.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "eventure_db";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.applyConnectionString(new ConnectionString("mongodb://localhost:27017/eventure_db"));
    }
}

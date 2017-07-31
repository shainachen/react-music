package App.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

//@Configuration
@Component
@Profile({"mysqlcloud"})
    //@Profile(("cloud"))
class CloudConfig extends AbstractCloudConfig implements DatasourceConfig {

    //@Profile({"mysqlcloud"})
    //@Bean
    @Override
    public DataSource dataSource(){
        System.out.println("mysql-cloud setting up");
        return connectionFactory().dataSource();
    }

//    @Bean
//    @Profile({"in-memory"})
}


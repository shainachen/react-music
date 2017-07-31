package App.configuration;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Profile({"mysqlcloud"})
class CloudConfig extends AbstractCloudConfig implements DatasourceConfig {

    @Override
    public DataSource dataSource(){
        System.out.println("mysql-cloud setting up");
        return connectionFactory().dataSource();
    }

}


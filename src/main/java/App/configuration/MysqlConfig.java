package App.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mysql")
public class MysqlConfig implements DatasourceConfig{

    @Override
    public String setup() {
        return "Setting up MySQL datasource...";
    }
}

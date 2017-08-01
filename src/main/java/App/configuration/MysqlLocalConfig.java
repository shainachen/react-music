package App.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Profile({"mysqllocal"})
public class MysqlLocalConfig implements DatasourceConfig{
    @Override
    public DataSource dataSource() {
        System.out.println("Setting up MySQL local datasource...");
        return createDataSource("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_d9a5414dd4e200a", "com.mysql.jdbc.Driver",
                "b38e5b3b31c75a", "fde06131");
    }

    private DataSource createDataSource(String jdbcUrl, String driverClass, String userName, String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }


}
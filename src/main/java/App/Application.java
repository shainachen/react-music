package App;

import App.configuration.DatasourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
    @Autowired
    DatasourceConfig datasourceConfig;

    @Bean
    public CommandLineRunner setupDatasource() {
        return args -> System.out.println(datasourceConfig.setup());
    }

}

package App;

import App.configuration.DatasourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        System.out.println("Running...");
    }

    @Autowired
    DatasourceConfig datasourceConfig;

    @Bean
    public CommandLineRunner setupDatasource() {
        return args -> System.out.println(datasourceConfig.dataSource());
    }

}

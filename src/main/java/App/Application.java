package App;

import App.configuration.DatasourceConfig;
//import App.configuration.SpringAppContextInitializer;
//import App.configuration.SpringAppContextInitializer;
import App.configuration.DatasourceConfig;
import App.controllers.AlbumController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

//    public static void main(String[] args) {
//        new SpringApplicationBuilder(Application.class).
//                initializers(new SpringAppContextInitializer())
//                .application()
//                .run(args);
//    }
//
//

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        //DatasourceConfig datasourceConfig = new;
        //DatasourceConfig.dataSource();
        System.out.println("Hello");
    }


    @Autowired
    DatasourceConfig datasourceConfig;

    @Bean
    public CommandLineRunner setupDatasource() {
        return args -> System.out.println(datasourceConfig.dataSource());
    }

}

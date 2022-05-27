package online.tribefeed.tribefeedspring;

import online.tribefeed.tribefeedspring.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class TribeFeedSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TribeFeedSpringApplication.class, args);
    }

}

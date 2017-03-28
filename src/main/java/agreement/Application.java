package agreement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Radek on 07.03.2017.
 */
@SpringBootApplication
@EntityScan(basePackages = "agreement.core.entities")
@EnableJpaRepositories(basePackages = "agreement.core.repositories")
@EnableTransactionManagement
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

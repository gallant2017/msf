package zone.msf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by huangjunhao on 18/10/8.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MsfWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsfWebApplication.class, args);
    }
}

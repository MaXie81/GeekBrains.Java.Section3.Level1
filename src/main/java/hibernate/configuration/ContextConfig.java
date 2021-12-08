package hibernate.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PreDestroy;

@Configuration
@ComponentScan("hibernate/*")
public class ContextConfig {
}


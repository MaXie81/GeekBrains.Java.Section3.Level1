package spring.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring.beans")
public class SpringContext {
    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class);
    public static AnnotationConfigApplicationContext getContext() {
        return context;
    }
    public static void closeContext() {
        context.close();
    }
}

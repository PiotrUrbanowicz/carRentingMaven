package curse;

import curse.configuration.AppConfiguration;
import curse.core.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class App {

    public static void main(String[] args)  {

        try {

            ApplicationContext pudeleczko=
                    new AnnotationConfigApplicationContext(AppConfiguration.class);
            Engine engine=pudeleczko.getBean(Engine.class);
            engine.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

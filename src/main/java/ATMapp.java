import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.kruczala.michal.configuration.AppConfiguration;
import pl.kruczala.michal.engine.Engine;

public class ATMapp {
    public static void main(String[] args) {
        ApplicationContext box =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        Engine engine = box.getBean(Engine.class);
        engine.start();
    }
}

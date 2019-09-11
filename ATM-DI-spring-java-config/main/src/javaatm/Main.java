package javaatm;

import config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);

        atmSimulator.run();
    }
}

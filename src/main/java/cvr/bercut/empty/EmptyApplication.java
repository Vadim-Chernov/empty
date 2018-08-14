package cvr.bercut.empty;

import cvr.bercut.admin.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmptyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println(args);
        if (args.length == 0) {
            System.out.println("Start as SPRING");
            SpringApplication.run(EmptyApplication.class, args);
        }
        else {
            System.out.println("Start as JAVAFX");
            Admin.main(args);

        }
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

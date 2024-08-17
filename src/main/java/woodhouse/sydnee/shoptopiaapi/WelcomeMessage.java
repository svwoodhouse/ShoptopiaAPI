package woodhouse.sydnee.shoptopiaapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WelcomeMessage {
    public String printWelcomeMessage() {
        return "Welcome to the Spring Boot Application!";
    }
}

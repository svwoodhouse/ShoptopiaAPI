package woodhouse.sydnee.shoptopiaapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import woodhouse.sydnee.shoptopiaapi.product.Product;

@SpringBootApplication
public class ShoptopiaapiApplication {

	private static final Logger log = LoggerFactory.getLogger(ShoptopiaapiApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShoptopiaapiApplication.class, args);
		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
		System.out.println(welcomeMessage);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Product product = new Product(1, "Product Title", "Product Desscription", "Beauty", "LOreal", 12.99,
					"img_url",
					"seller");
			log.info("Product" + product);
		};
	}

}

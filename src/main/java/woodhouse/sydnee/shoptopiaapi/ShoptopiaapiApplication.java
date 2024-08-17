package woodhouse.sydnee.shoptopiaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShoptopiaapiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShoptopiaapiApplication.class, args);
		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
		System.out.println(welcomeMessage);
	}

	// Can use this method to initilize database with initial data
	// @Bean
	// CommandLineRunner runner(ProductRepository productRepository) {
	// return args -> {
	// Product product = new Product(1, "Loreal Shampoo", "Shampoo", "Beauty",
	// "LOreal", 12.99,
	// "img_url.png",
	// "Loreal");
	// productRepository.createProduct(product);
	// };
	// }

}

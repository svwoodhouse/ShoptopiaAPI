package woodhouse.sydnee.shoptopiaapi.product;

import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductJsonDataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ProductJsonDataLoader.class);
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public ProductJsonDataLoader(ObjectMapper objectMapper, ProductRepository productRepository) {
        this.objectMapper = objectMapper;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/products.json")) {
                Products allProducts = objectMapper.readValue(inputStream, Products.class);
                log.info("Reading {} runs from JSON data and saving to in-memory collection.",
                        allProducts.products().size());
                productRepository.saveAll(allProducts.products());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Products from JSON data because the collection contains data");
        }
    }

}

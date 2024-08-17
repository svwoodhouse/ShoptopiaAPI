package woodhouse.sydnee.shoptopiaapi.product;

import java.util.*;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    List<Product> findAll() {
        return products;
    }

    Optional<Product> findByID(Integer id) {
        return products.stream().filter(product -> product.id() == id).findFirst();
    }

    void createProduct(Product product) {
        products.add(product);
    }

    void updateProduct(Product product, Integer id) {
        Optional<Product> existingProduct = findByID(id);
        if (existingProduct.isPresent()) {
            products.set(products.indexOf(existingProduct.get()), product);
        }
    }

    void deleteProduct(Integer id) {
        products.removeIf(product -> product.id() == id);
    }

    @PostConstruct
    private void init() {
        products.add(new Product(1, "P1", "P1", "Fashion", "Chanel", 0.00, "url_p1", null));
        products.add(new Product(2, "P2", "P2", "Fashion", "Chanel", 1200.00, "url_p2", null));
    }
}

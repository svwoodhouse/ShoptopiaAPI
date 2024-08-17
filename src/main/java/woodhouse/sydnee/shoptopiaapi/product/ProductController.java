package woodhouse.sydnee.shoptopiaapi.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/api/product/{id}")
    Product findByID(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findByID(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return product.get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/product/{id}")
    void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteProduct(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/api/product/{id}")
    void updateProduct(@Valid @RequestBody Product product, @PathVariable Integer id) {
        productRepository.updateProduct(product, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/product")
    void createProduct(@Valid @RequestBody Product product) {
        productRepository.createProduct(product);
    }

}

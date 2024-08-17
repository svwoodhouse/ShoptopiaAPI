package woodhouse.sydnee.shoptopiaapi.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import java.util.Optional;
import java.util.List;

@Repository
public class ProductRepository {
    private static final Logger log = LoggerFactory.getLogger(ProductRepository.class);
    private final JdbcClient jdbcClient;

    public ProductRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Product> findAll() {
        return jdbcClient.sql("select * from product").query(Product.class).list();
    }

    public Optional<Product> findByID(Integer id) {
        return jdbcClient.sql("select * from product where id = :id").param("id", id).query(Product.class).optional();
    }

    public void deleteProduct(Integer id) {
        var updated = jdbcClient.sql("delete from product where id = :id").param("id", id).update();
        Assert.state(updated == 1, "Failed to delete product " + id);
    }

    public void createProduct(Product product) {
        var updated = jdbcClient.sql(
                "insert into product(id, title, product_description, category, brand, price, image_url, seller) values (?,?,?,?,?,?,?,?)")
                .params(List.of(product.id(), product.title(), product.product_description(), product.category(),
                        product.brand(), product.price(), product.image_url(), product.seller()))
                .update();
        Assert.state(updated == 1, "Failed to create product " + product.title());
    }

    public void updateProduct(Product product, Integer id) {
        var updated = jdbcClient.sql(
                "update product set title = ?, product_description = ?, category = ?, brand = ?, price = ?, image_url = ?, seller = ? where id = ?")
                .params(List.of(product.title(), product.product_description(), product.category(), product.brand(),
                        product.price(), product.image_url(), product.seller(), id))
                .update();
        Assert.state(updated == 1, "Failed to update product " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from product").query().listOfRows().size();
    }

    public void saveAll(List<Product> products) {
        products.stream().forEach(this::createProduct);
    }
}

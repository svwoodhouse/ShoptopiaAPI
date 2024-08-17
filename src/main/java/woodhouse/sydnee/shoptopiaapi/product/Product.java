package woodhouse.sydnee.shoptopiaapi.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Product(
        @NotNull @Positive int id,
        @NotEmpty String title,
        String product_description,
        String category,
        String brand,
        @Positive double price,
        String image_url,
        String seller) {
}
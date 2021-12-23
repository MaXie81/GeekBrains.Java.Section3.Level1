package webshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    @NotNull(message = "{validation.productdto.title.null}")
    @NotEmpty(message = "{validation.productdto.title.eampty}")
    private String title;
    @NotNull(message = "{validation.productdto.cost.null}")
    @Positive(message = "{validation.productdto.cost.positive}")
    private Float cost;

    public ProductDto(@NotNull Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}

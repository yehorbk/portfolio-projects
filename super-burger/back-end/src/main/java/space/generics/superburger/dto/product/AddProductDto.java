package space.generics.superburger.dto.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import space.generics.superburger.entity.enums.ProductType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AddProductDto {
    
    @NotBlank(message = "The field 'title' cannot be null or empty")
    private String title;
    
    @NotBlank(message = "The field 'description' cannot be null or empty")
    private String description;
    
    @NotNull(message = "The field 'type' cannot be null")
    private ProductType type;
    
    @Positive(message = "The field 'weight' cannot be negative or zero")
    private double weight;
    
    @Positive(message = "The field 'price' cannot be negative or zero")
    private double price;
    
}

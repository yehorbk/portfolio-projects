package space.generics.superburger.dto.product;

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
public class ProductDto {
    
    private long id;
    
    private String title;
    
    private String description;
    
    private ProductType type;
    
    private double weight;
    
    private double price;
    
    private double discount;
    
    private String imageSrc;
    
}

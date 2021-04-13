package space.generics.superburger.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum ProductType {
    
    BURGER("Burger", "g"),
    DRINK("Drink", "ml"),
    DESSERT("Dessert", "g");
    
    private final String name;
    private final String units;
    
}

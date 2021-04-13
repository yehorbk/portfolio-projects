package space.generics.superburger.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum PaymentType {

    CASH("Cash"),
    CARD("Card");
    
    private final String name;
    
}

package space.generics.superburger.dto.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class PromotionDto {
    
    private long id;
    
    private String title;
    
    private String description;
    
    private String actionSrc;
    
    private String imageSrc;
    
}

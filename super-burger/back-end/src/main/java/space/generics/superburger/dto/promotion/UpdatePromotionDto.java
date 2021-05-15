package space.generics.superburger.dto.promotion;

import javax.validation.constraints.NotBlank;
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
@EqualsAndHashCode()
@ToString()
public class UpdatePromotionDto {
    
    @NotBlank(message = "The field 'title' cannot be null or empty")
    private String title;
    
    @NotBlank(message = "The field 'description' cannot be null or empty")
    private String description;
    
    @NotBlank(message = "The field 'actionSrc' cannot be null or empty")
    private String actionSrc;
    
}

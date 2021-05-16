package space.generics.superburger.dto.promotion;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UpdatePromotionDto {
    
    @NotBlank(message = "The field 'title' cannot be null or empty")
    private String title;
    
    @NotBlank(message = "The field 'description' cannot be null or empty")
    private String description;
    
    @NotBlank(message = "The field 'actionSrc' cannot be null or empty")
    private String actionSrc;
    
    @NotNull(message = "The field 'expires' cannot be null")
    private LocalDateTime expires;
    
}

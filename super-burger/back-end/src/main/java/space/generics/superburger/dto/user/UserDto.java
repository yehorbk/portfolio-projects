package space.generics.superburger.dto.user;

import java.time.LocalDate;
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
public class UserDto {
    
    private long id;
    
    private String email;
    
    private String phone;
    
    private String firstName;
    
    private String secondName;
    
    private String gender;
    
    private LocalDate dateOfBirth;
    
    private String address;
    
}

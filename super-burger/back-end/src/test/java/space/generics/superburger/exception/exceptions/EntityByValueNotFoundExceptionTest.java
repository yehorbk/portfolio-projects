package space.generics.superburger.exception.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityByValueNotFoundExceptionTest {

    @Test
    void isValidMessage() {
        final String expected = "Entity with field=value not found";
        final String actual = new EntityByValueNotFoundException(
                "Entity", "field", "value").getMessage();
        Assertions.assertEquals(expected, actual);
    }
    
}

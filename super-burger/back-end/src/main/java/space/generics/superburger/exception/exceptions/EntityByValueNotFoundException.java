package space.generics.superburger.exception.exceptions;

import javax.persistence.EntityNotFoundException;

public class EntityByValueNotFoundException extends EntityNotFoundException {
    
    public EntityByValueNotFoundException(
            String entity, String field, String value) {
        super(String.format("%s with %s=%s not found", entity, field, value));
    }
    
}

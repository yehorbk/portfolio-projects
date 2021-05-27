package space.generics.superburger.exception.exceptions;

public class EmptyFileException extends RuntimeException {

    public EmptyFileException(String name) {
        super(String.format("File with name=%s is empty", name));
    }
    
}

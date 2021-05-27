package space.generics.superburger.exception.exceptions;

public class UnreachableLocalStorageException extends RuntimeException {

    public UnreachableLocalStorageException() {
        super("Local storage is unreachable");
    }
    
}

package Exceptions;

public class NoSeAceptaCeroException extends InputInvalidoException {
    public NoSeAceptaCeroException() {
        super("No se acepta cero");
    }
}

package Exceptions;

public class SoloMayorACeroException extends InputInvalidoException {
    public SoloMayorACeroException() {
        super("Solo números mayores a 0");
    }
}

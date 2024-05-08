package exceptions;

public class SenhaInvalidaException extends RuntimeException {
    private final String message;

    public SenhaInvalidaException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

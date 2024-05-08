package exceptions;

public class divisor0exceptio extends RuntimeException {
    private final String message;

    public divisor0exceptio(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

package exceptions;
public class AlreadyAuthenticatedException extends RuntimeException {
    public AlreadyAuthenticatedException() {
        super("already authenticated ");
    }
}

package exceptions;

public class NoSuchClientFound extends Exception {
    public NoSuchClientFound(String s) {
        super(s);
    }
}
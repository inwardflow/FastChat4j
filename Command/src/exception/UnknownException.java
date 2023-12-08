package exception;

public class UnknownException extends Exception {
    public UnknownException(String message) {
        super("无法找到" + message);
    }
}

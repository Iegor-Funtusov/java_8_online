package ua.com.alevel.exception;

public class NotValidFieldDataException extends RuntimeException {
    public NotValidFieldDataException(String msg) {
        super(msg);
    }
}

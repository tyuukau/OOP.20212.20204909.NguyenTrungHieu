package hust.soict.dsai.aims.exception;

public class IllegalItemException extends Exception {

	public IllegalItemException() {
	}

	public IllegalItemException(String message) {
		super(message);
	}

	public IllegalItemException(Throwable cause) {
		super(cause);
	}

	public IllegalItemException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

// This exception is thrown when trying to pass a non-existent item or a duplicate item to a method.
package nl.kylian.controller.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductIdMismatchException extends RuntimeException {

    public ProductIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProductIdMismatchException(final String message) {
        super(message);
    }

    public ProductIdMismatchException(final Throwable cause) {
        super(cause);
    }
}

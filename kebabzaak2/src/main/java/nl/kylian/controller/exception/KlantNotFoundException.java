package nl.kylian.controller.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KlantNotFoundException extends RuntimeException {

    public KlantNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public KlantNotFoundException(final String message) {
        super(message);
    }

    public KlantNotFoundException(final Throwable cause) {
        super(cause);
    }
}
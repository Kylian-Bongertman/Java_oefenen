package nl.kylian.controller.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KlantIdMismatchException extends RuntimeException {

    public KlantIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public KlantIdMismatchException(final String message) {
        super(message);
    }

    public KlantIdMismatchException(final Throwable cause) {
        super(cause);
    }
}

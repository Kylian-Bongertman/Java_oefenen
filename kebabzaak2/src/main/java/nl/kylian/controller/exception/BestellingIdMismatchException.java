package nl.kylian.controller.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BestellingIdMismatchException extends RuntimeException {

    public BestellingIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BestellingIdMismatchException(final String message) {
        super(message);
    }

    public BestellingIdMismatchException(final Throwable cause) {
        super(cause);
    }
}

package nl.kylian.controller.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BestellingNotFoundException extends RuntimeException {

    public BestellingNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BestellingNotFoundException(final String message) {
        super(message);
    }

    public BestellingNotFoundException(final Throwable cause) {
        super(cause);
    }
}
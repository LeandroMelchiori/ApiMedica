package med.vol.api.domain;

public class ValidacionException extends RuntimeException{
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}

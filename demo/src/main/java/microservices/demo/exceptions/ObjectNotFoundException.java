package microservices.demo.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String mensaje) {
        super(mensaje);
    }
}

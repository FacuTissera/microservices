package microservices.demo.exceptions;

public class ObjectAlreadyExists extends RuntimeException {
    public ObjectAlreadyExists(String mensaje) {
        super(mensaje);
    }
}

package dao;
public class PersistenciaException extends Exception {
    
    public PersistenciaException(String message) {
        super(message);
    }

    public PersistenciaException(String message, Throwable cause) {
		super(message, cause);
	}
}
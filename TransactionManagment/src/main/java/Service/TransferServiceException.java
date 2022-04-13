package Service;

public class TransferServiceException extends RuntimeException {



	public TransferServiceException() {
		super();
	}

	public TransferServiceException(String message) {
		super(message);
	}

	public TransferServiceException(Throwable cause) {
		super(cause);
	}

	public TransferServiceException(String message, Throwable cause) {
		super(message, cause);
	}



}

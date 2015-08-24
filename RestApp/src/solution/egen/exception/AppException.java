package solution.egen.exception;

public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5204682377475561838L;

	public AppException (String msg){
		super(msg);
	}
	
	public AppException (String msg, Throwable cause){
		super(msg , cause);
		
	}
}

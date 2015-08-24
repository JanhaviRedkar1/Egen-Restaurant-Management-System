package solution.egen.exception;

public class ExceptionResponse {
	public static final String ERROR = "error";
	private String status;
	
	/*public ExceptionResponse()
	{
		this.status = "success";
	}*/
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	private String msg;
	private Object payload;

}

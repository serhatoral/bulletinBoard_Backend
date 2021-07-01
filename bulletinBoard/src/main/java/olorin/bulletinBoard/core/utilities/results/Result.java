package olorin.bulletinBoard.core.utilities.results;


public class Result {

	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success,String messsage) {
		this(success);
		this.message = messsage;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}

package Beans;

public class User {
	private String name;
	private String email;
	private String password;
	private String message;

	public User() {

	}

	public User(String name,String email, String password) {
		this.name=name;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public boolean validate() {
		if(name == null || name.equals("")){
			message = "Enter your name";
			return false;
		}
		else if(!email.matches("\\w+\\@\\w+\\.\\w+")){
			message = "Invalid E-Mail";
			return false;

		}
		else if(password == null || password.length() < 8){
			message = "Password too Small-Must be atleast 8 Chars";
			return false;
		}
		else
		return true;
	}

	
}

package accountModel;

public class Account {
	private int user_id;
	private String username;
	private String full_name;
	private String email;
	private String phone;
	private String address;
	private int role;
	private boolean locked;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int user_id, String username, String full_name, String email, String phone, String address, int role,
			boolean locked) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.full_name = full_name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.locked = locked;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}

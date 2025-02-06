package userModel;

import java.util.Date;

public class User {
	private int user_id;
	private String username;
	private String password;
	private boolean locked;
	private int role;
	private Date created_at;
	private Date updated_at;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String username, String password, boolean locked, int role, Date created_at, Date updated_at) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.locked = locked;
		this.role = role;
		this.created_at = created_at;
		this.updated_at = updated_at;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", locked=" + locked
				+ ", role=" + role + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
}

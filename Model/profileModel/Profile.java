package profileModel;

import java.util.Date;

public class Profile {
	private int profile_id;
	private int user_id;
	private String full_name;
	private String email;
	private String phone;
	private Date date_of_birth;
	private String address;
	private String profile_picture_url;
	private String bio;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(int profile_id, int user_id, String full_name, String email, String phone, Date date_of_birth,
			String address, String profile_picture_url, String bio) {
		super();
		this.profile_id = profile_id;
		this.user_id = user_id;
		this.full_name = full_name;
		this.email = email;
		this.phone = phone;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.profile_picture_url = profile_picture_url;
		this.bio = bio;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfile_picture_url() {
		return profile_picture_url;
	}
	public void setProfile_picture_url(String profile_picture_url) {
		this.profile_picture_url = profile_picture_url;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
}

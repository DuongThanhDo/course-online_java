package registerCourseModel;

import java.util.Date;

public class registerCourse {
	private int id;
	private int student_id;
	private int course_id;
	private String full_name;
	private String title;
	private int status;
	private Date created_at;
	private Date updated_at;
	private String phone;
	private String address;
	private String email;
	public registerCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public registerCourse(int id, int student_id, int course_id, String full_name, String title, int status,
			Date created_at, Date updated_at, String phone, String address, String email) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.full_name = full_name;
		this.title = title;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

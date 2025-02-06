package courseStudentModel;

import java.util.Date;

public class courseStudent {
	private int student_id;
	private int course_id;
	private String title;
	private String description;
	private String photo;
	private int status;
	private Date created_at;
	private Date updated_at;
	public courseStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public courseStudent(int student_id, int course_id, String title, String description, String photo, int status,
			Date created_at, Date updated_at) {
		super();
		this.student_id = student_id;
		this.course_id = course_id;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
}

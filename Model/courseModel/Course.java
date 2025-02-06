package courseModel;

public class Course {
	private int course_id;
	private int teacher_id;
	private int category_id;
	private int type_id;
	private String full_name;
	private String title;
	private String category;
	private String description;
	private Float price;
	private int status;
	private String type;
	private String photo;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int course_id, int teacher_id, int category_id, int type_id, String full_name, String title,
			String category, String description, Float price, int status, String type, String photo) {
		super();
		this.course_id = course_id;
		this.teacher_id = teacher_id;
		this.category_id = category_id;
		this.type_id = type_id;
		this.full_name = full_name;
		this.title = title;
		this.category = category;
		this.description = description;
		this.price = price;
		this.status = status;
		this.type = type;
		this.photo = photo;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}

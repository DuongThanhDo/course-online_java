package categoryModel;

public class Category {
	private int category_id;
	private String title;
	private String description;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int category_id, String title, String description) {
		super();
		this.category_id = category_id;
		this.title = title;
		this.description = description;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
}

package typeModel;

public class Type {
	private int type_id;
	private String type_name;
	private String type_description;
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(int type_id, String type_name, String type_description) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.type_description = type_description;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getType_description() {
		return type_description;
	}
	public void setType_description(String type_description) {
		this.type_description = type_description;
	}
}

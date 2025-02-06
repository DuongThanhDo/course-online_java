package typeModel;

import java.util.ArrayList;

public class TypeBo {
	TypeDao tdao = new TypeDao();
	ArrayList<Type> ds;
	ArrayList<Type> dsT;
	public ArrayList<Type> getTypes() throws Exception {
		dsT = tdao.getTypes();
		return dsT;
	}
	
	public ArrayList<Type> getAll(int page, int pageSize, String searchValue) throws Exception {
		ds = tdao.getAll(page, pageSize, searchValue);
		
		return ds;
	}
	
	public Type getById(int type_id) throws Exception {
		return tdao.getById(type_id);
	}
	
	public int add(String type_name, String type_description) throws Exception {
		return tdao.add(type_name, type_description);
	}
	
	public int update(int type_id, String type_name, String type_description) throws Exception {
		return tdao.update(type_id, type_name, type_description);
	}
	
	public int delete(int type_id) throws Exception {
		return tdao.delete(type_id);
	}
	
	public int count(String searchValue) throws Exception {
		return tdao.count(searchValue);
	}
}

package categoryModel;

import java.util.ArrayList;

public class CategoryBo {
	CategoryDao cdao = new CategoryDao();
	ArrayList<Category> ds;
	ArrayList<Category> dsC;
	
	public ArrayList<Category> getCategories() throws Exception {
		dsC = cdao.getCategories();
		return dsC;
	}
	
	public ArrayList<Category> getAll(int page, int pageSize, String searchValue) throws Exception {
		ds = cdao.getAll(page, pageSize, searchValue);

		return ds;
	}
	
	public Category getById(int category_id) throws Exception {
		return cdao.getById(category_id);
	}
	
	public int add(String title, String description) throws Exception {
		return cdao.add(title, description);
	}
	
	public int update(int category_id, String title, String description) throws Exception {
		return cdao.update(category_id, title, description);
	}
	
	public int delete(int category_id) throws Exception {
		return cdao.delete(category_id);
	}	
	
	public int count(String searchValue) throws Exception {
		return cdao.count(searchValue);
	}
}

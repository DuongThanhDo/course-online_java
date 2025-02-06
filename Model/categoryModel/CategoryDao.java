package categoryModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectModel.Connect;

public class CategoryDao {
	public ArrayList<Category> getCategories() throws Exception {
		ArrayList<Category> ds = new ArrayList<Category>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Categories";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int category_id = rs.getInt("category_id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			
			ds.add(new Category(category_id, title, description));
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public ArrayList<Category> getAll(int page, int pageSize, String searchValue) throws Exception {
		ArrayList<Category> ds = new ArrayList<Category>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select *\r\n" + "from (\r\n"
				+ "    select *, ROW_NUMBER() over(order by category_id) as RowNumber\r\n" + "    from Categories\r\n"
				+ "    where (title like ?) \r\n" + ") as t\r\n" + "where (? = 0) \r\n"
				+ "    or (RowNumber between (? - 1) * ? + 1 and ? * ?)\r\n" + "order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, "%" + searchValue + "%");
		cmd.setInt(2, pageSize);
		cmd.setInt(3, page);
		cmd.setInt(4, pageSize);
		cmd.setInt(5, page);
		cmd.setInt(6, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int category_id = rs.getInt("category_id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			
			ds.add(new Category(category_id, title, description));
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public Category getById(int category_id) throws Exception {
		Category kq = null;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Categories where category_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, category_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			String title = rs.getString("title");
			String description = rs.getString("description");
			
			kq = new Category(category_id, title, description);
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return kq;
	}
	
	public int add(String title, String description) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into Categories(title, description) values(?, ?)";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, title);
		cmd.setString(2, description);
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}
	
	public int update(int category_id, String title, String description) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update Categories set title = ?, description = ? where category_id = ?";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, title);
		cmd.setString(2, description);
		cmd.setInt(3, category_id);
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}
	
	public int delete(int category_id) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "if not exists(select * from Courses where category_id = ?)\r\n"
				+ "	 					delete Categories where category_id = ?";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, category_id);
		cmd.setInt(2, category_id);
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}	
	
	public int count(String searchValue) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select count(*) from Categories where title like ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, "%" + searchValue + "%");
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return count;
	}
}

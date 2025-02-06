package typeModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectModel.Connect;

public class TypeDao {
	public ArrayList<Type> getTypes() throws Exception {
		ArrayList<Type> ds = new ArrayList<Type>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Types";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int type_id = rs.getInt("type_id");
			String type_name = rs.getString("type_name");
			String type_description = rs.getString("type_description");
			
			ds.add(new Type(type_id, type_name, type_description));
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public ArrayList<Type> getAll(int page, int pageSize, String searchValue) throws Exception {
		ArrayList<Type> ds = new ArrayList<Type>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select *\r\n" + "from (\r\n"
				+ "    select *, ROW_NUMBER() over(order by type_id) as RowNumber\r\n" + "    from Types\r\n"
				+ "    where (type_name like ?) \r\n" + ") as t\r\n" + "where (? = 0) \r\n"
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
			int type_id = rs.getInt("type_id");
			String type_name = rs.getString("type_name");
			String type_description = rs.getString("type_description");
			
			ds.add(new Type(type_id, type_name, type_description));
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public Type getById(int type_id) throws Exception {
		Type t = null;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Types where type_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, type_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			String type_name = rs.getString("type_name");
			String type_description = rs.getString("type_description");
			
			t = new Type(type_id, type_name, type_description);
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return t;
	}
	
	public int add(String type_name, String type_description) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into Types(type_name, type_description) values(?, ?)";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, type_name);
		cmd.setString(2, type_description);
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}
	
	public int update(int type_id, String type_name, String type_description) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update Types set type_name = ?, type_description = ? where type_id = ?";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, type_name);
		cmd.setString(2, type_description);
		cmd.setInt(3, type_id);
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}
	
	public int delete(int type_id) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "if not exists(select * from Courses where type_id = ?)\r\n"
				+ "	 					delete Types where type_id = ?";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, type_id);
		cmd.setInt(2, type_id);
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}	
	
	public int count(String searchValue) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select count(*) from Types where type_name like ?";

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

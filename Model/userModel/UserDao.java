package userModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import connectModel.Connect;

public class UserDao {
	public User login(String username, String password) throws Exception {
		User u = null;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Users where username = ? and password = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			int user_id = rs.getInt("user_id");
			String _username = rs.getString("username");
			String _password = rs.getString("password");
			boolean locked = rs.getBoolean("locked");
			int role = rs.getInt("role");
			Date created_at = rs.getDate("created_at");
			Date updated_at = rs.getDate("updated_at");
			
			u = new User(user_id, _username, _password, locked, role, created_at, updated_at);
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return u;
	}
	
	public int register(String username, String password, int role) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "INSERT INTO Users ( username, password, locked, role, created_at, updated_at) VALUES ( ?, ?, ?, ?, ?, ?)";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);
		cmd.setBoolean(3, false);
		cmd.setInt(4, role);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(5, currentDate);
		cmd.setDate(6, currentDate); 

		int kq = cmd.executeUpdate();
		
		cmd.close();kn.cn.close();
		
		return kq;
	}
	
	public boolean isUsernameExists(String username) throws Exception {
	    Connect kn = new Connect();
	    kn.connectDB();

	    String sql = "SELECT COUNT(*) AS count FROM Users WHERE username = ?";

	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, username);

	    ResultSet rs = cmd.executeQuery();

	    boolean exists = false;
	    if (rs.next()) {
	        int count = rs.getInt("count");
	        exists = count > 0;
	    }

	    rs.close();
	    cmd.close();
	    kn.cn.close();

	    return exists;
	}
}

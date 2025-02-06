package profileModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import connectModel.Connect;

public class ProfileDao {
	public Profile getProfileByUserId(int user_id) throws Exception {
		Profile p = null;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Profiles where user_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, user_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int profile_id = rs.getInt("profile_id");
			String full_name = rs.getString("full_name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			Date date_of_birth = rs.getDate("date_of_birth");
			String address = rs.getString("address");
			String profile_picture_url = rs.getString("profile_picture_url");
			String bio = rs.getString("bio");

			p = new Profile(profile_id, user_id, full_name, email, phone, date_of_birth, address, profile_picture_url, bio);
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return p;
	}
	
	public int add(Profile profile) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into Profiles(user_id, full_name, email, phone, date_of_birth,"
				+ "				           address, profile_picture_url, bio, created_at, updated_at) "
				+ "				  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, profile.getUser_id());
		cmd.setString(2, profile.getFull_name());
		cmd.setString(3, profile.getEmail());
		cmd.setString(4, profile.getPhone());
		cmd.setDate(5, new java.sql.Date(profile.getDate_of_birth().getTime()));
		cmd.setString(6, profile.getAddress());
		cmd.setString(7, profile.getProfile_picture_url());
		cmd.setString(8, profile.getBio());
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(9, currentDate);
		cmd.setDate(10,currentDate);
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}
	
	public int update(Profile profile) throws Exception {
		System.out.println(profile);
		Connect kn = new Connect();
		kn.connectDB();

	    String sql = "update Profiles "
	               + "set full_name = ?, email = ?, phone = ?, date_of_birth = ?, "
	               + "address = ?, profile_picture_url = ?, bio = ?, updated_at = ? "
	               + "where user_id = ?";
	    
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    
	    cmd.setString(1, profile.getFull_name());
	    cmd.setString(2, profile.getEmail());
	    cmd.setString(3, profile.getPhone());
	    cmd.setDate(4, new java.sql.Date(profile.getDate_of_birth().getTime()));
	    cmd.setString(5, profile.getAddress());
	    cmd.setString(6, profile.getProfile_picture_url());
	    cmd.setString(7, profile.getBio());
	    cmd.setDate(8, new java.sql.Date(System.currentTimeMillis()));
	    cmd.setInt(9, profile.getUser_id());
		
		int kq = cmd.executeUpdate();
		
		kn.cn.close();
		
		return kq;
	}
}

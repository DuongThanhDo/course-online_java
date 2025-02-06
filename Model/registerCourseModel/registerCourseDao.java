package registerCourseModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import connectModel.Connect;

public class registerCourseDao {
	public ArrayList<registerCourse> getAllRegisterByTeacher(int page, int pageSize, String searchValue, int status, int teacher_id)
			throws Exception {
		ArrayList<registerCourse> ds = new ArrayList<registerCourse>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from (select *, ROW_NUMBER() over(order by id) as RowNumber"
				+ "    from VTeacherRegisterCourse \r\n"
				+ "    where (title like ? or full_name like ?) and status = ? and teacher_id = ? ) as t where (? = 0) \r\n"
				+ "    or (RowNumber between (? - 1) * ? + 1 and ? * ?) order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int countInt = 1;
		cmd.setString(countInt++, "%" + searchValue + "%");
		cmd.setString(countInt++, "%" + searchValue + "%");
		cmd.setInt(countInt++, status);
		cmd.setInt(countInt++, teacher_id);
		cmd.setInt(countInt++, pageSize);
		cmd.setInt(countInt++, page);
		cmd.setInt(countInt++, pageSize);
		cmd.setInt(countInt++, page);
		cmd.setInt(countInt++, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			int student_id = rs.getInt("student_id");
			int course_id = rs.getInt("course_id");
			String full_name = rs.getString("full_name");
			String title = rs.getString("title");
			int status2 = rs.getInt("status");
			Date created_at = rs.getDate("created_at");
			Date updated_at = rs.getDate("updated_at");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			String email = rs.getString("email");

			ds.add(new registerCourse(id, student_id, course_id, full_name, title, status2, created_at, updated_at,
					phone, address, email));

		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public ArrayList<registerCourse> getLatestRegisterByTeacher(int teacher_id) throws Exception {
	    ArrayList<registerCourse> ds = new ArrayList<registerCourse>();

	    Connect kn = new Connect();
	    kn.connectDB();

	    String sql = "SELECT TOP 5 * " +
	                 "FROM VTeacherRegisterCourse " +
	                 "WHERE teacher_id = ? and status = 0 " +
	                 "ORDER BY created_at DESC";

	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, teacher_id);

	    ResultSet rs = cmd.executeQuery();

	    while (rs.next()) {
	        int id = rs.getInt("id");
	        int student_id = rs.getInt("student_id");
	        int course_id = rs.getInt("course_id");
	        String full_name = rs.getString("full_name");
	        String title = rs.getString("title");
	        int status = rs.getInt("status");
	        Date created_at = rs.getDate("created_at");
	        Date updated_at = rs.getDate("updated_at");
	        String phone = rs.getString("phone");
	        String address = rs.getString("address");
	        String email = rs.getString("email");

	        ds.add(new registerCourse(id, student_id, course_id, full_name, title, status, created_at, updated_at, phone, address, email));
	    }

	    rs.close();
	    cmd.close();
	    kn.cn.close();

	    return ds;
	}

	public int countAllRegisterByTeacher(String searchValue, int status, int teacher_id) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select count(*) from VTeacherRegisterCourse where (title like ? or full_name like ?) and status = ? and teacher_id = ? ";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, "%" + searchValue + "%");
		cmd.setString(2, "%" + searchValue + "%");
		cmd.setInt(3, status);
		cmd.setInt(4, teacher_id);
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return count;
	}
	
	public ArrayList<registerCourse> getAllRegisterByCourse(int page, int pageSize, String searchValue, int status, int course_id)
			throws Exception {
		ArrayList<registerCourse> ds = new ArrayList<registerCourse>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from (select *, ROW_NUMBER() over(order by id) as RowNumber"
				+ "    from VTeacherRegisterCourse \r\n"
				+ "    where (title like ? or full_name like ?) and status = ? and course_id = ? ) as t where (? = 0) \r\n"
				+ "    or (RowNumber between (? - 1) * ? + 1 and ? * ?) order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int countInt = 1;
		cmd.setString(countInt++, "%" + searchValue + "%");
		cmd.setString(countInt++, "%" + searchValue + "%");
		cmd.setInt(countInt++, status);
		cmd.setInt(countInt++, course_id);
		cmd.setInt(countInt++, pageSize);
		cmd.setInt(countInt++, page);
		cmd.setInt(countInt++, pageSize);
		cmd.setInt(countInt++, page);
		cmd.setInt(countInt++, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			int student_id = rs.getInt("student_id");
			int course_id2 = rs.getInt("course_id");
			String full_name = rs.getString("full_name");
			String title = rs.getString("title");
			int status2 = rs.getInt("status");
			Date created_at = rs.getDate("created_at");
			Date updated_at = rs.getDate("updated_at");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			String email = rs.getString("email");

			ds.add(new registerCourse(id, student_id, course_id2, full_name, title, status2, created_at, updated_at,
					phone, address, email));

		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}

	public int countAllRegisterByCourse(String searchValue, int status, int course_id) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select count(*) from VTeacherRegisterCourse where (title like ? or full_name like ?) and status = ? and course_id = ? ";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, "%" + searchValue + "%");
		cmd.setString(2, "%" + searchValue + "%");
		cmd.setInt(3, status);
		cmd.setInt(4, course_id);
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return count;
	}


	public int addRegisterCourse(int course_id, Integer user_id) throws Exception {
		if (user_id == null)
			return 0;

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into CourseRegister(student_id, course_id, status, created_at, updated_at) \r\n"
				+ "values(?, ?, 0, ?, ?)";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, user_id);
		cmd.setInt(2, course_id);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(3, currentDate);
		cmd.setDate(4, currentDate);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int updateRegisterCourse(int id, int status) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update CourseRegister set status = ?, updated_at = ? where id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, status);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(2, currentDate);
		cmd.setInt(3, id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public boolean checkRegisterCourse(int course_id, Integer user_id, int status) throws Exception {
		if (user_id == null)
			return false;

		boolean check = false;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from CourseRegister \r\n" + "where course_id = ? and student_id = ? and status = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, course_id);
		cmd.setInt(2, user_id);
		cmd.setInt(3, status);

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			check = true;
		}

		kn.cn.close();

		return check;
	}
}

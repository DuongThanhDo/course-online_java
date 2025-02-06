package courseStudentModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import connectModel.Connect;

public class courseStudentDao {
	public ArrayList<courseStudent> getAllCourseStudent(int student_id) throws Exception {
		ArrayList<courseStudent> ds = new ArrayList<>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from VStudentRegisterCourse where student_id = ? and status = 1 ;";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, student_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int student_id2 = rs.getInt("student_id");
			int course_id = rs.getInt("course_id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			String photo = rs.getString("photo");
			int status = rs.getInt("status");

			Date created_at = rs.getDate("created_at");
			Date updated_at = rs.getDate("updated_at");

			courseStudent courseNew = new courseStudent(student_id2, course_id, title, description, photo, status,
					created_at, updated_at);

			ds.add(courseNew);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
}

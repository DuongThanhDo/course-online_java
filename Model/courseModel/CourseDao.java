package courseModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectModel.Connect;

public class CourseDao {
	public ArrayList<Course> getAllCourses(int page, int pageSize, String searchValue, Integer category, Integer type,
			Integer status) throws Exception {
		ArrayList<Course> ds = new ArrayList<>();

		Connect kn = new Connect();
		kn.connectDB();

		String categoryCondition = (category == null) ? "1=1" : "category_id = ?";
		String typeCondition = (type == null) ? "1=1" : "type_id = ?";
		String statusCondition = (status == null) ? "1=1" : "status = ?";

		String sql = "select * from ( select *, ROW_NUMBER() over (order by course_id) as RowNumber "
				+ "    from VAdminManagerCourses " + "    where (title like ? or description like ?) and "
				+ categoryCondition + "      and " + typeCondition + " and " + statusCondition + ") as t "
				+ "where (? = 0) or (RowNumber between (? - 1) * ? + 1 and ? * ?) order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (category != null) {
			cmd.setInt(paramIndex++, category);
		}
		if (type != null) {
			cmd.setInt(paramIndex++, type);
		}
		if (status != null) {
			cmd.setInt(paramIndex++, status);
		}
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int courseId = rs.getInt("course_id");
			int teacherId = rs.getInt("teacher_id");
			int categoryId = rs.getInt("category_id");
			int typeId = rs.getInt("type_id");
			String fullName = rs.getString("full_name");
			String title = rs.getString("title");
			String category2 = rs.getString("category");
			String description = rs.getString("description");
			Float price = rs.getFloat("price");
			int status2 = rs.getInt("status");
			String type2 = rs.getString("type");
			String photo = rs.getString("photo");

			Course courseNew = new Course(courseId, teacherId, categoryId, typeId, fullName, title, category2,
					description, price, status2, type2, photo);

			ds.add(courseNew);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}

	public ArrayList<Course> getAllCourseByTeacher(int teacher_id, int page, int pageSize, String searchValue,
			Integer category, Integer type, Integer status) throws Exception {
		ArrayList<Course> ds = new ArrayList<>();

		Connect kn = new Connect();
		kn.connectDB();

		String categoryCondition = (category == null) ? "1=1" : "category_id = ?";
		String typeCondition = (type == null) ? "1=1" : "type_id = ?";
		String statusCondition = (status == null) ? "1=1" : "status = ?";

		String sql = "select * from ( select *, ROW_NUMBER() over (order by course_id) as RowNumber "
				+ "    from VAdminManagerCourses "
				+ "    where teacher_id = ? and (title like ? or description like ?) and "
				+ categoryCondition + " and " + typeCondition + " and " + statusCondition + ") as t "
				+ "where (? = 0) or (RowNumber between (? - 1) * ? + 1 and ? * ?) order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setInt(paramIndex++, teacher_id);
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (category != null) {
			cmd.setInt(paramIndex++, category);
		}
		if (type != null) {
			cmd.setInt(paramIndex++, type);
		}
		if (status != null) {
			cmd.setInt(paramIndex++, status);
		}
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int courseId = rs.getInt("course_id");
			int teacherId = rs.getInt("teacher_id");
			int categoryId = rs.getInt("category_id");
			int typeId = rs.getInt("type_id");
			String fullName = rs.getString("full_name");
			String title = rs.getString("title");
			String category2 = rs.getString("category");
			String description = rs.getString("description");
			Float price = rs.getFloat("price");
			int status2 = rs.getInt("status");
			String type2 = rs.getString("type");
			String photo = rs.getString("photo");

			Course courseNew = new Course(courseId, teacherId, categoryId, typeId, fullName, title, category2,
					description, price, status2, type2, photo);

			ds.add(courseNew);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public ArrayList<Course> getAllAdmin(int page, int pageSize, String searchValue) throws Exception {
		ArrayList<Course> ds = new ArrayList<>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from ( select *, ROW_NUMBER() over (order by course_id) as RowNumber "
				+ "    from VAdminManagerCourses "
				+ "    where (title like ?) and (status = 1 or status = -1)) as t "
				+ "where (? = 0) or (RowNumber between (? - 1) * ? + 1 and ? * ?) order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int courseId = rs.getInt("course_id");
			int teacherId = rs.getInt("teacher_id");
			int categoryId = rs.getInt("category_id");
			int typeId = rs.getInt("type_id");
			String fullName = rs.getString("full_name");
			String title = rs.getString("title");
			String category2 = rs.getString("category");
			String description = rs.getString("description");
			Float price = rs.getFloat("price");
			int status2 = rs.getInt("status");
			String type2 = rs.getString("type");
			String photo = rs.getString("photo");

			Course courseNew = new Course(courseId, teacherId, categoryId, typeId, fullName, title, category2,
					description, price, status2, type2, photo);

			ds.add(courseNew);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}

	public Course getCourseById(int course_id) throws Exception {
		Course cou = null;

		Connect kn = new Connect();
		kn.connectDB();
		
		String sql = "select * from VAdminManagerCourses where course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, course_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int courseId = rs.getInt("course_id");
			int teacherId = rs.getInt("teacher_id");
			int categoryId = rs.getInt("category_id");
			int typeId = rs.getInt("type_id");
			String fullName = rs.getString("full_name");
			String title = rs.getString("title");
			String category2 = rs.getString("category");
			String description = rs.getString("description");
			Float price = rs.getFloat("price");
			int status2 = rs.getInt("status");
			String type2 = rs.getString("type");
			String photo = rs.getString("photo");

			cou = new Course(courseId, teacherId, categoryId, typeId, fullName, title, category2,
					description, price, status2, type2, photo);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return cou;
	}

	public int countTeacher(int teacher_id, String searchValue, Integer category, Integer type, Integer status) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String categoryCondition = (category == null) ? "1=1" : "category_id = ?";
		String typeCondition = (type == null) ? "1=1" : "type_id = ?";
		String statusCondition = (status == null) ? "1=1" : "status = ?";

		String sql = "select count(*) from VAdminManagerCourses where teacher_id = ? and  (title like ? or description like ?) "
				+ "  and " + categoryCondition + "  and " + typeCondition + "  and " + statusCondition;

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setInt(paramIndex++, teacher_id);
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (category != null) {
			cmd.setInt(paramIndex++, category);
		}
		if (type != null) {
			cmd.setInt(paramIndex++, type);
		}
		if (status != null) {
			cmd.setInt(paramIndex++, status);
		}

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return count;
	}
	
	public int countAll(String searchValue, Integer category, Integer type, Integer status) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String categoryCondition = (category == null) ? "1=1" : "category_id = ?";
		String typeCondition = (type == null) ? "1=1" : "type_id = ?";
		String statusCondition = (status == null) ? "1=1" : "status = ?";

		String sql = "select count(*) " + "from VAdminManagerCourses " + "where (title like ?) "
				+ "  and " + categoryCondition + "  and " + typeCondition + "  and " + statusCondition;

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (category != null) {
			cmd.setInt(paramIndex++, category);
		}
		if (type != null) {
			cmd.setInt(paramIndex++, type);
		}
		if (status != null) {
			cmd.setInt(paramIndex++, status);
		}

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return count;
	}
	
	public int countAdmin(String searchValue) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select count(*) " + "from VAdminManagerCourses " + "where (title like ?) and (status = 1 or status = -1)";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return count;
	}

	public int add(int teacher_id, String title, int category_id, String description, Double price, int type_id, String photo)
			throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into Courses(teacher_id, title, category_id, description, price, status, type_id, photo, created_at, updated_at) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
				+ "select SCOPE_IDENTITY()";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		int paramIndex = 1;
		cmd.setInt(paramIndex++, teacher_id);
		cmd.setString(paramIndex++, title);
		cmd.setInt(paramIndex++, category_id);
		cmd.setString(paramIndex++, description);
		cmd.setDouble(paramIndex++, price);
		cmd.setInt(paramIndex++, 0);
		cmd.setInt(paramIndex++, type_id);
		cmd.setString(paramIndex++, photo); 
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(paramIndex++, currentDate);
		cmd.setDate(paramIndex++, currentDate);

		cmd.executeUpdate();

	    ResultSet getCourseId = cmd.getGeneratedKeys();
	    int courseId = -1; 
	    if (getCourseId.next()) {
	        courseId = getCourseId.getInt(1); 
	    }

	    getCourseId.close();
	    cmd.close();
	    kn.cn.close();

	    return courseId;
	}

	public int update(int course_id, String title, int category_id, String description, Double price, int type_id, String photo) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update Courses set title = ?, category_id = ?, description = ?, price = ?, type_id = ?, photo = ?, updated_at = ? where course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		int paramIndex = 1;
		cmd.setString(paramIndex++, title);
		cmd.setInt(paramIndex++, category_id);
		cmd.setString(paramIndex++, description);
		cmd.setDouble(paramIndex++, price);
		cmd.setInt(paramIndex++, type_id);
		cmd.setString(paramIndex++, photo);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(paramIndex++, currentDate);
		cmd.setInt(paramIndex++, course_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int updateStatus(int course_id, int status) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update Courses set status = ?, updated_at = ? where course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, status);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(2, currentDate);
		cmd.setInt(3, course_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int delete(int course_id) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "if exists (\r\n"
				+ "    select * from Courses where status = 0 and course_id = ?\r\n"
				+ ") begin\r\n"
				+ "    delete from Lectures where chapter_id in (\r\n"
				+ "        select chapter_id from Chapters where course_id = ?\r\n"
				+ "    );\r\n"
				+ "    delete from Chapters where course_id = ?;\r\n"
				+ "    delete from Courses where course_id = ?;\r\n"
				+ "end";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, course_id);
		cmd.setInt(2, course_id);
		cmd.setInt(3, course_id);
		cmd.setInt(4, course_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}
	
	public String getImageByCourseId(int course_id) throws Exception {
		String photo = null;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select photo from Courses where course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, course_id);

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			photo = rs.getString("photo");
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return photo;
	}

//	Student
	public ArrayList<Course> getCourseHot(int count) throws Exception {
		ArrayList<Course> ds = new ArrayList<>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select top " + count + " * from VAdminManagerCourses where status = 1";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int courseId = rs.getInt("course_id");
			int teacherId = rs.getInt("teacher_id");
			int categoryId = rs.getInt("category_id");
			int typeId = rs.getInt("type_id");
			String fullName = rs.getString("full_name");
			String title = rs.getString("title");
			String category2 = rs.getString("category");
			String description = rs.getString("description");
			Float price = rs.getFloat("price");
			int status2 = rs.getInt("status");
			String type2 = rs.getString("type");
			String photo = rs.getString("photo");

			Course courseNew = new Course(courseId, teacherId, categoryId, typeId, fullName, title, category2,
					description, price, status2, type2, photo);

			ds.add(courseNew);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public ArrayList<Course> getAllStudent(int page, int pageSize, String searchValue, Integer category) throws Exception {
		ArrayList<Course> ds = new ArrayList<>();

		Connect kn = new Connect();
		kn.connectDB();
		
		String categoryCondition = (category == null) ? "1=1" : "category_id = ?";

		String sql = "select * from ( select *, ROW_NUMBER() over (order by course_id) as RowNumber "
				+ "    from VAdminManagerCourses "
				+ "    where title like ? and status = 1 and " + categoryCondition + ") as t "
				+ "where (? = 0) or (RowNumber between (? - 1) * ? + 1 and ? * ?) order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (category != null) {
			cmd.setInt(paramIndex++, category);
		}
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int courseId = rs.getInt("course_id");
			int teacherId = rs.getInt("teacher_id");
			int categoryId = rs.getInt("category_id");
			int typeId = rs.getInt("type_id");
			String fullName = rs.getString("full_name");
			String title = rs.getString("title");
			String category2 = rs.getString("category");
			String description = rs.getString("description");
			Float price = rs.getFloat("price");
			int status2 = rs.getInt("status");
			String type2 = rs.getString("type");
			String photo = rs.getString("photo");

			Course courseNew = new Course(courseId, teacherId, categoryId, typeId, fullName, title, category2,
					description, price, status2, type2, photo);

			ds.add(courseNew);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public int countStudent(String searchValue, Integer category) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String categoryCondition = (category == null) ? "1=1" : "category_id = ?";

		String sql = "select count(*) from VAdminManagerCourses where title like ? and status = 1 and " + categoryCondition;

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (category != null) {
			cmd.setInt(paramIndex++, category);
		}
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

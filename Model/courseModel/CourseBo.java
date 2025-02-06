package courseModel;

import java.util.ArrayList;

public class CourseBo {
	CourseDao cdao = new CourseDao();
	ArrayList<Course> ds;
	ArrayList<Course> dsByTeacher;
	public ArrayList<Course> getAllCourses(int page, int pageSize, String searchValue, Integer category, Integer type, Integer status)
	        throws Exception {
		ds = cdao.getAllCourses(page, pageSize, searchValue, category, type, status);
		return ds;
	}
	public ArrayList<Course> getAllCourseByTeacher(int teacher_id, int page, int pageSize, String searchValue, Integer category, Integer type, Integer status)
	        throws Exception {
		dsByTeacher = cdao.getAllCourseByTeacher(teacher_id, page, pageSize, searchValue, category, type, status);
		return dsByTeacher;
	}

	public Course getCourseById(int course_id) throws Exception {
		return cdao.getCourseById(course_id);
	}
	
	public ArrayList<Course> getAllAdmin(int page, int pageSize, String searchValue) throws Exception {
		return cdao.getAllAdmin(page, pageSize, searchValue);
	}

	public int countTeacher(int teacher_id, String searchValue, Integer category, Integer type, Integer status) throws Exception {
		return cdao.countTeacher(teacher_id, searchValue, category, type, status);
	}

	public int countAll(String searchValue, Integer category, Integer type, Integer status) throws Exception {
		return cdao.countAll(searchValue, category, type, status);
	}

	public int countAdmin(String searchValue) throws Exception {
		return cdao.countAdmin(searchValue);
	}

	public int add(int teacher_id, String title, int category_id, String description, Double price, int type_id, String photo)
			throws Exception {
		return cdao.add(teacher_id, title, category_id, description, price, type_id, photo);
	}

	public int update(int course_id, String title, int category_id, String description, Double price, int type_id, String photo) throws Exception {
		return cdao.update(course_id, title, category_id, description, price, type_id, photo);
	}

	public int updateStatus(int course_id, int status) throws Exception {
		return cdao.updateStatus(course_id, status);
	}
	
	public int delete(int course_id) throws Exception {
		return cdao.delete(course_id);
	}
	
	public String getImageByCourseId(int course_id) throws Exception {
		return cdao.getImageByCourseId(course_id);
	}
	public ArrayList<Course> getCourseHot(int count) throws Exception {
		return cdao.getCourseHot(count);
	}
	
	public ArrayList<Course> getAllStudent(int page, int pageSize, String searchValue, Integer category) throws Exception {
		return cdao.getAllStudent(page, pageSize, searchValue, category);
	}
	
	public int countStudent(String searchValue, Integer category) throws Exception {
		return cdao.countStudent(searchValue, category);
	}
}

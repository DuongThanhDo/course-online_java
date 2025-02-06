package registerCourseModel;

import java.util.ArrayList;

public class registerCourseBo {
	registerCourseDao rcdao= new registerCourseDao();
	
	public ArrayList<registerCourse> getAllRegisterByTeacher(int page, int pageSize, String searchValue, int status, int teacher_id) throws Exception {
		return rcdao.getAllRegisterByTeacher(page, pageSize, searchValue, status, teacher_id);
	}

	public ArrayList<registerCourse> getLatestRegisterByTeacher(int teacher_id) throws Exception {
		return rcdao.getLatestRegisterByTeacher(teacher_id);
	}

	public int countAllRegisterByTeacher(String searchValue, int status, int teacher_id) throws Exception {
		return rcdao.countAllRegisterByTeacher(searchValue, status, teacher_id);
	}

	public ArrayList<registerCourse> getAllRegisterByCourse(int page, int pageSize, String searchValue, int status, int course_id) throws Exception {
		return rcdao.getAllRegisterByCourse(page, pageSize, searchValue, status, course_id);
	}

	public int countAllRegisterByCourse(String searchValue, int status, int course_id) throws Exception {
		return rcdao.countAllRegisterByCourse(searchValue, status, course_id);
	}
	
	public int addRegisterCourse(int course_id, Integer user_id) throws Exception {
		return rcdao.addRegisterCourse(course_id, user_id);
	}
	
	public int updateRegisterCourse(int id, int status) throws Exception {	
		return rcdao.updateRegisterCourse(id, status);
	}
	
	public boolean checkRegisterCourse(int course_id, Integer user_id, int status) throws Exception {
		return rcdao.checkRegisterCourse(course_id, user_id, status);
	}
}

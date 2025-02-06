package courseStudentModel;

import java.util.ArrayList;

public class courseStudentBo {
	courseStudentDao csd = new courseStudentDao();

	public ArrayList<courseStudent> getAllCourseStudent(int student_id) throws Exception {
		return csd.getAllCourseStudent(student_id);
	}

}

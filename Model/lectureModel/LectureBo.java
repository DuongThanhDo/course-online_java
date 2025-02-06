package lectureModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectModel.Connect;

public class LectureBo {
	LectureDao lecdao = new LectureDao();
	
	public ArrayList<Lecture> getLectures(int course_id) throws Exception {
		return lecdao.getLectures(course_id);
	}
	
	public int countByCourse(int course_id) throws Exception {
		return lecdao.countByCourse(course_id);
	}
	
	public Lecture getLectureById(int lecture_id) throws Exception {
		return lecdao.getLectureById(lecture_id);
	}

	public int add(int chapter_id, String title, String content, String video) throws Exception {
		return lecdao.add(chapter_id, title, content, video);
	}

	public int update(int lecture_id, String title, String content, String video) throws Exception {
		return lecdao.update(lecture_id, title, content, video);
	}

	public int delete(int lecture_id) throws Exception {
		return lecdao.delete(lecture_id);
	}
}

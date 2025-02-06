package noteModel;

import java.util.ArrayList;


public class NoteBo {
	NoteDao ndao = new NoteDao();
	
	public ArrayList<Note> getNotes(int student_id, int course_id) throws Exception {
		return ndao.getNotes(student_id, course_id);
	}

	public Note getNoteById(int note_id) throws Exception {
		return ndao.getNoteById(note_id);
	}

	public int add(int student_id, int course_id, int chapter_id, int lecture_id, String content, long timestamp) throws Exception {
		return ndao.add(student_id, course_id, chapter_id, lecture_id, content, timestamp);
	}

	public int update(int note_id, String content) throws Exception {
		return ndao.update(note_id, content);
	}

	public int delete(int note_id) throws Exception {
		return ndao.delete(note_id);
	}
}

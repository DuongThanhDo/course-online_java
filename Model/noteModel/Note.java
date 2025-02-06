package noteModel;

import java.util.Date;

public class Note {
	private int note_id;
	private int student_id;
	private int course_id;
	private int chapter_id;
	private int lecture_id;
	private String content;
	private long timestamp;
	private Date created_at;
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Note(int note_id, int student_id, int course_id, int chapter_id, int lecture_id, String content,
			long timestamp, Date created_at) {
		super();
		this.note_id = note_id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.chapter_id = chapter_id;
		this.lecture_id = lecture_id;
		this.content = content;
		this.timestamp = timestamp;
		this.created_at = created_at;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}

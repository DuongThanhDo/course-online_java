package chapterModel;

public class Chapter {
	private int chapter_id;
	private int course_id;
	private String title;
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chapter(int chapter_id, int course_id, String title) {
		super();
		this.chapter_id = chapter_id;
		this.course_id = course_id;
		this.title = title;
	}
	public int getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

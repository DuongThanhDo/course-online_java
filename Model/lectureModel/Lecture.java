package lectureModel;

public class Lecture {
	private int lecture_id;
	private int chapter_id;
	private String title;
	private String content;
	private String video;
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lecture(int lecture_id, int chapter_id, String title, String content, String video) {
		super();
		this.lecture_id = lecture_id;
		this.chapter_id = chapter_id;
		this.title = title;
		this.content = content;
		this.video = video;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public int getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
}

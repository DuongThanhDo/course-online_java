package chapterModel;

import java.util.ArrayList;

public class ChapterBo {
	ChapterDao chdao = new ChapterDao();
	
	public ArrayList<Chapter> getChapters(int course_id) throws Exception {
		return chdao.getChapters(course_id);
	}
	
	public Chapter getChapterById(int chapter_id) throws Exception {
		return chdao.getChapterById(chapter_id);
	}

	public int add(int course_id, String title) throws Exception {
		return chdao.add(course_id, title);
	}

	public int update(int chapter_id, String title) throws Exception {
		return chdao.update(chapter_id, title);
	}

	public int delete(int chapter_id) throws Exception {
		return chdao.delete(chapter_id);
	}
}

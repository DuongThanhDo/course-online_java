package lectureModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectModel.Connect;

public class LectureDao {
	public ArrayList<Lecture> getLectures(int course_id) throws Exception {
		ArrayList<Lecture> ds = new ArrayList<Lecture>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Lectures as l left join Chapters as c on l.chapter_id = c.chapter_id\r\n"
				+ "where c.course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, course_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int lecture_id = rs.getInt("lecture_id");
			int chapter_id = rs.getInt("chapter_id");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String video = rs.getString("video");

			ds.add(new Lecture(lecture_id, chapter_id, title, content, video));
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public int countByCourse(int course_id) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select count(*) from Lectures as l left join Chapters as c on l.chapter_id = c.chapter_id\r\n"
				+ "where c.course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, course_id);

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		
		return count;
	}
	
	public Lecture getLectureById(int lecture_id) throws Exception {
		Lecture lec = null;

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Lectures where lecture_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, lecture_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int lecture_id2 = rs.getInt("lecture_id");
			int chapter_id = rs.getInt("chapter_id");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String video = rs.getString("video");

			lec = new Lecture(lecture_id2, chapter_id, title, content, video);
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return lec;
	}

	public int add(int chapter_id, String title, String content, String video) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into Lectures(chapter_id, title, content, video, created_at, updated_at) values(?, ?, ?, ?, ?, ?)";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, chapter_id);
		cmd.setString(2, title);
		cmd.setString(3, content);
		cmd.setString(4, video);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(5, currentDate);
		cmd.setDate(6, currentDate); 
		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int update(int lecture_id, String title, String content, String video) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update Lectures set title=?, content=?, video=?, updated_at=? where lecture_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, title);
		cmd.setString(2, content);
		cmd.setString(3, video);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(4, currentDate);
		cmd.setInt(5, lecture_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int delete(int lecture_id) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "delete Lectures where lecture_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, lecture_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}
}

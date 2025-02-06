package chapterModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectModel.Connect;

public class ChapterDao {
	public ArrayList<Chapter> getChapters(int course_id) throws Exception {
		ArrayList<Chapter> ds = new ArrayList<Chapter>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Chapters where course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, course_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int chapter_id = rs.getInt("chapter_id");
			int course_id2 = rs.getInt("course_id");
			String title = rs.getString("title");

			ds.add(new Chapter(chapter_id, course_id2, title));
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public Chapter getChapterById(int chapter_id) throws Exception {
		Chapter chapter = null;

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from Chapters where chapter_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, chapter_id);

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			int chapter_id2 = rs.getInt("chapter_id");
			int course_id2 = rs.getInt("course_id");
			String title = rs.getString("title");

			chapter = new Chapter(chapter_id2, course_id2, title);
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return chapter;
	}

	public int add(int course_id, String title) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into Chapters(course_id, title) values(?, ?)";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, course_id);
		cmd.setString(2, title);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int update(int chapter_id, String title) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update Chapters set title = ? where chapter_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, title);
		cmd.setInt(2, chapter_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int delete(int chapter_id) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "if not exists(select * from Lectures where chapter_id = ?)\r\n"
				+ "	 					delete Chapters where chapter_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, chapter_id);
		cmd.setInt(2, chapter_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}
}

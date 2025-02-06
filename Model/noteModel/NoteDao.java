package noteModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import connectModel.Connect;

public class NoteDao {
	public ArrayList<Note> getNotes(int student_id, int course_id) throws Exception {
		ArrayList<Note> ds = new ArrayList<Note>();

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from NoteStudent where student_id = ? and course_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, student_id);
		cmd.setInt(2, course_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int note_id = rs.getInt("note_id");
			int student_id2 = rs.getInt("student_id");
			int course_id2 = rs.getInt("course_id");
			int chapter_id = rs.getInt("chapter_id");
			int lecture_id = rs.getInt("lecture_id");
			String content = rs.getString("content");
			long timestamp = rs.getLong("timestamp");
			Date created_at = rs.getDate("created_at");

			ds.add(new Note(note_id, student_id2, course_id2, chapter_id, lecture_id, content, timestamp, created_at));
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}

	public Note getNoteById(int note_id) throws Exception {
		Note note = null;

		Connect kn = new Connect();
		kn.connectDB();

		String sql = "select * from NoteStudent where note_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, note_id);

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			int note_id2 = rs.getInt("note_id");
			int student_id = rs.getInt("student_id");
			int course_id = rs.getInt("course_id");
			int chapter_id = rs.getInt("chapter_id");
			int lecture_id = rs.getInt("lecture_id");
			String content = rs.getString("content");
			long timestamp = rs.getLong("timestamp");
			Date created_at = rs.getDate("created_at");

			note = new Note(note_id2, student_id, course_id, chapter_id, lecture_id, content, timestamp, created_at);
		}
		rs.close();
		cmd.close();
		kn.cn.close();

		return note;
	}

	public int add(int student_id, int course_id, int chapter_id, int lecture_id, String content, long timestamp) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "insert into NoteStudent(student_id, course_id, chapter_id, lecture_id, content, timestamp, created_at) "
					+ "values(?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, student_id);
		cmd.setInt(2, course_id);
		cmd.setInt(3, chapter_id);
		cmd.setInt(4, lecture_id);
		cmd.setString(5, content);
		cmd.setLong(6, timestamp);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		cmd.setDate(7, currentDate);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}
	
	public int update(int note_id, String content) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update NoteStudent set content = ? where note_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, content);
		cmd.setInt(2, note_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

	public int delete(int note_id) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "delete NoteStudent where note_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, note_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}
}

package Controller.teacher;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import categoryModel.CategoryBo;
import chapterModel.Chapter;
import chapterModel.ChapterBo;
import courseModel.CourseBo;
import lectureModel.Lecture;
import lectureModel.LectureBo;
import typeModel.TypeBo;

/**
 * Servlet implementation class lectureDelete
 */
@WebServlet("/teacher/course/lecture/delete")
public class lectureDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lectureDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		LectureBo lbo = new LectureBo();
		ChapterBo chapbo = new ChapterBo();

		try {
			String lectureId = request.getParameter("lecture_id");
			if (lectureId != null) {
				int lecture_id = Integer.parseInt(lectureId);
				Lecture lecture = lbo.getLectureById(lecture_id);
				Chapter chapter = chapbo.getChapterById(lecture.getChapter_id());

				String video = lecture.getVideo();
				String dirUrl = request.getServletContext().getRealPath("") + File.separator + video;

				int checkDel = lbo.delete(lecture_id);

				if (checkDel == -1) {
					request.setAttribute("message", "Bài giảng đang được sử dụng không thể xóa!");

				} else if (checkDel == 1) {
					File file = new File(dirUrl);
					if (file.exists()) {
						if (file.delete()) {
							System.out.println("Video đã được xóa: " + dirUrl);
						} else {
							System.out.println("Không thể xóa video: " + dirUrl);
						}
					} else {
						System.out.println("File không tồn tại: " + dirUrl);
					}
					request.setAttribute("message", "Xóa thành công!");
				}

				int course_id = chapter.getCourse_id();
				
				response.sendRedirect("/CourseOnline/teacher/course?update=" + course_id);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/CourseOnline/teacher/course");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Controller.teacher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import categoryModel.CategoryBo;
import chapterModel.Chapter;
import chapterModel.ChapterBo;
import courseModel.Course;
import courseModel.CourseBo;
import lectureModel.LectureBo;
import typeModel.TypeBo;

/**
 * Servlet implementation class lecture
 */
@WebServlet("/teacher/course/lecture")
public class lecture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lecture() {
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

		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("user_id");
		
		if(user_id == null) {
			response.sendRedirect("/CourseOnline/login");
			return;
		}

		CourseBo cbo = new CourseBo();
		ChapterBo chapbo = new ChapterBo();
		LectureBo lecbo = new LectureBo();

		try {
			String create = request.getParameter("create");
			String update = request.getParameter("update");
			String lecture_id = request.getParameter("lecture_id");
			int chapter_id = 0;
			
			
			if(create != null) {
				chapter_id = Integer.parseInt(create);
				System.out.println("create lecture");
			}else if(update != null) {
				chapter_id = Integer.parseInt(update);
				System.out.println("update lecture");
				
				if(lecture_id == null) {
					request.setAttribute("Course", cbo.getCourseById(chapbo.getChapterById(chapter_id).getCourse_id()));
					request.setAttribute("Chapters", chapbo.getChapters(chapbo.getChapterById(chapter_id).getCourse_id()));
					request.setAttribute("Lectures", lecbo.getLectures(chapbo.getChapterById(chapter_id).getCourse_id()));
					RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-edit.jsp");
					rd.forward(request, response);
					return;
				}
				request.setAttribute("Lecture", lecbo.getLectureById(Integer.parseInt(lecture_id)));
			}
			Chapter chapter = chapbo.getChapterById(chapter_id);

			request.setAttribute("Chapter", chapter);
			RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/lecture-edit.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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

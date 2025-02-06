package Controller.student;

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
import registerCourseModel.registerCourseBo;
import typeModel.Type;
import typeModel.TypeBo;

/**
 * Servlet implementation class studentCourse
 */
@WebServlet("/student/course")
public class studentCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public studentCourse() {
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

		CourseBo cbo = new CourseBo();
		ChapterBo chapbo = new ChapterBo();
		LectureBo lecbo = new LectureBo();
		CategoryBo cabo = new CategoryBo();
		registerCourseBo rcbo = new registerCourseBo();
		Integer user_id = (Integer) session.getAttribute("user_id");

		try {
			int PAGE_SIZE = 12, page = 1, count = 0;
			String pageStr = request.getParameter("page");
			String searchValue = request.getParameter("searchValue");
			String categoryValue = request.getParameter("categoryValue");
			String detail = request.getParameter("detail");
			Integer category = null;
			if (detail != null) {
				int intDetail = Integer.parseInt(detail);

				if (rcbo.checkRegisterCourse(intDetail, user_id, 1)) {
					response.sendRedirect("/CourseOnline/student/course/content?course_id="+detail);
					return;
				} else {
					if (rcbo.checkRegisterCourse(intDetail, user_id, 0)) {
						request.setAttribute("statusRegister", 0);
					}
					request.setAttribute("Course", cbo.getCourseById(intDetail));
					request.setAttribute("Chapters", chapbo.getChapters(intDetail));
					request.setAttribute("Lectures", lecbo.getLectures(intDetail));
					RequestDispatcher rd = request.getRequestDispatcher("/student/pages/course-detail.jsp");
					rd.forward(request, response);
					return;
				}
			}

			if (pageStr != null)
				page = Integer.parseInt(pageStr);
			if (categoryValue != null && categoryValue != "")
				category = Integer.parseInt(categoryValue);
			if (searchValue == null)
				searchValue = "";
			count = cbo.countStudent(searchValue, category);

			ArrayList<Course> ds = cbo.getAllStudent(page, PAGE_SIZE, searchValue, category);

			int pageCount = (int) Math.ceil((double) count / PAGE_SIZE);

			request.setAttribute("currentPage", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("searchValue", searchValue);
			request.setAttribute("categoryValue", categoryValue);
			request.setAttribute("Courses", ds);
			request.setAttribute("Categories", cabo.getCategories());

			RequestDispatcher rd = request.getRequestDispatcher("/student/pages/course.jsp");
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

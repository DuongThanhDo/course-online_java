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

import courseModel.CourseBo;
import registerCourseModel.registerCourse;
import registerCourseModel.registerCourseBo;

/**
 * Servlet implementation class courseStudent
 */
@WebServlet("/teacher/course/student")
public class courseStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public courseStudent() {
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

		if (user_id == null) {
			response.sendRedirect("/CourseOnline/login");
			return;
		}

		registerCourseBo rcbo = new registerCourseBo();
		CourseBo cbo = new CourseBo();

		try {

			String strCourse_id = request.getParameter("course_id");

			if (strCourse_id != null) {
				int course_id = Integer.parseInt(strCourse_id);

				int PAGE_SIZE = 12, page = 1, count = 0;
				String pageStr = request.getParameter("page");
				String searchValue = request.getParameter("searchValue");

				if (pageStr != null)
					page = Integer.parseInt(pageStr);
				if (searchValue == null)
					searchValue = "";
				count = rcbo.countAllRegisterByCourse(searchValue, 1, course_id);

				ArrayList<registerCourse> ds = rcbo.getAllRegisterByCourse(page, PAGE_SIZE, searchValue, 1, course_id);

				int pageCount = (int) Math.ceil((double) count / PAGE_SIZE);

				request.setAttribute("currentPage", page);
				request.setAttribute("pageCount", pageCount);
				request.setAttribute("searchValue", searchValue);
				request.setAttribute("RegisterCourses", ds);
				request.setAttribute("Course", cbo.getCourseById(course_id));

				RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-detail-students.jsp");
				rd.forward(request, response);
				return;
			}

			response.sendRedirect("/CourseOnline/teacher/course");
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

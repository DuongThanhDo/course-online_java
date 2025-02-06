package Controller.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import courseModel.CourseBo;
import registerCourseModel.registerCourseBo;

/**
 * Servlet implementation class home
 */
@WebServlet("/teacher/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("user_id");

		if (user_id == null) {
			response.sendRedirect("/CourseOnline/login");
			return;
		}

		registerCourseBo rcbo = new registerCourseBo();
		CourseBo cbo = new CourseBo();
		
		try {
			
			request.setAttribute("countCourse", cbo.countTeacher(user_id, "", null, null, null));
			request.setAttribute("countStudentNew", rcbo.countAllRegisterByTeacher("", 0, user_id));
			request.setAttribute("NewStudentRegister", rcbo.getLatestRegisterByTeacher(user_id));
			
			RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/home.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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

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
import chapterModel.ChapterBo;
import courseModel.Course;
import courseModel.CourseBo;
import lectureModel.LectureBo;
import registerCourseModel.registerCourseBo;

/**
 * Servlet implementation class studentRegister
 */
@WebServlet("/student/course/register")
public class studentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		HttpSession session = request.getSession();

		registerCourseBo rcbo = new registerCourseBo();
		Integer user_id = (Integer) session.getAttribute("user_id");

		try {
			String registerCourse = request.getParameter("registerCourse");

			if (registerCourse != null) {
				if (user_id == null) {
					response.sendRedirect("/CourseOnline/login");
					return;
				}
				int intRegisterCourse = Integer.parseInt(registerCourse);
				if (!rcbo.checkRegisterCourse(intRegisterCourse, user_id, 0)) {
					int checkRegister = rcbo.addRegisterCourse(intRegisterCourse, user_id);
				}
			}

			response.sendRedirect("/CourseOnline/student/course?detail=" + registerCourse);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

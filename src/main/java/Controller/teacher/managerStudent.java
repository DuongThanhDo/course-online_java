package Controller.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import profileModel.Profile;
import profileModel.ProfileBo;
import registerCourseModel.registerCourse;
import registerCourseModel.registerCourseBo;
import typeModel.Type;

/**
 * Servlet implementation class managerStudent
 */
@WebServlet("/teacher/manager-student")
public class managerStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerStudent() {
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
		Integer user_id = (Integer) session.getAttribute("user_id");
		
		if(user_id == null) {
			response.sendRedirect("/CourseOnline/login");
			return;
		}
		
		registerCourseBo rcbo = new registerCourseBo();
		
		try {
			String accept = request.getParameter("accept");
			String reject = request.getParameter("reject");
			
			if(accept != null) {
				rcbo.updateRegisterCourse(Integer.parseInt(accept), 1);
			} else if(reject != null) {
				rcbo.updateRegisterCourse(Integer.parseInt(reject), -1);
			}
			
			int PAGE_SIZE = 12, page = 1, count = 0;
			String pageStr = request.getParameter("page");
			String searchValue = request.getParameter("searchValue");

			if (pageStr != null)
				page = Integer.parseInt(pageStr);
			if (searchValue == null)
				searchValue = "";
			count = rcbo.countAllRegisterByTeacher(searchValue, 0, user_id);

			ArrayList<registerCourse> ds = rcbo.getAllRegisterByTeacher(page, PAGE_SIZE, searchValue, 0, user_id);
			
			int pageCount = (int) Math.ceil((double) count / PAGE_SIZE);

			request.setAttribute("currentPage", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("searchValue", searchValue);
			request.setAttribute("RegisterCourses", ds);
			
			RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/student-request.jsp");
			rd.forward(request, response);
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

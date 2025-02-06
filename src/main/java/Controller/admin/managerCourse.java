package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseModel.Course;
import courseModel.CourseBo;

/**
 * Servlet implementation class managerCourse
 */
@WebServlet("/admin/courses")
public class managerCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerCourse() {
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
		
		CourseBo cbo = new CourseBo();
		
		try {
			int PAGE_SIZE = 7, page = 1, count = 0;
			String pageStr = request.getParameter("page");
			String searchValue = request.getParameter("searchValue");
			String lock = request.getParameter("lock");
			String unlock = request.getParameter("unlock");
			
			if(lock != null) {
				cbo.updateStatus(Integer.parseInt(lock), -1);
			} else if(unlock != null) {
				cbo.updateStatus(Integer.parseInt(unlock), 1);
			}

			if (pageStr != null)
				page = Integer.parseInt(pageStr);
			if (searchValue == null)
				searchValue = "";
			count = 6;
			
			ArrayList<Course> ds = cbo.getAllAdmin(page, PAGE_SIZE, searchValue);
			
			count = cbo.countAdmin(searchValue);
			
			int pageCount = (int) Math.ceil((double) count / PAGE_SIZE);

			request.setAttribute("currentPage", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("searchValue", searchValue);
			request.setAttribute("Courses", ds);

			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/courses.jsp");
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

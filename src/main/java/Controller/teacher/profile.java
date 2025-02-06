package Controller.teacher;

import java.io.IOException;
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

/**
 * Servlet implementation class profile
 */
@WebServlet("/teacher/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public profile() {
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
		
		try {
			ProfileBo pbo = new ProfileBo();
			
			Profile profile = pbo.getProfileByUserId(user_id);
			
			if(profile == null) {
	            Calendar calendar = Calendar.getInstance();
	            calendar.set(1900, Calendar.JANUARY, 1);
	            Date defaultDate = calendar.getTime();

	            pbo.add(new Profile(0, user_id, "", "", "", defaultDate, "", "", ""));
			}
			profile = pbo.getProfileByUserId(user_id);

			boolean edit = false;

			String btnAction = request.getParameter("action");
			if (btnAction != null) {
				switch (btnAction) {
				case "EDIT":
					edit = true;
					break;
				case "CANCEL":
					edit = false;
					break;
				default:
					break;
				}
			}

	        request.setAttribute("edit", edit);
	        request.setAttribute("profile", profile);
			session.setAttribute("profile_image", profile.getProfile_picture_url());
			RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/profile.jsp");
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

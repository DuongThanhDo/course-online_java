package Controller;

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
import javax.swing.RepaintManager;

import profileModel.Profile;
import profileModel.ProfileBo;
import userModel.User;
import userModel.UserBo;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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
		try {

			if (request.getParameter("btnLogin") != null) {

				session.removeAttribute("profile_image");
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				UserBo ub = new UserBo();
				ProfileBo pbo = new ProfileBo();

				User userCheck = ub.login(username, password);

				if (userCheck != null) {
					session.setAttribute("user_id", userCheck.getUser_id());
					Profile profileAcc = pbo.getProfileByUserId(userCheck.getUser_id());
					
					if(userCheck.isLocked()) {
						request.setAttribute("message", "Tài khoản đã bị khóa!");
						
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
						return;
					}
					
					if (profileAcc != null) {
						session.setAttribute("profile_image",
								pbo.getProfileByUserId(userCheck.getUser_id()).getProfile_picture_url());
					} else {
						Calendar calendar = Calendar.getInstance();
			            calendar.set(1900, Calendar.JANUARY, 1);
			            Date defaultDate = calendar.getTime();

			            pbo.add(new Profile(0, userCheck.getUser_id(), "", "", "", defaultDate, "", "", ""));
					}

					String role = "";
					if (userCheck.getRole() == 0)
						role = "ADMIN";
					else if (userCheck.getRole() == 1)
						role = "TEACHER";
					else if (userCheck.getRole() == 2)
						role = "STUDENT";

					switch (role) {
					case "ADMIN":
						response.sendRedirect("/CourseOnline/admin/home");
						break;
					case "TEACHER":
						response.sendRedirect("/CourseOnline/teacher/home");
						break;
					case "STUDENT":
						response.sendRedirect("/CourseOnline/student/home");
						break;
					default:
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
						break;
					}
					return;
				}
				request.setAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}

			String logout = request.getParameter("action");

			if ("logout".equals(logout)) {
			    if (session != null) {
			        session.invalidate();
			    }
			}

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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

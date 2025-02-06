package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userModel.User;
import userModel.UserBo;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		UserBo ub = new UserBo();
		try {

			if (request.getParameter("btnRegister") != null) {
				
				String role = request.getParameter("role");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String reEnterPassword = request.getParameter("reEnterPassword");
				
				if(ub.isUsernameExists(username)) {
					request.setAttribute("message", "Tên đăng nhập đã tồn tại!");
				}
				else if(password.equals(reEnterPassword)) {
					
					ub.register(username, password, Integer.parseInt(role));
					
					response.sendRedirect("/CourseOnline/login");
					return;
				}
				else {
					request.setAttribute("message", "Nhập lại mật khẩu không trùng khớp. Vui lòng nhập lại!");
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
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

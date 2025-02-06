package Controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accountModel.AccountBo;
import categoryModel.CategoryBo;
import courseModel.CourseBo;
import typeModel.TypeBo;

/**
 * Servlet implementation class home
 */
@WebServlet("/admin/home")
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		AccountBo abo = new AccountBo();
		CourseBo cbo = new CourseBo();
		CategoryBo cabo = new CategoryBo();
		TypeBo tbo = new TypeBo();
		
		try {

			request.setAttribute("countUser", abo.count("", null, null));
			request.setAttribute("NewUsers", abo.getNewestAccounts());
			request.setAttribute("countCourse", cbo.countAdmin(""));
			request.setAttribute("countType", tbo.count(""));
			request.setAttribute("countCategory", cabo.count(""));
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/home.jsp");
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

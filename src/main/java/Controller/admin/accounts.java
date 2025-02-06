package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accountModel.Account;
import accountModel.AccountBo;

/**
 * Servlet implementation class accounts
 */
@WebServlet("/admin/accounts")
public class accounts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public accounts() {
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
			AccountBo abo = new AccountBo();
			String lock = request.getParameter("lock");
			String unlock = request.getParameter("unlock");
			
			if(lock != null) {
				abo.updateLock(Integer.parseInt(lock), true);
			} else if(unlock != null) {
				abo.updateLock(Integer.parseInt(unlock), false);
			}
			

			// get data
			int PAGE_SIZE = 9, page = 1, count = 0;
			String pageStr = request.getParameter("page");
			String search = request.getParameter("searchValue");
			String strRole = request.getParameter("role");
			String strLocked = request.getParameter("locked");
			Integer role = null;
			Boolean locked = null;
			
			if (pageStr != null) {
			    page = Integer.parseInt(pageStr);
			}

			if (strRole != null && (strRole.equals("1") || strRole.equals("2"))) {
			    role = Integer.parseInt(strRole);
			}

			if (strLocked != null && (strLocked.equals("0") || strLocked.equals("1"))) {
				locked = strLocked.equals("1");
			}

			if (search == null) {
			    search = "";
			}

			ArrayList<Account> ds = abo.getAllAccounts(page, PAGE_SIZE, search, role, locked);
			count = abo.count(search, role, locked);

			int pageCount = (int) Math.ceil((double) count / PAGE_SIZE);

			request.setAttribute("pageCount", pageCount);
			request.setAttribute("currentPage", page);
			request.setAttribute("searchValue", search);
			request.setAttribute("Accounts", ds);

			
			RequestDispatcher rd3 = request.getRequestDispatcher("/admin/pages/accounts.jsp");
			rd3.forward(request, response);
		} catch (Exception e) {
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

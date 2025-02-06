package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typeModel.Type;
import typeModel.TypeBo;

/**
 * Servlet implementation class managerTypes
 */
@WebServlet("/admin/types")
public class managerTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public managerTypes() {
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
		try {
			String add = request.getParameter("add");
			String update = request.getParameter("update");
			String delete = request.getParameter("delete");
			TypeBo tbo = new TypeBo();

			if (add != null) {
				request.setAttribute("t", new Type(0, "", ""));
				RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/types-edit.jsp");
				rd.forward(request, response);
				return;
			} else if (update != null) {
				request.setAttribute("t", tbo.getById(Integer.parseInt(update)));
				RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/types-edit.jsp");
				rd.forward(request, response);
				return;

			} else if (delete != null) {
				int checkDel = tbo.delete(Integer.parseInt(delete));
				System.out.println("Day ne: " + checkDel);
				if (checkDel == -1) {
					request.setAttribute("message", "Loại đang được sử dụng không thể xóa!");
				} else if (checkDel == 1) {
					request.setAttribute("message", "Xóa thành công!");
				}
			}

			int PAGE_SIZE = 12, page = 1, count = 0;
			String pageStr = request.getParameter("page");
			String searchValue = request.getParameter("searchValue");

			if (pageStr != null)
				page = Integer.parseInt(pageStr);
			if (searchValue == null)
				searchValue = "";
			count = tbo.count(searchValue);

			ArrayList<Type> ds = tbo.getAll(page, PAGE_SIZE, searchValue);
			
			int pageCount = (int) Math.ceil((double) count / PAGE_SIZE);

			request.setAttribute("currentPage", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("searchValue", searchValue);
			request.setAttribute("Types", ds);

			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/types.jsp");
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

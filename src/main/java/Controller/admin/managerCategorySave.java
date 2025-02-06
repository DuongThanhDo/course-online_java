package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import categoryModel.CategoryBo;
import typeModel.TypeBo;

/**
 * Servlet implementation class managerCategorySave
 */
@WebServlet("/admin/categories/save")
public class managerCategorySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerCategorySave() {
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
		try {
			String save = request.getParameter("save");
			CategoryBo cbo = new CategoryBo();
			
			if (save != null) {
				String category_id = request.getParameter("category_id");
				String title = request.getParameter("title");
				String description = request.getParameter("description");
				switch (save) {
				case "add":
					cbo.add(title, description);
					break;
				case "update":
					cbo.update(Integer.parseInt(category_id), title, description);
					break;

				default:
					break;
				}
			}

			response.sendRedirect("/CourseOnline/admin/categories");
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

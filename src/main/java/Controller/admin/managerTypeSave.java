package Controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typeModel.TypeBo;

/**
 * Servlet implementation class managerTypeSave
 */
@WebServlet("/admin/types/save")
public class managerTypeSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerTypeSave() {
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
			TypeBo tbo = new TypeBo();
			
			if (save != null) {
				String type_id = request.getParameter("type_id");
				String type_name = request.getParameter("type_name");
				String type_description = request.getParameter("type_description");
				switch (save) {
				case "add":
					tbo.add(type_name, type_description);
					break;
				case "update":
					tbo.update(Integer.parseInt(type_id), type_name, type_description);
					break;

				default:
					break;
				}
			}

			response.sendRedirect("/CourseOnline/admin/types");
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

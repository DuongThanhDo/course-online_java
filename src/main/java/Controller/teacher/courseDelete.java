package Controller.teacher;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseModel.CourseBo;

/**
 * Servlet implementation class courseDelete
 */
@WebServlet("/teacher/course/delete")
public class courseDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseDelete() {
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

	    String course_id = request.getParameter("course_id");
	    CourseBo cbo = new CourseBo();
	    
	    try {
	        String anh = cbo.getImageByCourseId(Integer.parseInt(course_id));
	        String dirUrl = request.getServletContext().getRealPath("") + File.separator + anh;

	        int checkDel = cbo.delete(Integer.parseInt(course_id));
	        
	        if (checkDel == -1) {
				request.setAttribute("message", "Khóa đang được sử dụng không thể xóa!");
	            
			} else if (checkDel == 1) {
				File file = new File(dirUrl);
				if (file.exists()) {
					if (file.delete()) {
						System.out.println("Ảnh đã được xóa: " + dirUrl);
					} else {
						System.out.println("Không thể xóa ảnh: " + dirUrl);
					}
				} else {
					System.out.println("File không tồn tại: " + dirUrl);
				}
				request.setAttribute("message", "Xóa thành công!");
			}

	        response.sendRedirect("/CourseOnline/teacher/course");

	    } catch (Exception e) {
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

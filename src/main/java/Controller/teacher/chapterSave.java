package Controller.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import categoryModel.CategoryBo;
import chapterModel.ChapterBo;
import courseModel.CourseBo;
import lectureModel.LectureBo;
import typeModel.TypeBo;

/**
 * Servlet implementation class chapterSave
 */
@WebServlet("/teacher/course/chapter")
public class chapterSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public chapterSave() {
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

		CourseBo cbo = new CourseBo();
		ChapterBo chapbo = new ChapterBo();
		LectureBo lecbo = new LectureBo();

		try {
			String save = request.getParameter("save");
			String course_id = request.getParameter("course_id");

			if (course_id != null) {

				if (save != null) {
					switch (save) {
					case "add":
						System.out.println("add");
						String addNameChapter = request.getParameter("chapterName");
						int checkAdd = chapbo.add(Integer.parseInt(course_id), addNameChapter);
						if (checkAdd == 1) {
							request.setAttribute("message", "Thêm chương thành công!");
						} else if (checkAdd == 0) {
							request.setAttribute("message", "Thêm chương thất bại!");
						}
						break;
					case "update":
						System.out.println("update");
						String updateNameChapter = request.getParameter("chapterName");
						String chapter_id = request.getParameter("chapter_id");
						int checkUpdate = chapbo.update(Integer.parseInt(chapter_id), updateNameChapter);
						if (checkUpdate == 1) {
							request.setAttribute("message", "Sửa chương thành công!");
						} else if (checkUpdate == 0) {
							request.setAttribute("message", "Sửa chương thất bại!");
						}
						break;
					case "delete":
						System.out.println("delete");
						String chapter_id2 = request.getParameter("chapter_id");
						int checkDelete = chapbo.delete(Integer.parseInt(chapter_id2));
						if (checkDelete == 1) {
							request.setAttribute("message", "Xóa chương thành công!");
						} else if (checkDelete == 0) {
							request.setAttribute("message", "Xóa chương thất bại!");
						}
						break;

					default:
						break;
					}
				}

				response.sendRedirect("/CourseOnline/teacher/course?update=" + course_id);
				return;
			}

			response.sendRedirect("/CourseOnline/teacher/course");
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

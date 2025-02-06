package Controller.teacher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import categoryModel.CategoryBo;
import chapterModel.ChapterBo;
import courseModel.Course;
import courseModel.CourseBo;
import lectureModel.LectureBo;
import typeModel.Type;
import typeModel.TypeBo;

/**
 * Servlet implementation class course
 */
@WebServlet("/teacher/course")
public class course extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public course() {
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
			String create = request.getParameter("create");
			String update = request.getParameter("update");
			String post = request.getParameter("post");
			String detail = request.getParameter("detail");
			String content = request.getParameter("content");

			CourseBo cbo = new CourseBo();
			ChapterBo chapbo = new ChapterBo();
			LectureBo lecbo = new LectureBo();

			Integer user_id = (Integer) session.getAttribute("user_id");

			TypeBo tbo = new TypeBo();
			CategoryBo cabo = new CategoryBo();
			request.setAttribute("Types", tbo.getTypes());
			request.setAttribute("Categories", cabo.getCategories());

			if (user_id != null) {
				if (create != null) {
					RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-edit.jsp");
					rd.forward(request, response);
					return;

				} else if (update != null) {
					request.setAttribute("Course", cbo.getCourseById(Integer.parseInt(update)));
					request.setAttribute("Chapters", chapbo.getChapters(Integer.parseInt(update)));
					request.setAttribute("Lectures", lecbo.getLectures(Integer.parseInt(update)));
					RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-edit.jsp");
					rd.forward(request, response);
					return;
				} else if (post != null) {
					int checkPost = cbo.updateStatus(Integer.parseInt(post), 1);
					if (checkPost == 1) {
						request.setAttribute("message", "Đăng khóa học thành công!");
					} else {
						request.setAttribute("message", "Đăng khóa học thất bại!");
					}
				} else if (detail != null) {
					request.setAttribute("Course", cbo.getCourseById(Integer.parseInt(detail)));
					System.out.println("leclec: "+lecbo.countByCourse(Integer.parseInt(detail)));
					request.setAttribute("CountLecture", lecbo.countByCourse(Integer.parseInt(detail)));
					RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-details.jsp");
					rd.forward(request, response);
					return;

				} else if (content != null) {
					request.setAttribute("Course_id", content);
					RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-content.jsp");
					rd.forward(request, response);
					return;

				}

				int PAGE_SIZE = 9, page = 1, count = 0;
				String pageStr = request.getParameter("page");
				String searchValue = request.getParameter("searchValue");
				String strCategory = request.getParameter("category");
				String strType = request.getParameter("type");
				String strStatus = request.getParameter("status");
				Integer category = null;
				Integer type = null;
				Integer status = null;

				if (pageStr != null)
					page = Integer.parseInt(pageStr);

				if (strCategory != null && !strCategory.equals(""))
					category = Integer.parseInt(strCategory);

				if (strType != null && !strType.equals(""))
					type = Integer.parseInt(strType);

				if (strStatus != null && !strStatus.equals(""))
					status = Integer.parseInt(strStatus);

				if (searchValue == null)
					searchValue = "";
				count = cbo.countTeacher(user_id, searchValue, category, type, status);

				ArrayList<Course> ds = cbo.getAllCourseByTeacher(user_id, page, PAGE_SIZE, searchValue, category, type,
						status);

				int pageCount = (int) Math.ceil((double) count / PAGE_SIZE);

				request.setAttribute("currentPage", page);
				request.setAttribute("pageCount", pageCount);
				request.setAttribute("searchValue", searchValue);
				request.setAttribute("categoryValue", category);
				request.setAttribute("typeValue", type);
				request.setAttribute("statusValue", status);
				request.setAttribute("Courses", ds);

				if(request.getAttribute("message") != null) {
					request.setAttribute("message", request.getAttribute("message"));
				}
				RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course.jsp");
				rd.forward(request, response);
				return;
			}

			response.sendRedirect("/CourseOnline/login");
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

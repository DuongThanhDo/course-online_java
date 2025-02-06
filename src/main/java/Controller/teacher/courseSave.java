package Controller.teacher;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import categoryModel.CategoryBo;
import courseModel.CourseBo;
import profileModel.Profile;
import profileModel.ProfileBo;
import typeModel.TypeBo;

/**
 * Servlet implementation class courseSave
 */
@WebServlet("/teacher/course/save")
public class courseSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public courseSave() {
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

		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "assets/images/";
		response.getWriter().println(dirUrl1);

		Integer user_id = (Integer) session.getAttribute("user_id");
		int course_id = 0;
		String title = "";
		int category_id = 0;
		String description = "";
		Double price = (double) 0;
		int type_id = 0;
		String photo = "";
		String save = null;

		boolean checkAnh = false;
		Long dateTime = new Date().getTime();

		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						photo = "assets/images/"+ dateTime + nameimg;
						checkAnh = true;
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "assets/images/";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + dateTime + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
							System.out.println("Đường dẫn lưu file là: " + fileImg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String fieldName = fileItem.getFieldName();
					String fieldValue = fileItem.getString("UTF-8");
					switch (fieldName) {
					case "course_id":
						if (!fieldValue.equals(""))
							course_id = Integer.parseInt(fieldValue);
						break;
					case "title":
						title = fieldValue;
						break;
					case "category_id":
						category_id = Integer.parseInt(fieldValue);
						break;
					case "description":
						description = fieldValue;
						break;
					case "price":
						price = Double.parseDouble(fieldValue);
						break;
					case "type_id":
						type_id = Integer.parseInt(fieldValue);
						break;
					case "photo":
						if (!checkAnh) {
							photo = fieldValue;
						}
						break;
					case "save":
						save = fieldValue;
						break;
					}
				}
			}
			System.out.println("cate" + category_id + "course_id" + course_id + "user_id" + user_id);
			CourseBo cbo = new CourseBo();
			TypeBo tbo = new TypeBo();
			CategoryBo cabo = new CategoryBo();

			request.setAttribute("Types", tbo.getTypes());
			request.setAttribute("Categories", cabo.getCategories());
			System.out.println(save);

			if (save != null) {
				switch (save) {
				case "create":
					System.out.println("Thêm");
					int course_id1 = cbo.add(user_id, title, category_id, description, price, type_id, photo);
					request.setAttribute("Course", cbo.getCourseById(course_id1));
					RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-edit.jsp");
					rd.forward(request, response);
					return;
				case "update":
					System.out.println("Sửa");
					int checkUpdate = cbo.update(course_id, title, category_id, description, price, type_id, photo);
					if(checkUpdate == 0) {
						request.setAttribute("message", "Lỗi update khóa học!");
						request.setAttribute("Course", cbo.getCourseById(course_id));
						RequestDispatcher rd2 = request.getRequestDispatcher("/teacher/pages/course-edit.jsp");
						rd2.forward(request, response);
						return;
					}
					break;

				default:
					break;
				}
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

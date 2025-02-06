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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import categoryModel.CategoryBo;
import chapterModel.ChapterBo;
import courseModel.CourseBo;
import lectureModel.LectureBo;
import typeModel.TypeBo;

/**
 * Servlet implementation class lectureSave
 */
@WebServlet("/teacher/course/lecture/save")
public class lectureSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lectureSave() {
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

		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "assets/videos/";
		response.getWriter().println(dirUrl1);

		CourseBo cbo = new CourseBo();
		ChapterBo chapbo = new ChapterBo();
		LectureBo lecbo = new LectureBo();

		String save = null;
		Integer chapter_id = null;
		Integer lecture_id = null;
		String title = "";
		String content = "";
		String video = "";

		boolean checkVideo = false;
		Long dateVideo = new Date().getTime();

		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						video = "assets/videos/" + dateVideo + nameimg;
						checkVideo = true;
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "assets/videos/";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + dateVideo + nameimg;
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
					case "title":
						title = fieldValue;
						break;
					case "content":
						content = fieldValue;
						break;
					case "lecture_id":
						if (!fieldValue.equals(""))
							lecture_id = Integer.parseInt(fieldValue);
						break;
					case "chapter_id":
						if (!fieldValue.equals(""))
							chapter_id = Integer.parseInt(fieldValue);
						break;
					case "video":
						if (!checkVideo) {
							video = fieldValue;
						}
						break;
					case "save":
						save = fieldValue;
						break;
					}
				}
			}

			if (chapter_id != null) {

				if (save != null) {
					switch (save) {
					case "create":
						lecbo.add(chapter_id, title, content, video);
						break;
					case "update":
						System.out.println("update");
						if (lecture_id != null) {
							lecbo.update(lecture_id, title, content, video);
						}
						break;
					default:
						break;
					}
				}

				int course_id = chapbo.getChapterById(chapter_id).getCourse_id();

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

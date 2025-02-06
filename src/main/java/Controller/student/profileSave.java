package Controller.student;

import java.io.File;
import java.io.IOException;
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

import profileModel.Profile;
import profileModel.ProfileBo;

/**
 * Servlet implementation class profileSave
 */
@WebServlet("/student/profile/save")
public class profileSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileSave() {
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

		HttpSession session = request.getSession();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "assets/images/";
		response.getWriter().println(dirUrl1);

		int profile_id = 0;
		int user_id = 0;
		String full_name = "";
		String email = "";
		String phone = "";
		java.sql.Date date_of_birth = null;
		String address = "";
		String profile_picture_url = "";
		String bio = "";
		
		boolean checkAnh = false;
		
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						profile_picture_url = "assets/images/" + nameimg;
						checkAnh = true;
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "assets/images/";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
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
					case "profile_id":
						profile_id = Integer.parseInt(fieldValue);
						break;
					case "user_id":
						user_id = Integer.parseInt(fieldValue);
						break;
					case "full_name":
						full_name = fieldValue;
						break;
					case "email":
						email = fieldValue;
						break;
					case "phone":
						phone = fieldValue;
						break;
					case "date_of_birth":
						date_of_birth = java.sql.Date.valueOf(fieldValue);
						break;
					case "address":
						address = fieldValue;
						break;
					case "profile_picture_url":
						if(!checkAnh) {
							profile_picture_url = fieldValue;
						}
						break;
					case "bio":
						bio = fieldValue;
						break;
					}
				}
			}
			ProfileBo pbo = new ProfileBo();

			pbo.update(new Profile(profile_id, user_id, full_name, email, phone, date_of_birth, address, profile_picture_url, bio));
			
			Profile profile = pbo.getProfileByUserId(user_id);
			
			request.setAttribute("edit", false);
			request.setAttribute("profile", profile);
			session.setAttribute("profile_image", profile.getProfile_picture_url());
			RequestDispatcher rd = request.getRequestDispatcher("/student/pages/profile.jsp");
			rd.forward(request, response);
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

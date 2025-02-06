package Controller.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapterModel.Chapter;
import chapterModel.ChapterBo;
import courseModel.CourseBo;
import lectureModel.Lecture;
import lectureModel.LectureBo;
import profileModel.Profile;
import profileModel.ProfileBo;

/**
 * Servlet implementation class courseContent
 */
@WebServlet("/teacher/course/content")
public class courseContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseContent() {
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

		CourseBo cbo = new CourseBo();
		ChapterBo chapbo = new ChapterBo();
		LectureBo lecbo = new LectureBo();
		
		try {
			String strCourse_id = request.getParameter("course_id");
			String strChapter_id = request.getParameter("chapter_id");
			String strLecture_id = request.getParameter("lecture_id");
			
			if(strCourse_id != null) {
				int course_id = Integer.parseInt(strCourse_id);
				ArrayList<Chapter> Chapters = chapbo.getChapters(course_id);
				ArrayList<Lecture> Lectures = lecbo.getLectures(course_id);
				
				int chapter_id = Chapters.get(0).getChapter_id();
				int lecture_id = Lectures.get(0).getLecture_id();
				
				if(strChapter_id != null && strLecture_id != null) {
					chapter_id = Integer.parseInt(strChapter_id);
					lecture_id = Integer.parseInt(strLecture_id);
				}
				
				request.setAttribute("Course", cbo.getCourseById(course_id));
				request.setAttribute("Chapters", chapbo.getChapters(course_id));
				request.setAttribute("Lectures", lecbo.getLectures(course_id));
				request.setAttribute("Chapter", chapbo.getChapterById(chapter_id));
				request.setAttribute("Lecture", lecbo.getLectureById(lecture_id));
				RequestDispatcher rd = request.getRequestDispatcher("/teacher/pages/course-content.jsp");
				rd.forward(request, response);
				return;
			}
			
			response.sendRedirect("/CourseOnline/teacher/course");
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

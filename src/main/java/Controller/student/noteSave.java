package Controller.student;

import java.io.IOException;
import java.util.ArrayList;

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
import noteModel.Note;
import noteModel.NoteBo;

/**
 * Servlet implementation class noteSave
 */
@WebServlet("/student/course/note/save")
public class noteSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noteSave() {
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
		
		Integer user_id = (Integer)session.getAttribute("user_id");
		
		if(user_id == null) {
			response.sendRedirect("/CourseOnline/login");
			return;
		}
		
		NoteBo nobo = new NoteBo();
		
		try {
			String strCourse_id = request.getParameter("course_id");
			String strChapter_id = request.getParameter("chapter_id");
			String strLecture_id = request.getParameter("lecture_id");
			
			if(strCourse_id != null) {
				int course_id = Integer.parseInt(strCourse_id);
				
				String note_id = request.getParameter("note_id");
				String delete = request.getParameter("delete");
				if(note_id != null || delete != null) {
					Note note = null;
					if(note_id != null) {
						note = nobo.getNoteById(Integer.parseInt(note_id));
						String content = request.getParameter("content");
						nobo.update(Integer.parseInt(note_id), content);
					}
					else if(delete != null) {
						note = nobo.getNoteById(Integer.parseInt(delete));
						nobo.delete(Integer.parseInt(delete));
					}

					response.sendRedirect(
						    "/CourseOnline/student/course/content?course_id=" + strCourse_id
						    + "&chapter_id=" + strChapter_id
						    + "&lecture_id=" + strLecture_id
						    + "&note=true"
						);
					return;
				}
				
				long noteTime = 0;
				String strNoteTime = request.getParameter("noteTime");
				if(strNoteTime != null) {
					noteTime = Math.round(Double.parseDouble(strNoteTime));
					String noteContent = request.getParameter("noteContent");
					nobo.add(user_id, course_id, Integer.parseInt(strChapter_id), Integer.parseInt(strLecture_id), noteContent, noteTime);
					request.setAttribute("TimeVideo", noteTime);
				}
				
				response.sendRedirect(
					    "/CourseOnline/student/course/content?course_id=" + strCourse_id 
					    + "&chapter_id=" + strChapter_id 
					    + "&lecture_id=" + strLecture_id 
					    + "&time=" + noteTime
					);
				return;
			}
			
			response.sendRedirect("/CourseOnline/student/course");
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

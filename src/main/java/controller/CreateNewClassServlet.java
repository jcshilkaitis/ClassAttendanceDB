package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClassAttendance;
import model.Instructor;
import model.StudentInfo;

/**
 * Servlet implementation class CreateNewClassServlet
 */
@WebServlet("/createNewClassServlet")
public class CreateNewClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							
			StudentInfoHelper sih = new StudentInfoHelper();
			
			String className = request.getParameter("className");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String year = request.getParameter("year");
			String instructorName = request.getParameter("instructorName");
			LocalDate ld;
			try {
				ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			} catch (NumberFormatException ex) {
				ld = LocalDate.now();
			}
			String[] selectedItems = request.getParameterValues("allStudentsToAdd");
			List<StudentInfo> selectedStudents = new ArrayList<StudentInfo>();
			// make sure something was selected – otherwise we get a null pointer exception
			if (selectedItems != null && selectedItems.length > 0) {
				for (int i = 0; i < selectedItems.length; i++) {
					StudentInfo si = sih.searchForStudentById(Integer.parseInt(selectedItems[i]));
					selectedStudents.add(si);
				}
			}
			Instructor instructor = new Instructor(instructorName);
			ClassAttendance ca = new ClassAttendance(className, ld, instructor,selectedStudents);
			
			ClassAttendanceHelper cah = new ClassAttendanceHelper();
			cah.insertNewClassAttendance(ca);
			getServletContext().getRequestDispatcher("/viewAllAttendanceServlet").forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class EditClassAttendanceServlet
 */
@WebServlet("/editClassAttendanceServlet")
public class EditClassAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClassAttendanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassAttendanceHelper cah = new ClassAttendanceHelper();
		StudentInfoHelper sih = new StudentInfoHelper();
		InstructorHelper ih = new InstructorHelper();
		Integer id = Integer.parseInt(request.getParameter("id"));
		ClassAttendance classToUpdate = cah.searchForClassAttendanceById(id);
		String newClassName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String instructorName = request.getParameter("instructorName");
		Instructor newInstructor = ih.findInstructor(instructorName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
			String[] selectedStudents = request.getParameterValues("studentsToAdd");
			List<StudentInfo> selectedStudentsInList = new ArrayList<StudentInfo>();
			for (int i = 0; i < selectedStudents.length; i++) {
				System.out.println(selectedStudents[i]);
				StudentInfo si = sih.searchForStudentById(Integer.parseInt(selectedStudents[i]));
				selectedStudentsInList.add(si);
			}
			classToUpdate.setListOfStudents(selectedStudentsInList);
		} catch (NullPointerException ex) {
			List<StudentInfo> selectedItemsInList = new ArrayList<StudentInfo>();
			classToUpdate.setListOfStudents(selectedItemsInList);
		}
		classToUpdate.setClassName(newClassName);
		classToUpdate.setClassDate(ld);
		classToUpdate.setInstructor(newInstructor);
		cah.updateClass(classToUpdate);
		getServletContext().getRequestDispatcher("/viewAllAttendanceServlet").forward(request, response);
	}
	}


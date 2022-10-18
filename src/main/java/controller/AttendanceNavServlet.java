package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClassAttendance;

/**
 * Servlet implementation class AttendanceNavServlet
 */
@WebServlet("/attendanceNavServlet")
public class AttendanceNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceNavServlet() {
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
		String action = request.getParameter("action");
		if (action == null) {
			getServletContext().getRequestDispatcher("/viewAllAttendanceServlet").forward(request, response);
		} else if (action.equals("delete")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				ClassAttendance ClassToDelete = cah.searchForClassAttendanceById(id);
				cah.deleteClass(ClassToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllAttendanceServlet").forward(request, response);
			}
		} else if (action.equals("edit")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				ClassAttendance classToEdit = cah.searchForClassAttendanceById(id);
				request.setAttribute("classToEdit", classToEdit);
//				request.setAttribute("month", classToEdit.getClass().getMonthValue());
//				request.setAttribute("date", classToEdit.getTripDate().getDayOfMonth());
//				request.setAttribute("year", classToEdit.getTripDate().getYear());
				StudentInfoHelper daoForStudents = new StudentInfoHelper();
				request.setAttribute("allStudents", daoForStudents.showAllStudents());
				if (daoForStudents.showAllStudents().isEmpty()) {
					request.setAttribute("allStudents", " ");
				}
				getServletContext().getRequestDispatcher("/editclassattendance.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAttendanceServlet").forward(request, response);
			}
		} else if (action.equals("add")) {
			getServletContext().getRequestDispatcher("/newClass.jsp").forward(request, response);
		}
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentInfo;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/editStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
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
//		doGet(request, response);
		StudentInfoHelper dao = new StudentInfoHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String belt = request.getParameter("belt");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		StudentInfo studentToUpdate = dao.searchForStudentById(tempId);
		studentToUpdate.setFirstName(firstName);
		studentToUpdate.setLastName(lastName);
		studentToUpdate.setAge(age);
		studentToUpdate.setBelt(belt);
		
		dao.updateStudent(studentToUpdate);
		getServletContext().getRequestDispatcher("/viewAllStudentsServlet").forward(request, response);
	}

}

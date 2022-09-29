package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentInfo;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String stringAge = request.getParameter("age");
		int age = Integer.parseInt(stringAge);
		String beltRank = request.getParameter("beltRank");
		
		StudentInfo si = new StudentInfo(fName, lName, age, beltRank);
		StudentInfoHelper dao = new StudentInfoHelper();
		dao.insertStudent(si);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

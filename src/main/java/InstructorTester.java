import java.util.List;

import controller.InstructorHelper;
import model.Instructor;

/**
 * @author Joe Shilkaitis - jshilkaitis
 * CIS175 - Fall 2022
 * Oct 8, 2022
 */
public class InstructorTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub{
		
		Instructor joe = new Instructor("Joe");
		
		InstructorHelper ih = new InstructorHelper();
		
		ih.insertInstructor(joe);
		List<Instructor> allInstructors = ih.showAllInstructors();
		for (Instructor a : allInstructors) {
			System.out.println(a.toString());
		}
	}
}


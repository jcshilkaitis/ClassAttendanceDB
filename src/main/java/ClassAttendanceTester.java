import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.ClassAttendance;
import model.Instructor;
import model.StudentInfo;
import controller.ClassAttendanceHelper;


/**
 * @author Joe Shilkaitis - jshilkaitis
 * CIS175 - Fall 2022
 * Oct 7, 2022
 */
public class ClassAttendanceTester {
	public static void main(String[] args) {
		
		Instructor joe = new Instructor("Joe");
		
		ClassAttendanceHelper cah = new ClassAttendanceHelper();
		
		StudentInfo cameron = new StudentInfo("Cameron", "lastname", 20, "white");
		StudentInfo sam = new StudentInfo("Sam", "lastname", 21, "Yellow");
		StudentInfo connor = new StudentInfo("Connor", "lastname", 22, "Orange");


		List<StudentInfo> joesClass = new ArrayList<StudentInfo>();
		joesClass.add(cameron);
		joesClass.add(sam);
		joesClass.add(connor);

		ClassAttendance beginnerClass = new ClassAttendance("Beginner Class", LocalDate.now(), LocalTime.now(), joe, joesClass);
//		beginnerClass.setListOfStudents(joesClass);
		cah.insertNewClassAttendance(beginnerClass);

		List<ClassAttendance> allAttendance = cah.getAttendance();
		for (ClassAttendance a : allAttendance) {
			System.out.println(a.toString());
			
		}
	}
}


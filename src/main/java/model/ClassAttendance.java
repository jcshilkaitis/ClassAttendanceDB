package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * @author Joe Shilkaitis - jshilkaitis
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */
@Entity
public class ClassAttendance {
	@Id
	@GeneratedValue
	private int id;
	private String className;
	private LocalDate classDate;
	private LocalTime classTime;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Instructor instructor;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER )
	private List<StudentInfo> listOfStudents;
	
	
	
	public ClassAttendance() {
		super();
	}

	public ClassAttendance(int id, String className, LocalDate classDate, LocalTime classTime, Instructor instructor,
			List<StudentInfo> listOfStudents) {
		super();
		this.id = id;
		this.className = className;
		this.classDate = classDate;
		this.classTime = classTime;
		this.instructor = instructor;
		this.listOfStudents = listOfStudents;
	}

	public ClassAttendance(String className, LocalDate classDate, LocalTime classTime, Instructor instructor,
			List<StudentInfo> listOfStudents) {
		super();
		this.className = className;
		this.classDate = classDate;
		this.classTime = classTime;
		this.instructor = instructor;
		this.listOfStudents = listOfStudents;
	}
	
	

	public ClassAttendance(String className, LocalDate classDate, LocalTime classTime, Instructor instructor) {
		super();
		this.className = className;
		this.classDate = classDate;
		this.classTime = classTime;
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "ClassAttendance [id=" + id + ", className=" + className + ", classDate=" + classDate + ", classTime="
				+ classTime + ", instructor=" + instructor + ", listOfStudents=" + listOfStudents + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public LocalDate getClassDate() {
		return classDate;
	}

	public void setClassDate(LocalDate classDate) {
		this.classDate = classDate;
	}

	public LocalTime getClassTime() {
		return classTime;
	}

	public void setClassTime(LocalTime classTime) {
		this.classTime = classTime;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<StudentInfo> getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(List<StudentInfo> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}
	
	
}

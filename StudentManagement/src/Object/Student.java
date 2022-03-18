package Object;

import java.util.Objects;
import java.util.Scanner;

public class Student {
	private int ID;
	private String name;
	private int semester;
	private String course;
	
	public Student() {
	}
	
	public Student(int iD) {
		this.ID = iD;
	}
	
	public Student(int iD, String name, int semester, String course) {
		this.ID = iD;
		this.name = name;
		this.semester = semester;
		this.course = course;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public void informationStudent(Scanner sc, int id) {
		this.ID=id;
		System.out.print("Name: ");
		this.name = sc.nextLine();
		System.out.print("Semester: ");
		this.semester = Integer.parseInt(sc.nextLine());
		System.out.print("Course: ");
		this.course = sc.nextLine();
	}
	
	public void displayInformation() {
        System.out.println("Student [ID=" + ID + "| name=" + name + "| semester=" + semester + "| course=" + course + "]");
    }

	@Override
	public String toString() {
		return "Student [ID=" + ID + "| name=" + name + "| semester=" + semester + "| course=" + course + "]";
	}
}	

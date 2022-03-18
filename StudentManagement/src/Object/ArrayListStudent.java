package Object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListStudent {
	private ArrayList<Student> studentlist;
	Student st;

	public ArrayListStudent(ArrayList<Student> studentlist) {
		this.studentlist = studentlist;
	}

	public ArrayListStudent() {
		studentlist = new ArrayList<Student>();
	}

	
	public void addStudent(Student st) {
		studentlist.add(st);
	}
	
	public void addInformation(Scanner sc, int id) {
		st = new Student();
		st.informationStudent(sc, id);
		addStudent(st);
	}
	
	public void searchStudent(Scanner sc, int choice, int searchId, String searchName) {
		if(choice == 1) {
			for (Student student : studentlist) {
				if(searchId==student.getID()) {
					student.displayInformation();
				}
			}
		} else if(choice == 2) {
			for (Student student : studentlist) {
				if(searchName.equals(student.getName())) {
					student.displayInformation();
				}
			}
		}
	}
	
	public void updateStudent(Scanner sc, int size, int id) {
		int i;
		for(i=0; i<size; i++) {
			if(studentlist.get(i).getID()==id) {
				break;
			}
		}
		System.out.println("Change Information");
		sc.nextLine();
		System.out.print("Enter Name: ");
		studentlist.get(i).setName(sc.nextLine());
		System.out.print("Enter Semester: ");
		studentlist.get(i).setSemester(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter Course: ");
		studentlist.get(i).setCourse(sc.nextLine());
	}
	
	public void deleteSyudent(Scanner sc, int size, int id) {
		int i;
		for(i=0; i<size; i++) {
			if(studentlist.get(i).getID()==id) {
				break;
			}
		}
		studentlist.remove(i);
	}
	 
	public void Sortbyname() {
		Collections.sort(studentlist, new SortByName());
	}
	
	public void displayStudent() {
		System.out.println("-------------------------------");
		for (Student student : studentlist) {
			student.displayInformation();
		}
		System.out.println("-------------------------------");
	}
	
	public void report(int size) {
		String name_Student = null;
		String name_Course = null;
		int count = 0;
		Sortbyname();
		for(int i =0; i < size; i++) {
			if(studentlist.get(i).getName().equalsIgnoreCase(name_Student)
					&&studentlist.get(i).getCourse().equalsIgnoreCase(name_Course)) { 
				continue;
			} else {
				for(int j=i; j<size; j++) {
					if(studentlist.get(i).getName().equalsIgnoreCase(studentlist.get(j).getName())
							&&studentlist.get(i).getCourse().equalsIgnoreCase(studentlist.get(j).getCourse())) {
						name_Student = studentlist.get(i).getName();
						name_Course = studentlist.get(i).getCourse();
						count++;
					} else {
						
					}
				}
				System.out.println(name_Student+" | "+name_Course+" | "+count);
				count = 0;
			}
		}
	}
}


//studentlist.get(i).getCourse().equals(studentlist.get(j).getCourse())




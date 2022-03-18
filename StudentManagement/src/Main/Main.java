package Main;

import java.util.Scanner;

import Object.ArrayListStudent;
import Object.Student;

public class Main {
	
	public static void displayMenu() {
		System.out.println("+--------MENU--------+");
		System.out.println("|1. CREATE-----------|");
		System.out.println("|2. FIND AND SORT----|");
		System.out.println("|3. UPDATE/DELETE----|");
		System.out.println("|4. REPORT.----------|");
		System.out.println("|5. EXIT.------------|");
		System.out.println("+--------------------+");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayListStudent arrSt = new ArrayListStudent();
		int choice;
		boolean check = true;
		int id = 0;
		while(check) {
			displayMenu();
			System.out.print("ENTER CHOICE: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice){
				case 1:
					if(id==0) {
						for(int i=1; i<=3; i++) {
							id++;
							System.out.println("--------------------------");
							System.out.println("INFORMATION OF STUDENT: "+id);
							arrSt.addInformation(sc, id);
							System.out.println("--------------------------");
						}
						boolean check1 = true;
						while(check1) {
							System.out.println("Do you want to continue (Y/N)? Choose Y to \r\n"
									+ "continue (a student one time), N to return main screen.");
							String a;
							a = sc.nextLine();
							if(a.equalsIgnoreCase("y")) {
								id++;
								System.out.println("--------------------------");
								System.out.println("INFORMATION OF STUDENT: "+id);
								arrSt.addInformation(sc, id);
								System.out.println("--------------------------");
							} else if(a.equalsIgnoreCase("n")) {
								check1 = false;
							} else {
								System.out.println("-----------Choose again!----------");
							}
						}
						
					} else {
						id++;
						System.out.println("--------------------------");
						System.out.println("INFORMATION OF STUDENT: "+id);
						arrSt.addInformation(sc, id);
						System.out.println("--------------------------");
					}
					break;
				case 2:
					System.out.println("+----MENU----+");
					System.out.println("|1. FIND-----|");
					System.out.println("|2. SORT-----|");
					System.out.println("+------------+");
					System.out.print("ENTER CHOICE: ");
					choice = sc.nextInt();
					switch(choice) {
					case 1:
						System.out.println("+--------MENU-------+");
						System.out.println("|1. FIND BY ID------|");
						System.out.println("|2. FIND BY NAME----|");
						System.out.println("+-------------------+");
						System.out.print("ENTER CHOICE: ");
						choice = sc.nextInt();
						switch(choice) {
							case 1: 
								int searchId;
								sc.nextLine();
								System.out.print("FIND ID: ");
								searchId = sc.nextInt();
								if(choice==1) {
									arrSt.searchStudent(sc, choice, searchId, null);
								}
								break;
							case 2:
								String searchName;
								sc.nextLine();
								System.out.print("FIND NAME: ");
								searchName = sc.nextLine();
								if(choice==2) {
									arrSt.searchStudent(sc, choice, 0, searchName);
								}
								break;
						}
						break;
					case 2: 
						System.out.println("List of students after sorting by name:");
						arrSt.Sortbyname();
						arrSt.displayStudent();
						break;
					}
					break;
					
				case 3:
					int searchId;
					String n;
					System.out.println("Do you want to update (U) or delete (D) student");
					n = sc.nextLine();
					if(n.equalsIgnoreCase("U")) {
						System.out.print("FIND ID: ");
						searchId = sc.nextInt();
						arrSt.updateStudent(sc, id, searchId);
					} else if(n.equalsIgnoreCase("U")) {
						System.out.print("FIND ID: ");
						searchId = sc.nextInt();
						arrSt.deleteSyudent(sc, id, searchId);
					}
					break;
					
				case 4:
					arrSt.report(id);
					break;
			
				case 5:
					check = false;
					System.out.println("--CRE: DUC");
					System.out.println("-------END-------");
					
					break;
				default:
					System.out.println("-----Choose again!-----");
				
			}
		}
	}
}

package Object;

import java.util.Comparator;

public class SortByName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		int rs = o1.getName().compareTo(o2.getName());
		if(rs==0) {
			return o1.getCourse().compareTo(o2.getCourse());
		} else {
			return rs;
		}
	}
	
	

}

package a1_22BI13047;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentMan {
	public static void main(String[] args) {
		UndergradStudent s1 = new UndergradStudent(100000, "At2", "0123456789", "Hanoi");
		Student s2 = new Student(999, "At3", "0123456789", "Hanoi");
		PostgradStudent s3 = new PostgradStudent(1000000000, "At1", "0123456789", "Hanoi", 3.8f);
		Student s4 = new Student((int) 1e5, "At4", "0123456789", "Hanoi");
		Student s5 = new Student(999, "At5", "0123456789", "Hanoi");
		
		System.out.println(s3);
		s3.setGpa(2.0f);
		System.out.println(s3.getGpa());
		
		List<Student> students= new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		System.out.println(students);
		
		Collections.sort(students);
		System.out.println(students);
	}
}

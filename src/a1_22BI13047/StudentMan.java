package a1_22BI13047;

import java.util.Arrays;

public class StudentMan {
	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new UndergradStudent(10e5, "At2", "0123456789", "Hanoi");
		students[1] = new Student(999, "At3", "0123456789", "Hanoi");
		students[2] = new PostgradStudent(10e9, "At1", "0123456789", "Hanoi", 3.8);
		students[3] = new Student(10e5, "At4", "0123456789", "Hanoi");
		students[4] = new Student(999, "At5", "0123456789", "Hanoi");
		Arrays.sort(students);
		for (Student student : students) {
			System.out.println(student.toString());
		}
		System.out.println(students[3].equals(students[4]));
		System.out.println(students[1].equals(students[4]));
	}
}

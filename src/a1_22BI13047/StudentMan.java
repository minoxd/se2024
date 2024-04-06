package a1_22BI13047;

public class StudentMan {
	public static void main(String[] args) {
		Student a = new UndergradStudent(10e8, "At", "0123456789", "Hanoi");
		System.out.println(a.getId());
		
		System.out.println(a.getId());
		
		Student b = new PostgradStudent(10e8+1, "At", "0123456789", "Hanoi");

		System.out.println(b.getId());
	}
}

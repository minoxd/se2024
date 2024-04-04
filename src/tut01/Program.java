package tut01;

public class Program {
	public static void main(String[] args) {
		Person at = new Person(100, "At Nguyen");
    	if (at.setPhone(new MobilePhone("Google", "Pixel", 'B', 2020))) {
      		System.out.print(at.toString());
		}
	}
}

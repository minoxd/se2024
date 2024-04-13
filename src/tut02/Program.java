package tut02;

public class Program {
	public static void main(String[] args) 
			throws InterruptedException {
		Counter3 counter = new Counter3(9);
		
		while (true) {
			counter.incr(9);
			System.out.println(counter.getValue());
			
			Thread.sleep(1000);
		}
	}
}

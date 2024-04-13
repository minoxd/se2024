package tut01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		Person at = new Person(100, "At Nguyen");
    	if (at.setPhone(new MobilePhone("Google", "Pixel", 'B', 2020))) {
      		System.out.println(at.toString());
		}

    	Person a = new Person(1, "A");
    	Person b = new Person(2, "B");
    	Person c = new Person(3, "C");
    	
    	List<Person> people = new ArrayList<Person>();
    	people.add(a);
    	people.add(c);
    	people.add(b);
    	
    	System.out.println(people);
    	
    	Collections.sort(people);
    	System.out.println(people);
	}
}

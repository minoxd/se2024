package a1_22BI13047;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview PostgradStudent represents graduated student
 * @attributes
 * 	id			Integer		int
 * 	name		String
 * 	phoneNumber	String
 * 	address		String
 * 	gpa			Float		double
 * @object a typical PostgradStudent object is ps=<i, n, pN, a, g> where id(i), name(n), phoneNumber(pN), address(a), gpa(g)
 * @abstract_properties
 * 	P_Student.id /\ min(id)=1e8+1 /\ 
 * 	P_Student.name /\ 
 * 	P_Student.phoneNumber /\ 
 * 	P_Student.address /\ 
 * 	mutable(gpa)=true /\ optional(gpa)=false /\ min(gpa)=0.0 /\ max(gpa)=4.0 /\ 
 * @author minoxd 
 * 	https://github.com/minoxd/se2024
 */
public class PostgradStudent extends Student {
	// attributes
	@DomainConstraint(type = "Float", mutable = true, optional = false, min = MIN_GPA, max = MAX_GPA)
	private double gpa;
	
	// constants
	private static final int MIN_ID = (int) 1e8+1;
	private static final int MAX_ID = (int) 1e9;
	private static final double MIN_GPA = 0.0;
	private static final double MAX_GPA = 4.0;
	
	// constructors
	/**
	 * @modifies this.id, this.name, this.phoneNumber, this.address, this.gpa
	 * @effects <pre>
	 * 	if id, name, phoneNumber, address, gpa are valid
	 * 		initialize this as <id, name, phoneNumber, address, gpa>
	 * 	else
	 * 		initialize this as <> and inform error</pre>
	 */
	public PostgradStudent(
			@AttrRef("id") int id,
			@AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address,
			@AttrRef("gpa") double gpa)
					throws NotPossibleException {
		
		super(id, name, phoneNumber, address);
		
		if (!validateId(id)) {
			throw new NotPossibleException("Student.init: Invalid student id: " + id);
		}
		
		if (!validateGpa(gpa)) {
			throw new NotPossibleException("Student.init: Invalid student gpa: " + gpa);
		}
		
		this.gpa = gpa;
	}
	
	// mutators
	/**
	 * @modifies this.gpa
	 * @effects <pre>
	 * 	if gpa is valid
	 * 		set this.gpa=gpa
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	@DOpt(type=OptType.Mutator)
	@AttrRef("gpa")
	public boolean setGpa(double gpa) {
		if (validateGpa(gpa)) {
			this.gpa = gpa;
			return true;
		}	else {
			return false;
		}
	}
	
	// observers
	/**
	 * @effects return <tt>gpa</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("gpa")
	public double getGpa() {
		return this.gpa;
	}

	// validators
	/**
	 * @effects <pre>
	 * 	if id is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	@Override
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	protected boolean validateId(int id) {
		return (id >= MIN_ID &&
				id <= MAX_ID);
	}
	
	/**
	 * @effects <pre>
	 * 	if gpa is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateGpa(double gpa) {
		return (gpa >= MIN_GPA &&
				gpa <= MAX_GPA);
	}

	@Override
	public String toString() {
		String tmp = super.toString();
		return "Postgrad" + 
				tmp.substring(0, tmp.length() - 1) + 
				", " + gpa + 
				">";
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PostgradStudent)) {
			return false;
		}
		
		int yourId = ((Student) o).getId();
		return yourId == this.getId();
	}
	
	/**
	 * @effects <pre>
	 * 	if this satisfies abstract properties
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	public boolean repOK() {
		return super.repOK() && 
				validateGpa(gpa);
	}
}

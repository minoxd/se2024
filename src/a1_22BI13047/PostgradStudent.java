package a1_22BI13047;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview PostgradStudent represents graduated student
 * @attributes
 * 	id			Integer		double
 * 	name		String
 * 	phoneNumber	String
 * 	address		String
 * 	gpa			Float		double
 * @object a typical Student object is s=<i, n, pN, a, g> where id(i), name(n), phoneNumber(pN), address(a), gpa(g)
 * @abstract_properties
 * 	mutable(id)=false /\ optional(id)=false /\ min(id)=10e8+1 /\ max(id)=10^9 /\ 
 * 	mutable(name)=true /\ optional(name)=false /\ length(name)=50 /\ 
 * 	mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)=10 /\ 
 * 	mutable(address)=true /\ optional(address)=false /\ length(address)=100 /\ 
 * 	mutable(gpa)=true /\ optional(gpa)=false /\ min(gpa)=0.0 /\ max(gpa)=4.0 /\ 
 */
public class PostgradStudent extends Student {
	// attributes
	@DomainConstraint(type = "Float", mutable = true, optional = false, min = MIN_GPA, max = MAX_GPA)
	private double gpa;
	
	// constants
	private static final double MIN_ID = 10e8+1;
	private static final double MAX_ID = 10e9;
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
			@AttrRef("id") double id,
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
	private boolean validateId(double id) {
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
		
		double yourId = ((Student) o).getId();
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

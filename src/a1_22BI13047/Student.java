package a1_22BI13047;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview Student represents student
 * @attributes
 * 	id			Integer		double
 * 	name		String
 * 	phoneNumber	String
 * 	address		String
 * @object a typical Student object is s=<i, n, pN, a> where id(i), name(n), phoneNumber(pN), address(a)
 * @abstract_properties
 * 	mutable(id)=false /\ optional(id)=false /\ min(id)=1 /\ max(id)=10^9 /\ 
 * 	mutable(name)=true /\ optional(name)=false /\ length(name)=50 /\ 
 * 	mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)=10 /\ 
 * 	mutable(address)=true /\ optional(address)=false /\ length(address)=100 /\ 
 */
public class Student implements Comparable<Student> {
	// attributes
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	private double id;
	
	@DomainConstraint(type = "String", mutable = true, optional = false, length = LENGTH_NAME)
	private String name;
	
	@DomainConstraint(type = "String", mutable = true, optional = false, length = LENGTH_PHONE_NUMBER)
	private String phoneNumber;
	
	@DomainConstraint(type = "String", mutable = true, optional = false, length = LENGTH_ADDRESS)
	private String address;
	
	// constants
	private static final double MIN_ID = 1;
	private static final double MAX_ID = 10e9;
	private static final int LENGTH_NAME = 50;
	private static final int LENGTH_PHONE_NUMBER = 10;
	private static final int LENGTH_ADDRESS = 100;
	
	// constructor methods
	/**
	 * @modifies this.id, this.name, this.phoneNumber, this.address
	 * @effects <pre>
	 * 	if id, name, phoneNumber, address are valid
	 * 		initialize this as <id, name, phoneNumber, address>
	 * 	else
	 * 		initialize this as <> and inform error</pre>
	 */
	public Student(
			@AttrRef("id") double id,
			@AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address)
			throws NotPossibleException {
		if (!validateId(id)) {
			throw new NotPossibleException("Student.init: Invalid student id: " + id);
		}
		
		if (!validateName(name)) {
			throw new NotPossibleException("Student.init: Invalid student name: " + name);
		}
		
		if (!validatePhoneNumber(phoneNumber)) {
			throw new NotPossibleException("Student.init: Invalid student phone number: " + phoneNumber);
		}
		
		if (!validateAddress(address)) {
			throw new NotPossibleException("Student.init: Invalid student address: " + address);
		}
		
		// Initialize this as <id, name, phoneNumber, address>
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	// mutators
	/**
	 * @modifies this.name
	 * @effects <pre>
	 * 	if name is valid
	 * 		set this.name=name
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	@DOpt(type=OptType.Mutator)
	@AttrRef("name")
	public boolean setName(String name) {
		if (validateName(name)) {
			this.name = name;
			return true;
		}	else {
			return false;
		}
	}
	
	/**
	 * @modifies this.phoneNumber
	 * @effects <pre>
	 * 	if phoneNumber is valid
	 * 		set this.phoneNumber=phoneNumber
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	@DOpt(type=OptType.Mutator)
	@AttrRef("phoneNumber")
	public boolean setPhoneNumber(String phoneNumber) {
		if (validatePhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
			return true;
		}	else {
			return false;
		}
	}
	
	/**
	 * @modifies this.address
	 * @effects <pre>
	 * 	if address is valid
	 * 		set this.address=address
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	@DOpt(type=OptType.Mutator)
	@AttrRef("address")
	public boolean setAddress(String address) {
		if (validateAddress(address)) {
			this.address = address;
			return true;
		}	else {
			return false;
		}
	}
	
	// observers
	/**
	 * @effects return <tt>id</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("id")
	public double getId() {
		return this.id;
	}
	
	/**
	 * @effects return <tt>name</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return this.name;
	}
	
	/**
	 * @effects return <tt>phoneNumber</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * @effects return <tt>address</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return this.address;
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
	 * 	if name is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateName(String name) {
		return (name != null &&
				name.length() > 0 &&
				name.length() <= LENGTH_NAME);
	}
	
	/**
	 * @effects <pre>
	 * 	if phonenNumber is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validatePhoneNumber(String phoneNumber) {
		return (phoneNumber != null &&
				phoneNumber.length() > 0 &&
				phoneNumber.length() <= LENGTH_PHONE_NUMBER);
	}
	
	/**
	 * @effects <pre>
	 * 	if address is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateAddress(String address) {
		return (address != null &&
				address.length() > 0 &&
				address.length() <= LENGTH_ADDRESS);
	}
	
	@Override
	public String toString() {
		return "Student: <" + id + 
				", " + name + 
				", " + phoneNumber + 
				", " + address + 
				">";
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Student))
			return false;
		
		double yourId = ((Student) o).id;
		return yourId == id;
	}
	
	/**
	 * @effects <pre>
	 * 	if this satisfies abstract properties
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	public boolean repOK() {
		return validateId(id) &&
				validateName(name) &&
				validatePhoneNumber(phoneNumber) &&
				validateAddress(address);
	}

	@Override
	public int compareTo(Student o) {
		if (this.name.compareTo(o.name) != 0) {
			return this.name.compareTo(o.name);
		} else {
			// knows that 2 ids cannot be equal
			return Double.compare(this.id, o.id);
		}
	}
}

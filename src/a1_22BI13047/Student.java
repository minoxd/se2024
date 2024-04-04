package a1_22BI13047;

import utils.AttrRef;
import utils.DomainConstraint;
import utils.NotPossibleException;

/**
 * @overview Student represents student
 * @attributes
 * 	id			Integer		int
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
public class Student {
	// attributes TODO
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
	 * @effects <pre>
	 * 	if id, name, phoneNUmber, address are valid
	 * 		initialise this as <id, name, phoneNumber, address>
	 * 	else
	 * 		initialise this as <> and inform error</pre>
	 */
	public Student(@AttrRef("id") int id,
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
			throw new NotPossibleException("Student.init: Invalid student phone number: ");
		}
		
		if (!validateAddress(address)) {
			throw new NotPossibleException("Student.init: Invalid student address: " + address);
		}
		
		// initialise this as <id, name, phoneNumber, address>
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	private boolean validateId(int id) {
		return false;
	}
	private boolean validateName(String name) {
		return false;
	}
	private boolean validatePhoneNumber(String phoneNumber) {
		return false;
	}
	private boolean validateAddress(String address) {
		return false;
	}
}

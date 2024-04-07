package a1_22BI13047;

import utils.AttrRef;
import utils.NotPossibleException;

/**
 * @overview UndergradStudent represents student who is not graduated
 * @attributes
 * 	id			Integer		double
 * 	name		String
 * 	phoneNumber	String
 * 	address		String
 * @object a typical UndergradStudent object is s=<i, n, pN, a> where id(i), name(n), phoneNumber(pN), address(a)
 * @abstract_properties
 * 	mutable(id)=false /\ optional(id)=false /\ min(id)=10e5 /\ max(id)=10^8 /\ 
 * 	mutable(name)=true /\ optional(name)=false /\ length(name)=50 /\ 
 * 	mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)=10 /\ 
 * 	mutable(address)=true /\ optional(address)=false /\ length(address)=100 /\ 
 * @author minoxd 
 * 	https://github.com/minoxd/se2024
 */
public class UndergradStudent extends Student {
	// constants
	private static final double MIN_ID = 10e5;
	private static final double MAX_ID = 10e8;
	
	// constructors
	/**
	 * @modifies this.id, this.name, this.phoneNumber, this.address
	 * @effects <pre>
	 * 	if id, name, phoneNumber, address are valid
	 * 		initialize this as <id, name, phoneNumber, address>
	 * 	else
	 * 		initialize this as <> and inform error</pre>
	 */
	public UndergradStudent(
			@AttrRef("id") double id, 
			@AttrRef("name") String name, 
			@AttrRef("phoneNumber") String phoneNumber, 
			@AttrRef("address") String address) 
					throws NotPossibleException {
		
		super(id, name, phoneNumber, address);
		
		if (!validateId(id)) {
			throw new NotPossibleException("Student.init: Invalid student id: " + id);
		}
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

	@Override
	public String toString() {
		String tmp = super.toString();
		return "Undergrad" + tmp;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof UndergradStudent)) {
			return false;
		}
		
		double yourId = ((Student) o).getId();
		return yourId == this.getId();
	}
}

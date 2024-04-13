package a1_22BI13047;

import utils.AttrRef;
import utils.DomainConstraint;
import utils.NotPossibleException;

/**
 * @overview UndergradStudent represents student who is not graduated
 * @attributes
 * 	id			Integer		int
 * 	name		String
 * 	phoneNumber	String
 * 	address		String
 * @object a typical UndergradStudent object is us=<i, n, pN, a> where id(i), name(n), phoneNumber(pN), address(a)
 * @abstract_properties
 * 	P_Student.id /\ min(id)=1e5 /\ max(id)=1e8 /\ 
 * 	P_Student.name /\ 
 * 	P_Student.phoneNumber /\ 
 * 	P_Student.address /\ 
 * @author minoxd 
 * 	https://github.com/minoxd/se2024
 */
public class UndergradStudent extends Student {
	// constants
	private static final int MIN_ID = (int) 1e5;
	private static final int MAX_ID = (int) 1e8;
	
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
			@AttrRef("id") int id, 
			@AttrRef("name") String name, 
			@AttrRef("phoneNumber") String phoneNumber, 
			@AttrRef("address") String address) 
					throws NotPossibleException {
		
		super(id, name, phoneNumber, address);
		
		if (!validateId(id)) {
			throw new NotPossibleException("UndergradStudent.init: Invalid student id: " + id);
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
	@Override
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	protected boolean validateId(int id) {
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
		
		int yourId = ((Student) o).getId();
		return yourId == this.getId();
	}
}

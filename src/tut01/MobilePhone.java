package tut01;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview MobilePhone represents mobile phone
 * @attributes
 * 	manName		String
 * 	model		String
 * 	color		Character	char
 * 	year		Integer		int
 * 	guaranteed	boolean 
 * @object a typical MobilePhone object is mb=<mN, m, c, y> where manName(mN), model(m), color(c), year(y)
 * @abstract_properties
 * 	mutable(manName)=false /\ optional(manName)=false /\ length(manName)=10 /\ 
 * 	mutable(model)=false /\ optional(model)=false /\ length(model)=20 /\ 
 * 	mutable(color)=false /\ optional(color)=false /\ 
 * 	mutable(year)=false /\ optional(year)=false /\ min(year)=1973 /\ max(year)=2024 /\ 
 * 	mutable(guaranteed)=true /\ optional(guaranteed)=true /\  
 */
public class MobilePhone {
	//attributes
	@DomainConstraint(type = "String", mutable = false, optional = false, length = LENGTH_MAN_NAME)
	private String manName;
	
	@DomainConstraint(type = "String", mutable = false, optional = false, length = LENGTH_MODEL)
	private String model;
	
	@DomainConstraint(type = "Character", mutable = false, optional = false)
	private char color;
	
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_YEAR, max = MAX_YEAR)
	private int year;
	
	@DomainConstraint(type = "Boolean", mutable = true, optional = true)
	private boolean guaranteed = false;

	// constants
	private static final int LENGTH_MAN_NAME = 10;
	private static final int LENGTH_MODEL = 20;
	private static final int MIN_YEAR = 1973;
	private static final int MAX_YEAR = 2024;
	
	// constructor methods
	/**
	 * @effects <pre>
	 * 	if manName, model, color, year are valid
	 * 		initialise this as <manName, model, color, year>
	 * 	else
	 * 		initialise this as <> and inform error</pre>
	 */
	public MobilePhone(@AttrRef("manName") String manName,
			@AttrRef("model") String model,
			@AttrRef("color") char color,
			@AttrRef("year") int year)
			throws NotPossibleException {
		if (!validateManName(manName)) {
			throw new NotPossibleException("MobilePhone.init: Invalid mobile phone manufacturer name: " + manName);
		}
		
		if (!validateModel(model)) {
			throw new NotPossibleException("MobilePhone.init: Invalid mobile phone model: " + model);
		}
		
		if (!validateColor(color)) {
			throw new NotPossibleException("MobilePhone.init: Invalid mobile phone color: " + color);
		}
		
		if (!validateYear(year)) {
			throw new NotPossibleException("MobilePhone.init: Invalid mobile phone year: " + year);
		}
		
		// initialise this as <manName, model, color, year>
		this.manName = manName;
		this.model = model;
		this.color = color;
		this.year = year;
	}
	
	/**
	 * @effects <pre>
	 * 	if guaranteed is valid
	 * 		set this.guaranteed=guaranteed
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	@DOpt(type=OptType.Mutator)
	@AttrRef("guaranteed")
	public boolean setGuaranteed(boolean guaranteed) {
		if (validateGuaranteed(guaranteed)) {
			this.guaranteed = guaranteed;
			return true;
		}	else {
			return false;
		}
	}
	
	/**
	 * @effects return <tt>manName</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("manName")
	public String getManName() {
		return manName;
	}
	
	/**
	 * @effects return <tt>model</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("model")
	public String getModel() {
		return model;
	}
	
	/**
	 * @effects return <tt>color</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("color")
	public char getColor() {
		return color;
	}
	
	/**
	 * @effects return <tt>year</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("year")
	public int getYear() {
		return year;
	}
	
	/**
	 * @effects return <tt>guaranteed</tt>
	 */
	@DOpt(type=OptType.Observer)
	@AttrRef("guaranteed")
	public boolean getGuaranteed() {
		return guaranteed;
	}
	
	/**
	 * @effects <pre>
	 * 	if manName is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateManName(String manName) {
		return (manName != null &&
				manName.length() > 0 &&
				manName.length() <= LENGTH_MAN_NAME);
	}
	
	/**
	 * @effects <pre>
	 * 	if model is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateModel(String model) {
		return (model != null &&
				model.length() > 0 &&
				model.length() <= LENGTH_MODEL);
	}
	
	/**
	 * @effects <pre>
	 * 	if color is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateColor(char color) {
		return (color == 'R' ||
				color == 'O' ||
				color == 'Y' ||
				color == 'B' ||
				color == 'P');
	}
	
	/**
	 * @effects <pre>
	 * 	if year is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateYear(int year) {
		return (year >= MIN_YEAR &&
				year <= MAX_YEAR);
	}
	
	/**
	 * @effects <pre>
	 * 	if guaranteed is valid
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	private boolean validateGuaranteed(boolean guaranteed) {
		return (guaranteed == true ||
				guaranteed == false);
	}
	
	@Override
	public String toString() {
		return "MobilePhone:<" + manName + 
				", " + model + 
				", " + color + 
				", " + year + 
				", " + guaranteed + 
				">";
	}
	
	/**
	 * Java's specification (omitted)
	 * 
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * The equals method implements an equivalence relation on non-null object references:
	 * <ul>
	 *   <li>It is reflexive: for any non-null reference value x, x.equals(x) should return true.
	 *   <li>It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
	 *   <li>It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
	 *   <li>It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
	 * </ul>
	 * 
	 * For any non-null reference value x, x.equals(null) should return false.
	 * The equals method for class Object implements the most discriminating possible equivalence relation on objects; 
	 *  that is, for any non-null reference values x and y, 
	 *  this method returns true if and only if x and y refer to the same object 
	 *    (x == y has the value true).
	 * 
	 * Note that it is generally necessary to override the hashCode method whenever this method is overridden, 
	 * so as to maintain the general contract for the hashCode method, 
	 * which states that equal objects must have equal hash codes.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MobilePhone)) 
			return false;

		String yourManName = ((MobilePhone) o).manName;
		String yourModel = ((MobilePhone) o).model;
		char yourColor = ((MobilePhone) o).color;
		int yourYear = ((MobilePhone) o).year;
		boolean yourGuaranteed = ((MobilePhone) o).guaranteed;
		return yourManName == manName &&
				yourModel == model &&
				yourColor == color &&
				yourYear == year &&
				yourGuaranteed == guaranteed;
	}
	
	/**
	 * @effects <pre>
	 * 	if this satisfies abstract properties
	 * 		return true
	 * 	else
	 * 		return false</pre>
	 */
	public boolean repOK() {
		return validateManName(manName) &&
				validateModel(model) &&
				validateColor(color) &&
				validateYear(year);
	}
}

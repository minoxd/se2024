package tut01;

import utils.DomainConstraint;

/**
 * @overview Person represents someone who join into the seminar
 * @attributes
 * 	id		Integer		int
 * 	name	String
 * 	phone	MobilePhone
 * @object a typical Person object is p=<i, n>, where id(i), name(n)
 * @abstract_properties
 * 	mutable(id)=false /\ optional(id)=false /\ min(id)=1 /\
 * 	mutable(name)=true /\ optional(name)=false /\ length(name)=50 /\
 * 	mutable(phone)=true /\ optional(phone)=true /\ 
 */
public class Person {
	// attributes
	@DomainConstraint(mutable = false, optional = false, min = 1)
	private int id;
	
	@DomainConstraint(mutable = true, optional = false, length = 50)
	private String name;
	
	@DomainConstraint(mutable = true, optional = true)
	private MobilePhone phone;
}

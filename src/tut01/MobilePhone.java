package tut01;

import utils.DomainConstraint;

/**
 * @overview MobilePhone represents mobile phone
 * @attributes
 * 	manName		String
 * 	model		String
 * 	color		Character	char
 * 	year		Integer		int
 * 	guaranteed	Boolean 
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
	@DomainConstraint(mutable = false, optional = false, length = 10)
	private String manName;
	
	@DomainConstraint(mutable = false, optional = false, length = 20)
	private String model;
	
	@DomainConstraint(mutable = false, optional = false)
	private char color;
	
	@DomainConstraint(mutable = false, optional = false, min = 1973, max = 2024)
	private int year;
	
	@DomainConstraint(mutable = true, optional = true)
	private Boolean guaranteed;
	
}

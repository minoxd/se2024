package tut02;

/**
 * @overview Counter is a counter
 * @attributes
 * 	
 * @object
 * @abstract_properties
 */
public class Counter {
	protected int value;
	
	public Counter() {
		this.value = 0;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void incr() {
		this.value++;
	}
}

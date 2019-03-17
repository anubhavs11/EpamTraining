package com.epam.interest.calculator;

/**
 * This class have methods to calculate simple and compound interests.
 * @author anubhav
 *
 */
public class Interest {
	
	/**
	 * calculates simple interest and returns value in double data-type 
	 * @param principle
	 * @param rate
	 * @param time
	 * @return
	 */
	public double simpleInterest(double principle,double rate,double time) {
		return (principle*rate*time)/100;
	}
	
	/**
	 * calculates compound interest and returns value in double data-type
	 * @param principle
	 * @param rate
	 * @param time
	 * @return
	 */
	public double compoundInterest(double principle,double rate,double time) {
		return principle*(Math.pow(1+(rate/100), time));
	}
}

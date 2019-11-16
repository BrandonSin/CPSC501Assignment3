package Reflection1Serializable;

import java.lang.reflect.Method;


import java.beans.XMLEncoder;
import java.io.*;

public class SimpleObjs implements Serializable {
	private static final long serialVersionUID = 2L;
	int number;
	double decimal;
	
	public SimpleObjs(double decimal, int number){
		this.number = number;
		this.decimal = decimal;

	}
	public SimpleObjs() {
		
	}
	public int getInt() {
		return number;
	}
	
	public double getDouble() {
		return decimal;
	}
	
	public void setDouble(double decimal) {
		this.decimal = decimal;
	}
	
	public void setInt(int number) {
		this.number = number;
	}
	
	
	
}
package Reflection1Serializable;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.beans.XMLEncoder;
import java.io.*;

public class SimpleObjs implements Serializable, SetAndGet {
	private static final long serialVersionUID = 2L;
	int number;
	double decimal;
	
	public SimpleObjs(double decimal, int number){
		this.number = number;
		this.decimal = decimal;

	}
	public SimpleObjs() {
		
	}
	@Override
	public int getInt() {
		return number;
	}
	
	@Override
	public double getDouble() {
		return decimal;
	}
	
	@Override
	public void setDouble(double decimal) {
		this.decimal = decimal;
	}
	
	@Override
	public void setInt(int number) {
		this.number = number;
	}
	
	public void testMethod() {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			number = sc.nextInt();
		}
		if(sc.hasNextDouble()) {
			decimal = sc.nextDouble();
		}
		sc.close();
	}
	
	
	
}
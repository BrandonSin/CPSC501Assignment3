package Reflection1Serializable;

import static org.junit.Assert.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class Test {
	
	SimpleObjs sim = new SimpleObjs();
	
	@org.junit.Test
	public void testSimple() { //Success
		String input = "6.0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		sim.testMethod();
		
		assertEquals(6.0, sim.decimal, 0.1);
		
	}
	@org.junit.Test
	public void testSimple1() { //Success
		String input = "6";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		sim.testMethod();
		
		assertEquals(6, sim.number, 1);
		
	}
	
	@org.junit.Test
	public void testSimple3() { //Failure
		String input = "6.0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		sim.testMethod();
		
		assertEquals(6, sim.number, 1);
		
	}
	@org.junit.Test
	public void testSimple4() { //Failure
		String input = "6";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		sim.testMethod();
		
		assertEquals(6.0, sim.decimal, 0.1);
		
	}


}

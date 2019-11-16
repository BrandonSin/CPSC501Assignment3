package Reflection1Serializable;

import java.io.Serializable;


public class ObjectArrayPrim implements Serializable{
	static final long serialVersionUID=1L;
	
	int[] arr;
	
	public void arrayPrim(int[] arraySize) {
		this.arr = arraySize;

	}

	public ObjectArrayPrim() {
		
	}
	
	public void display() {
	    for (int i = 0; i < this.arr.length; i++) {
	        System.out.print(this.arr[i] + " ");
	    }
	    System.out.println();
	}

	
	
	
	

}

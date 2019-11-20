//Brandon Sin 30012020, CPSC 501 Assignment 501
//References
//https://www.javaworld.com/article/2076132/easy-java-xml-integration-with-jdom--part-2.html
//https://www.tutorialspoint.com/java_xml/java_jdom_parse_document.htm
package Reflection1Serializable;


import java.util.*;
import java.beans.XMLEncoder;
import java.io.*;

public class Driver {
	static double db;
	static int in;
	static IdentityHashMap ihm = new IdentityHashMap();
	static Serializer ser = new Serializer();
	

	public static void main(String args[]) throws IOException {
		System.out.println("choose an option:\n\n1)Simple Object\n2)Object contains Reference to another Object\n3)Object contains an Array of Prims\n"
				+ "4)Object contains array of obj refs\n5)Object use Java Collection");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		try {
			switch(choice) {
			
			//Object Primitives
			case 1:
				
				try {
					System.out.println("Change Field:\n\n1)double\n2)int");
					
						String choice1 = sc.next();
						
					switch(choice1) {
							
						case "1":
							System.out.println("Type the Value of a new double");
							db = sc.nextDouble();
							ihm.put(1, db);
							break;
						
						case "2":
							System.out.println("Type the Value of a new Int");
							in = sc.nextInt();
							ihm.put(2, in);
							break;
						
						
			
					}
					
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				SetAndGet obj = new SimpleObjs(db,in);
				
				
				ser.serialize(obj);
				break;
			
			//Object Reference to Object
			case 2:
				ReferenceObject refObj = new ReferenceObject();
				ReferenceObject refObj2 = refObj;
				
				refObj.color = "blue";
				refObj.texture = "rough";
				Scanner objTraits = new Scanner(System.in);
				System.out.println("Type in a color for object");
				refObj2.color = objTraits.next();
				System.out.println("Type in a texture for object");
				refObj2.texture = objTraits.next();
				
				ser.serialize(refObj);
				
				break;
			//Object Array of Primitives
			case 3:
				ObjectArrayPrim objArray = new ObjectArrayPrim();
				Scanner intArray = new Scanner(System.in);
				System.out.println("Enter number of elements");
				int size = intArray.nextInt();
				int arraySize[] = new int[size];
				System.out.println("Enter Int elements into Array");
				for(int i = 0; i<size; i++) {
					arraySize[i] = intArray.nextInt();
				}
				
				objArray.arrayPrim(arraySize);
				
				ser.serialize(objArray);
				break;
				
			//Object Array Reference
			case 4:
		
				ObjectArrayReference objArrayRefSize[] = new ObjectArrayReference[3];
				System.out.println("Printing object references\n");
				for(int i = 0; i<objArrayRefSize.length; i++) {
					objArrayRefSize[i] = new ObjectArrayReference();
					
				}
				ObjectReferenceList objList = new ObjectReferenceList(objArrayRefSize);
				ser.serialize(objList);
			
				break;
				
				
				
			//Object uses an Instance of Java's Collection 
			case 5:
				ObjectReferenceCollection objColl = new ObjectReferenceCollection();
				System.out.println("Type in String for String Object1");
				Scanner str = new Scanner(System.in);
				String inputString = str.next();
				objColl.sb.add(new StringBuilder(inputString));
				System.out.println("Type in String for String Object2");
				inputString = str.next();
				objColl.sb.add(new StringBuilder(inputString));
				
				
				ser.serialize(objColl);
				break;
			
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

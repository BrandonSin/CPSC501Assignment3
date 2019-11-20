//https://www.tutorialspoint.com/java_xml/java_jdom_parse_document.htm
//Visualizer

import java.beans.XMLDecoder;
import java.io.*;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Deserializer {
	
	private static String SERIALIZED_FILE = "files.xml";
	public Object obj;
	
	public void deserialize(org.jdom.Document doc) throws ClassNotFoundException {

	  try {
		  System.out.println("\nVisualization_____________");
		  System.out.println("Root Element: " + doc.getRootElement().getName());
		  System.out.println("--------------------------------------------");
		  Element classElement = doc.getRootElement();
		  List<Element> list = classElement.getChildren();
		  
		  for(int i = 0; i < list.size(); i++){
			  Element ele = list.get(i);
			  System.out.println("\tCurrent Element: " + ele.getName());
			  Attribute attribute = ele.getAttribute("Object");
			  System.out.println("\tName: " + attribute.getValue());
			  
			  List<Element> list2 = ele.getChildren();
			  for(int j = 0; j < list2.size(); j++){
			  Element childElement = list2.get(j);
			  System.out.println("\t\tChild Element: " + childElement.getName());
			  Attribute childAttribute = childElement.getAttribute("Name");
			  System.out.println("\t\tField Name: " + childAttribute.getValue());
			  childAttribute = childElement.getAttribute("DeclaringClass");
			  System.out.println("\t\tDeclaring Class Name: " + childAttribute.getValue());
			  try {
				  childAttribute = childElement.getAttribute("Length");
				  System.out.println("\t\tLength: " + childAttribute.getValue());
				  
			  }
			  catch(Exception e) {
				  
			  }
			  
			  List<Element> list3 = childElement.getChildren();
			  for(int k = 0; k < list3.size(); k++){
				  Element innerElement = list3.get(k);
				  System.out.println("\t\t\tChild Element: " + innerElement.getName());
				  System.out.println("\t\t\tValue: " + innerElement.getText());
			  }
			
			  }
			  
			
		  }
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
		
	}
}
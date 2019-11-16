package Reflection1Serializable;

import java.beans.XMLEncoder;
import java.io.*;


import java.util.*;
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.Element;

import java.lang.reflect.*;


public class Serializer {
	
	private static final String SERIALIZED_FILE_NAME = "file.xml";
	Document doc;

	
		
	
	public Document serialize(Object obj) throws IOException, IllegalArgumentException, IllegalAccessException{
		

		doc = new Document();
		Element serial = new Element("Serialized");
		doc.setRootElement(serial);
		Class c = obj.getClass();
		Element eleClass = new Element("Class");
		eleClass.setAttribute("Object", c.getName());
		
		//Field array
		//If field is type array then length is needed otherwise not
		serial.addContent(eleClass);
		Field[] fields = c.getDeclaredFields();
		for(Field field : fields ) {
			if(!field.getType().isArray()) {
				field.setAccessible(true);
				Element firstElement = new Element("Field");
				firstElement.setAttribute("Name", field.getName()).setAttribute("DeclaringClass", field.getDeclaringClass().getName());
				firstElement.addContent(new Element("Value").setText(field.get(obj).toString()));
				eleClass.addContent(firstElement);
			}
			else if (field.getType().isArray()) {
				field.setAccessible(true);

				Object array = field.get(obj);
				int length = Array.getLength(array);
				Element anotherElement = new Element("Field");
				anotherElement.setAttribute("Name", field.getName()).setAttribute("DeclaringClass", 
						field.getDeclaringClass().getName()).setAttribute("Length", String.valueOf(length));

				for(int i = 0; i < length; i++) {
					Object element = Array.get(array, i);
					anotherElement.addContent(new Element("Value").setText(element.toString()));
				}
				eleClass.addContent(anotherElement);
				
				
				
			}
			
		
		}
		
		
		XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
		Client serv = new Client();
		//Was not able to get Server running
	//	serv.send(doc, xmlout);
		Deserializer Deserial = new Deserializer();
		try {
			Deserial.deserialize(doc);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xmlout.output(doc, new FileOutputStream("files.xml"));
		return doc;
		
		
	}


}

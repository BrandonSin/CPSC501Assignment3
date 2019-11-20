package Reflection1Serializable;

import java.beans.XMLEncoder;
import java.io.*;


import java.util.*;
import org.jdom.*;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.lang.reflect.*;


public class Serializer {
	
	Document doc;	
	
	public Document serialize(final Object obj) throws IOException, IllegalArgumentException, IllegalAccessException{
		

		doc = new Document();
		final Element serial = new Element("Serialized");
		doc.setRootElement(serial);
		final Class c = obj.getClass();
		final Element eleClass = new Element("Class");
		eleClass.setAttribute("Object", c.getName());
		
		//Field array
		//If field is type array then length is needed otherwise not
		serial.addContent(eleClass);
		final Field[] fields = c.getDeclaredFields();
		for(final Field field : fields ) {
			if(!field.getType().isArray()) {
				field.setAccessible(true);
				final Element firstElement = new Element("Field");
				firstElement.setAttribute("Name", field.getName()).setAttribute("DeclaringClass", field.getDeclaringClass().getName());
				firstElement.addContent(new Element("Value").setText(field.get(obj).toString()));
				eleClass.addContent(firstElement);
			}
			else if (field.getType().isArray()) {
				field.setAccessible(true);

				final Object array = field.get(obj);
				final int length = Array.getLength(array);
				final Element anotherElement = new Element("Field");
				anotherElement.setAttribute("Name", field.getName()).setAttribute("DeclaringClass", 
						field.getDeclaringClass().getName()).setAttribute("Length", String.valueOf(length));

				for(int i = 0; i < length; i++) {
					final Object element = Array.get(array, i);
					anotherElement.addContent(new Element("Value").setText(element.toString()));
				}
				eleClass.addContent(anotherElement);
				
				
				
			}
			
		
		}
		
		
		final XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
		final Client serv = new Client();
		String z = xmlout.outputString(doc);
		serv.send(doc, z);
		return doc;
		
		
	}


}

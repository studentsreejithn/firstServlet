package util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;

public class XmlConverter {

	
	public static Object xmltoobject(String xmlString,Class refClass) {
	
		Object object = null;

		JAXBContext context = null;
		
		try {
			context = JAXBContext.newInstance(refClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			object = unmarshaller.unmarshal(new StringReader(xmlString));
		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return object;
	}
	
	public static String objecttoxml(Object object,Class refClass) throws IOException {
		 
		String returnString = null;
		JAXBContext contextObj = null;  
	    Marshaller marshallerObj;
	    ByteArrayOutputStream bi = null;
	    
		try {
			
			bi = new ByteArrayOutputStream();
			
			contextObj = JAXBContext.newInstance(refClass); 
			marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
			marshallerObj.marshal(object, bi);
			returnString = bi.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		return returnString;
	}
}

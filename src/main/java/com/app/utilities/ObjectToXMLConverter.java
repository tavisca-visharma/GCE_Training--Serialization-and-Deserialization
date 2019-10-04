package com.app.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ObjectToXMLConverter {

	public String toXML(Object object) {
		XmlMapper xmlMapper = new XmlMapper();
		String xmlString = null;
		try {
			xmlString = xmlMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return xmlString;
	}

}

package com.javarush.task.task33.task3309;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.StringWriter;

import java.util.ArrayList;


/* 
Комментарий внутри xml
*/

public class Solution {
	public static String toXmlWithComment(Object obj, String tagName, String comment)
		throws TransformerException, ParserConfigurationException, JAXBException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(obj, document);

		document.normalizeDocument();

		NodeList nodeList = document.getElementsByTagName(tagName);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeName().equals(tagName)) {
				currentNode.getParentNode().insertBefore(document.createComment(comment), currentNode);
				currentNode.getParentNode().insertBefore(document.createTextNode("\n"), currentNode);
			}
		}

		DOMSource source = new DOMSource(document);
		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
		transformer.transform(source, result);

		return sw.toString();
	}

	public static void main(String[] args) throws JAXBException, TransformerException, ParserConfigurationException {
		Box box = new Box();
		Box box2 = new Box(1, 1, 1, 1);
		Box box3 = new Box(2, 2, 2, 2);

		String xmlBox = toXmlWithComment(box, "toy", "its a comment");
		System.out.print(xmlBox);
	}

	@XmlRootElement(name = "box")
	public static class Box {
		public int width, height, deep, weight;
		@XmlElementWrapper(name = "toys")
		@XmlElement(name = "toy")
		public ArrayList<String> listToys = new ArrayList<>();

		public Box() {
			this.width = 0;
			this.height = 0;
			this.deep = 0;
			this.weight = 0;
			listToys.add("Teddy");
			listToys.add("Billy");
			listToys.add("Masha");
		}

		public Box(int width, int height, int deep, int weight) {
			this.width = width;
			this.height = height;
			this.deep = deep;
			this.weight = weight;
		}

	}
}

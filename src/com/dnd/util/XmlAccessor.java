/**
 * Copyright 2016 Dillon Lynch
 */
package com.dnd.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlAccessor {

	private Document doc;

	public XmlAccessor() throws SAXException, IOException, ParserConfigurationException {
		URL url = new URL("http://randompotion.bugs3.com/table.xml");
		InputStream xml = url.openStream();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xml);

	}

	public String getPotionAdjective(String name, int index) {
		if (name == "title") {
			NodeList titles = doc.getElementsByTagName("title");
			String title = titles.item(index).getTextContent();
			return title;
		}
		if (name == "effect") {
			NodeList effects = doc.getElementsByTagName("effect");
			String effect = effects.item(index).getTextContent();
			return effect;
		}
		if (name == "potentcy") {
			NodeList potencies = doc.getElementsByTagName("potentcy");
			String potentcy = potencies.item(index).getTextContent();
			return potentcy;
		}
		if (name == "side-effect") {
			NodeList sideEffects = doc.getElementsByTagName("side-effect");
			String sEffect = sideEffects.item(index).getTextContent();
			return sEffect;
		}
		if (name == "container") {
			NodeList containers = doc.getElementsByTagName("container");
			String container = containers.item(index).getTextContent();
			return container;
		}
		if (name == "appearance") {
			NodeList appearances = doc.getElementsByTagName("appearance");
			String appearance = appearances.item(index).getTextContent();
			return appearance;
		}
		if (name == "with") {
			NodeList appearsWiths = doc.getElementsByTagName("with");
			String with = appearsWiths.item(index).getTextContent();
			return with;
		}
		if (name == "texture") {
			NodeList textures = doc.getElementsByTagName("texture");
			String texture = textures.item(index).getTextContent();
			return texture;
		}
		if (name == "smell-taste") {
			NodeList smellsTastes = doc.getElementsByTagName("smell-taste");
			String smellTaste = smellsTastes.item(index).getTextContent();
			return smellTaste;
		}
		else if (name == "label") {
			NodeList labels = doc.getElementsByTagName("label");
			String label = labels.item(index).getTextContent();
			return label;
		}
		return "Error";

	}

	protected Node getNode(String tagName, NodeList nodes) {
		for (int x = 0; x < nodes.getLength(); x++) {
			Node node = nodes.item(x);
			if (node.getNodeName().equalsIgnoreCase(tagName)) {
				return node;
			}
		}

		return null;
	}

	protected String getNodeValue(Node node) {
		NodeList childNodes = node.getChildNodes();
		for (int x = 0; x < childNodes.getLength(); x++) {
			Node data = childNodes.item(x);
			if (data.getNodeType() == Node.TEXT_NODE)
				return data.getNodeValue();
		}
		return "";
	}

	protected String getNodeValue(String tagName, NodeList nodes) {
		for (int x = 0; x < nodes.getLength(); x++) {
			Node node = nodes.item(x);
			if (node.getNodeName().equalsIgnoreCase(tagName)) {
				NodeList childNodes = node.getChildNodes();
				for (int y = 0; y < childNodes.getLength(); y++) {
					Node data = childNodes.item(y);
					if (data.getNodeType() == Node.TEXT_NODE)
						return data.getNodeValue();
				}
			}
		}
		return "";
	}

}

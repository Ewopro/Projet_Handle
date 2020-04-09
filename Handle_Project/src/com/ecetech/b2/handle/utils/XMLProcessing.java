package com.ecetech.b2.handle.utils;

import com.ecetech.b2.handle.beans.Session;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLProcessing {
	
	//code permettant d'ecire dans un fichier xml deja existant (non fonctionel pour le moment)

	public static void createNodeInExistingXMLFile(String nameXmlFile, Session newS)
	
			throws ParserConfigurationException, TransformerException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("file_sessions.xml");
		Element root = document.getDocumentElement();

		ArrayList<Session> sess = new ArrayList<Session>();
		sess.add(new Session());

		for (Session i : sess) {
			Element sessions = document.createElement("session");
			root.appendChild(sessions);
			Element session = document.createElement("session");
			session.appendChild(document.createTextNode(i.getUserName()));
			session.appendChild(document.createTextNode(i.getUserPsw()));
			session.appendChild(document.createTextNode(i.getUserEmail()));
			DOMSource source = new DOMSource(document);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult result = new StreamResult("file_sessions.xml");
			transformer.transform(source, result);
		}
	}

	//code permettant de créer un fichier XML et d'ecrire à l'intérieur
	
	public static void createNodeAndNewXMLFile(String nameXmlFile, Session newS)
			throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element root = doc.createElementNS("sessions_handle.com", "users");
		doc.appendChild(root);
		root.appendChild(createSession(doc, newS));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();

		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		DOMSource source = new DOMSource(doc);

		File myFile = new File(nameXmlFile);

		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);

		transf.transform(source, console);
		transf.transform(source, file);
	}
	
	// creation de la session
	
	private static Node createSession(Document doc, Session s) {

		Element user = doc.createElement("session");
		user.appendChild(createSessionElement(doc, "name", s.getUserName()));
		user.appendChild(createSessionElement(doc, "psw", s.getUserPsw()));
		user.appendChild(createSessionElement(doc, "email", s.getUserEmail()));
		return user;
	}

	private static Node createSessionElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}
	
	// code permettant la verification de l'identité d'un utilisateur (identifiant et mot de passe)
	
	public static boolean verifUserInXmlFile(String user, String psw) {

		boolean result_verif = false;
		try {

			File file = new File("file_sessions.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			if (doc.hasChildNodes()) {
				result_verif = verfiXMLNodes(user, psw, doc.getChildNodes());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result_verif;
	}

	/**
	 * 
	 * @param user
	 * @param psw
	 * @param childNodes
	 * @return
	 * @throws Exception
	 */
	private static boolean verfiXMLNodes(String user, String psw, NodeList childNodes) throws Exception {
		File fXmlFile = new File("file_sessions.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		// optional, but recommended
		// read this -
		// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("session");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Email : " + eElement.getAttribute("email"));
				System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Psw : " + eElement.getElementsByTagName("psw").item(0).getTextContent());

				if (eElement.getElementsByTagName("name").item(0).getTextContent().equals(user)
						&& eElement.getElementsByTagName("psw").item(0).getTextContent().equals(psw)) {
					return true;
				}
			}
		}
		return false;
	}

}

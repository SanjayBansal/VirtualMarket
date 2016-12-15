package Parser;

import java.io.File;
import java.net.URL;
import java.util.List;


import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Parser {
	final static Logger logger = Logger.getLogger(Parser.class);
	List<Node>nodes = null;

	@SuppressWarnings("unchecked")
	public List<Node> parsePropertyFile(String propFile) {
		try {
			File inputFile = new File(propFile);
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputFile);
			logger.info("reading file....");
			nodes = document.content();
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			logger.error("unable to parse property file");
		}
		return nodes;

	}

	@SuppressWarnings("unchecked")
	public List<Node> parseURL(URL httpsURL) {
		try{
		SAXReader reader = new SAXReader();
		Document document = reader.read(httpsURL);
		nodes = document.content();
		}catch(DocumentException exc){
			exc.getMessage();
		}
		return nodes;
	}
}

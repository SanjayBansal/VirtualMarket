package playground;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import Entity.Property;
import Entity.Stock;
import Parser.Parser;
import historicalData.DataPersistor;
import persistence.HibernateConfiguration;

public class demo {
	final static Logger logger = Logger.getLogger(demo.class);
	
	
	
	public static Parser parser = new Parser();
	public static Property prop= null;
	public static DataPersistor dataPersistor = null;
	
	public static void main(String[] args)  {
		init();
		start();
	}
		
	private static void start() {
		dataPersistor = new DataPersistor(prop);
		dataPersistor.start();
	}

	private static void init() {
		try{
		 prop = new Property();
		List<Node> nodes = parser.parsePropertyFile("resources/properties.xml");
			prop.setQuandlKey(nodes.get(0).selectSingleNode("quandlKey").getStringValue());
			prop.setQuandlURL(nodes.get(0).selectSingleNode("quandlURL").getStringValue());
			List<Node> portfolioList = nodes.get(0).selectNodes("./portfolios/portfolio-name");
			prop.setPortfolio(portfolioList);
			logger.info(prop.toString());	
	}catch(Exception exc){
		exc.printStackTrace();
		logger.error("error while parsing property file : " +exc.getMessage() );
	}
}
}

// try {
//
//
// }

// Client client = Client.create();
//
// WebResource webResource = client
// .resource(httpsURL);
//
// ClientResponse response = webResource.accept("application/xml")
// .get(ClientResponse.class);
//
// if (response.getStatus() != 200) {
// throw new RuntimeException("Failed : HTTP error code : "
// + response.getStatus());
// }
//
// String output = response.getEntity(String.class);
//
// System.out.println("Output from Server .... for SBI\n");
// System.out.println(output);
//
//
//
//
//
//
// } catch (Exception e) {
//
// e.printStackTrace();
//
// }

// }
// }
//
// }

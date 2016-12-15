package playground;

import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Node;

import Entity.Property;
import Parser.Parser;
import historicalData.DataPersistor;
import realTimeData.RealTimeDataProcessor;

public class demo {
	final static Logger logger = Logger.getLogger(demo.class);

	public static Parser parser = new Parser();
	public static Property prop = null;
	public static DataPersistor dataPersistor = null;
	public static RealTimeDataProcessor realTimeProc = null;
	private static boolean isHistoricalEnabale = false;
	private static boolean isRealTimeEnabale = false;

	public static void main(String[] args) {
		init();
		start();
	}

	private static void start() {
		if (isHistoricalEnabale) {
			dataPersistor = new DataPersistor(prop);
			dataPersistor.start();
		}

		if (isRealTimeEnabale) {
			realTimeProc = new RealTimeDataProcessor(prop);
			realTimeProc.start();
		}
	}

	private static void init() {
		try {
			prop = new Property();
			List<Node> nodes = parser.parsePropertyFile("resources/properties.xml");
			if (nodes.get(0).selectSingleNode("./historicalData").valueOf("@enabale").equalsIgnoreCase("true")) {
				isHistoricalEnabale = true;
				prop.setQuandlKey(nodes.get(0).selectSingleNode("historicalData/quandlKey").getStringValue());
				prop.setQuandlURL(nodes.get(0).selectSingleNode("historicalData/quandlURL").getStringValue());
				List<Node> portfolioList = nodes.get(0).selectNodes("./historicalData/portfolios/portfolio-name");
				prop.setPortfolio(portfolioList);
			} else {
				logger.info("historical data is not enabled");
			}
			// realTime
			if (nodes.get(0).selectSingleNode("./realTimeData").valueOf("@enabale").equalsIgnoreCase("true")) {
				isRealTimeEnabale = true;
				prop.setGoogleURL(nodes.get(0).selectSingleNode("realTimeData/googleURL").getStringValue());
				List<Node> realTimePortfolio = nodes.get(0).selectNodes("./realTimeData/portfolios/portfolio-name");
				prop.setRealTimeportfolio(realTimePortfolio);
			} else {
				logger.info("real time data is not enabled");
			}
			prop.setProperty(prop);
			logger.info(prop.toString());
		} catch (Exception exc) {
			exc.printStackTrace();
			logger.error("error while parsing property file : " + exc.getMessage());
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

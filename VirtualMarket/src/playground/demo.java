package playground;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Node;

import Entity.Stock;
import Parser.Parser;
import persistence.HibernateConfiguration;

public class demo {

	public static void main(String[] args) throws IOException, DocumentException {
		String httpsURL = "https://www.quandl.com/api/v3/datasets/NSE/SBIN.xml?start_date="+"2016-06-01"+"&end_date="+"2016-12-06";
		URL url = new URL(httpsURL);
		Parser parser = new Parser();
		List<Node> nodes = parser.parsePropertyFile("resources/properties.xml");
		for (Node node : nodes) {
			System.out.println("Node name" + node.getName());
			System.out.println("\nname of stock :" + node.valueOf("@name"));
			System.out.println("Exchange name : " + node.valueOf("@exchange"));
			List<Node> columns = node.selectNodes("./column-names/column-name");
			for (Node column : columns) {
				System.out.println(column.getStringValue());
			}
		}
		List<Node> quandlResponse = parser.parseURL(url);
		HibernateConfiguration config = new HibernateConfiguration();
		config.initHibernate();
		config.getSession().beginTransaction();
		for (Node node : quandlResponse) {
			Node data = node.selectSingleNode("./dataset/data");
			List<Node> stockDatumList=data.selectNodes("./datum");
			for(Node stockDatum:stockDatumList){
				// for each datum node
				List<Node> datumDetailItems=stockDatum.selectNodes("./datum");
				Stock stock=new Stock(quandlResponse.get(0).selectSingleNode("./dataset/name").getStringValue(),
						datumDetailItems.get(0).getStringValue(),
						datumDetailItems.get(1).getStringValue(),
						datumDetailItems.get(2).getStringValue(),
						datumDetailItems.get(3).getStringValue(),
						datumDetailItems.get(4).getStringValue(),
						datumDetailItems.get(5).getStringValue(),
						datumDetailItems.get(6).getStringValue(),
						datumDetailItems.get(7).getStringValue());
					
				config.getSession().save(stock);
				
					
			}
			config.getSession().getTransaction().commit();
			config.getFactory().close();
			
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

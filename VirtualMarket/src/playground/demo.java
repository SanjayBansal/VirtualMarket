package playground;

import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Node;



import Parser.Parser;

public class demo {

	public static void main(String[] args) throws IOException, DocumentException {
		String httpsURL = "https://www.quandl.com/api/v3/datasets/NSE/SBIN.xml?start_date=2016-11-28";
		Parser parser = new Parser();
		List<Node> nodes = parser.parsePropertyFile("resources/properties.xml");
		for (Node node : nodes) {
			System.out.println(node.getName());
			System.out.println("\nname of stock :" + node.valueOf("@name"));
			System.out.println("Exchange name : " + node.valueOf("@exchange"));
			List<Node> columns=node.selectNodes("./column-names/column-name");
			for(Node column:columns){
				System.out.println(column.getStringValue());
			}
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
//}
//
//}

package playground;

import java.io.IOException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class demo {

	public static void main(String[] args) throws IOException {
		String httpsURL = "https://www.quandl.com/api/v3/datasets/NSE/SBIN.xml?start_date=2016-11-28";
	    
	    try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource(httpsURL);

			ClientResponse response = webResource.accept("application/xml")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
			
			
			
			
			

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		}
	}
	  



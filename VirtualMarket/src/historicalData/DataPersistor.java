package historicalData;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Node;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import Entity.Property;
import Parser.Parser;
import persistence.DatabaseHandler;

public class DataPersistor {
	final static Logger logger = Logger.getLogger(DataPersistor.class);

	private Property prop = null;
	private List<String> URLS = null;
	private Date startTime = null;
	private DatabaseHandler handler =null;

	public DataPersistor(Property prop) {
		this.prop = prop; 
	}

	public void start() {
		logger.info("Starting data persisting");
		URLS = getUrlList(prop);
		logger.info("total portfolio : " + URLS.size());
		for (String url : URLS) {
			storeData(url);
		}

	}

	private void storeData(String url) {
		try {
			Parser parser = new Parser();
			URL httpUrl = new URL(url);
			List<Node> quandlResponse = parser.parseURL(httpUrl);
			handler = new DatabaseHandler(prop.getPortfolio(), quandlResponse);
			//if store not exits
			if ((handler.initDataBase())) {
				handler.fillStore();
			} else {
				fillRemainingRecordsInStores();
			}

		} catch (Exception exc) {
			logger.error("Error while fetching data from url " + exc.toString());
		}

	}

	private void fillRemainingRecordsInStores() {
		// TODO Auto-generated method stub
		System.out.println("fill the remaing records");

	}

	private List<String> getUrlList(Property prop) {
		List<String> urls = new ArrayList<String>();
		String end_date = null;

		for (int i = 0; i < prop.getPortfolio().size(); i++) {
			if (prop.getPortfolio().get(i).selectSingleNode("end-date").getStringValue().equalsIgnoreCase("today")) {
				end_date = getYesterdayDate();
			} else {
				end_date = prop.getPortfolio().get(i).selectSingleNode("end-date").getStringValue();
			}
			String url = prop.getQuandlURL() + prop.getPortfolio().get(i).valueOf("@name") + ".xml" + "?start_date="
					+ prop.getPortfolio().get(i).selectSingleNode("start-date").getStringValue() + "&end_date="
					+ end_date;
			urls.add(url);
		}

		return urls;

	}

	private String getYesterdayDate() {
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTime now = new DateTime();
		return format.print(now.minusDays(1));
	}
}

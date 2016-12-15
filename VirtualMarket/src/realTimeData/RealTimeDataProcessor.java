package realTimeData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import Entity.Property;
import historicalData.DataPersistor;

public class RealTimeDataProcessor {

	final static Logger logger = Logger.getLogger(RealTimeDataProcessor.class);

	private Property prop = null;
	private List<String> URLS = null;

	public RealTimeDataProcessor(Property prop) {
		this.prop = prop;
	}

	public void start() {
		logger.info("Starting real time data persisting");
		URLS = getUrlList(prop);
		logger.info("total portfolio : " + URLS.size());
		parseAndSaveInMemory(URLS);
	}

	private void parseAndSaveInMemory(List<String> uRLS) {
		Executor executor = new Executor(uRLS);
		executor.executorTask();
	}

	private List<String> getUrlList(Property prop) {
		List<String> urls = new ArrayList<String>();

		for (int i = 0; i < prop.getRealTimeportfolio().size(); i++) {
			String url = prop.getGoogleURL() + prop.getRealTimeportfolio().get(i).valueOf("@name");
			urls.add(url);
		}

		return urls;
	}

}

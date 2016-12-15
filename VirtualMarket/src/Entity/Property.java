package Entity;

import java.util.List;

import org.dom4j.Node;

public class Property {
	private String quandlKey;
	private String quandlURL;
	private List<Node> portfolio;
	private static Property prop = null;

	// real time data property
	private List<Node> realTimeportfolio;

	public List<Node> getRealTimeportfolio() {
		return realTimeportfolio;
	}

	public void setRealTimeportfolio(List<Node> realTimeportfolio) {
		this.realTimeportfolio = realTimeportfolio;
	}
	public  void setProperty(Property prop) {
		this.prop = prop;
	}
	private String googleURL;
	private String refreshInterval;
	private String eod;

	public String getQuandlKey() {
		return quandlKey;
	}

	public void setQuandlKey(String quandlKey) {
		this.quandlKey = quandlKey;
	}

	public String getQuandlURL() {
		return quandlURL;
	}

	public void setQuandlURL(String quandlURL) {
		this.quandlURL = quandlURL;
	}

	public List<Node> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(List<Node> portfolio) {
		this.portfolio = portfolio;
	}

	public String getGoogleURL() {
		return googleURL;
	}

	public void setGoogleURL(String googleURL) {
		this.googleURL = googleURL;
	}

	public String getRefreshInterval() {
		return refreshInterval;
	}

	public void setRefreshInterval(String refreshInterval) {
		this.refreshInterval = refreshInterval;
	}

	public String getEod() {
		return eod;
	}

	public void setEod(String eod) {
		this.eod = eod;
	}

	@Override
	public String toString() {
		return "Property [quandlKey=" + quandlKey + ", quandlURL=" + quandlURL + ", portfolio=" + portfolio
				+ ", realTimeportfolio=" + realTimeportfolio + ", googleURL=" + googleURL + ", refreshInterval="
				+ refreshInterval + ", eod=" + eod + "]";
	}

}

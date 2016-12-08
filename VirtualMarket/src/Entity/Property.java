package Entity;

import java.util.List;

import org.dom4j.Node;

public class Property {
	private String quandlKey;
	private String quandlURL;
	private List<Node> portfolio;
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
	
	@Override
	public String toString() {
		return "Property [quandlKey=" + quandlKey + ", quandlURL=" + quandlURL + ", portfolio=" + portfolio
				 + "]";
	}	
}

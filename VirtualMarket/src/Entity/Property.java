package Entity;

import java.util.List;

public class Property {
	private String quandlKey;
	private String quandlURL;
	private List<String> portfolio;
	private String startDate;
	private String endDate;
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
	public List<String> getPortfolio() {
		return portfolio;
	}
	
	public void setPortfolio(List<String> portfolio) {
		this.portfolio = portfolio;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Property [quandlKey=" + quandlKey + ", quandlURL=" + quandlURL + ", portfolio=" + portfolio
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}	
}

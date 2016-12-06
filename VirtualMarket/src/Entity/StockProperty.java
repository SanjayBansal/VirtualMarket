package Entity;

public class StockProperty {
	private String quandlKey;
	private String quandlURL;
	private String noOfDays;
	public StockProperty(String quandlKey, String quandlURL, String noOfDays) {
		super();
		this.quandlKey = quandlKey;
		this.quandlURL = quandlURL;
		this.noOfDays = noOfDays;
	}
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
	public String getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
}

package Entity;
import java.math.BigDecimal;

public class Stock {
	private String name;
	private double high;
	private double low;
	private double close;
	private BigDecimal volumn;
	private double open;
	
	public Stock(String name, double high, double low, double close,
			BigDecimal volumn, double open) {
		this.name = name;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volumn = volumn;
		this.open = open;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public BigDecimal getVolumn() {
		return volumn;
	}

	public void setVolumn(BigDecimal volumn) {
		this.volumn = volumn;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}
	
}

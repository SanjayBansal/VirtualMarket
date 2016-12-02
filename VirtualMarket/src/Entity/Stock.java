package Entity;
import java.math.BigDecimal;
import java.util.Date;

public class Stock {
	private String name;
	private double high;
	private double low;
	private double close;
	private BigDecimal volumn;
	private BigDecimal totalTradedQty;
	private double open;
	private Date date;
	private double last;
	
	


	public Stock(String name, double high, double low, double close, BigDecimal volumn, BigDecimal totalTradedQty,
			double open, Date date, double last) {
		this.name = name;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volumn = volumn;
		this.totalTradedQty = totalTradedQty;
		this.open = open;
		this.date = date;
		this.last = last;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getTotalTradedQty() {
		return totalTradedQty;
	}

	public void setTotalTradedQty(BigDecimal totalTradedQty) {
		this.totalTradedQty = totalTradedQty;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getLast() {
		return last;
	}

	public void setLast(double last) {
		this.last = last;
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

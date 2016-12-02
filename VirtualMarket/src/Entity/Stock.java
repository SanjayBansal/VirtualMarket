package Entity;

import javax.persistence.Entity;

@Entity
public class Stock {
	
	private String name;
	private String date;
	private String open;
	private String high;
	private String low;
	private String last;
	private String close;
	private String totalTradedQty;
	private String volumn;
	
	
	


	public Stock(String name, String date, String open, String high, String low, String last, String close,
			String totalTradedQty, String volumn) {
		super();
		this.name = name;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.last = last;
		this.close = close;
		this.totalTradedQty = totalTradedQty;
		this.volumn = volumn;
	}

	public String getName() {
		return name;
	}

	public String getTotalTradedQty() {
		return totalTradedQty;
	}

	public void setTotalTradedQty(String totalTradedQty) {
		this.totalTradedQty = totalTradedQty;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", high=" + high + ", low=" + low + ", close=" + close + ", volumn=" + volumn
				+ ", totalTradedQty=" + totalTradedQty + ", open=" + open + ", String=" + date + ", last=" + last + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolumn() {
		return volumn;
	}

	public void setVolumn(String volumn) {
		this.volumn = volumn;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
	
}

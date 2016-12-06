package Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sbi")
public class Stock {
	
	@Column(name = "name")
	private String name;
	
	@Id
	@Column(name = "date")
	private String date;
	
	
	@Column(name = "open")
	private String open;
	
	@Column(name = "high")
	private String high;
	
	@Column(name = "low")
	private String low;
	
	@Column(name = "last")
	private String last;
	
	@Column(name = "close")
	private String close;
	
	@Column(name = "totalTradedQty")
	private String totalTradedQty;
	
	@Column(name = "volumn")
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
				+ ", totalTradedQty=" + totalTradedQty + ", open=" + open + ", date=" + date + ", last=" + last + "]";
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

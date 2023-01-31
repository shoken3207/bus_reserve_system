package model;

import java.io.Serializable;
import java.sql.Date;

public class InsertBusBean implements Serializable {
	private int maxPassenger, price;
	private String start, end;
	private Date departure;
	
	public InsertBusBean() { }
	
	public InsertBusBean(String start, String end, Date departure, int maxPassenger, int price) {
		this.setStart(start);
		this.setEnd(end);
		this.setDeparture(departure);
		this.setMaxPassenger(maxPassenger);
		this.setPrice(price);
	}

	public int getMaxPassenger() {
		return maxPassenger;
	}

	public void setMaxPassenger(int maxPassenger) {
		this.maxPassenger = maxPassenger;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

}

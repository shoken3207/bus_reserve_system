package model;

import java.io.Serializable;

public class InsertReserveBean implements Serializable{
	private int userId, busId, seats;
	
	public InsertReserveBean() { }

	public InsertReserveBean(int userId, int busId, int seats) {
		this.setUserId(userId);
		this.setBusId(busId);
		this.setSeats(seats);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}

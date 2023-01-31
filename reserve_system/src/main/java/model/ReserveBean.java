package model;

import java.io.Serializable;

public class ReserveBean implements Serializable{
	private int reserveId, userId, busId, seats;
	
	public ReserveBean() { }

	public ReserveBean(int reserveId, int userId, int busId, int seats) {
		this.setReserveId(reserveId);
		this.setUserId(userId);
		this.setBusId(busId);
		this.setSeats(seats);
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
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

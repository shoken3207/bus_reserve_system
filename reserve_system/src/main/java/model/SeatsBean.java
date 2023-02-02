package model;

import java.io.Serializable;

public class SeatsBean implements Serializable {
	private int userId, busId;
	private String seatId;

	public SeatsBean() { }

	public SeatsBean(int userId, int busId, String seatId) {
		this.setUserId(userId);
		this.setBusId(busId);
		this.setSeatId(seatId);
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

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

}

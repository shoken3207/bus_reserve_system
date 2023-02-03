package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SeatsBean;

public class SeatsDao extends CommonDao {
	public SeatsDao() {
		this.seatsDao = this;
	}

	public ArrayList<SeatsBean> findAll() {
		ArrayList<SeatsBean> seats = new ArrayList<SeatsBean>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM seats";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("userId");
				int busId = rs.getInt("busId");
				String seatId = rs.getString("seatId");

				SeatsBean seat = new SeatsBean(userId, busId, seatId);
				seats.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return seats;
	}

	public SeatsBean findReserve(int userId, int busId, String seatId) {
		List<SeatsBean> seats = this.findAll();
		
		for (SeatsBean seat: seats) {
			if (seat.getUserId() == userId && seat.getBusId() == busId && seat.getSeatId().equals(seatId)) return seat;
		}
		
		return null;
	}

	public String[] getReservedSeats(int busId) {
		List<String> reservedSeats = new ArrayList<>();
		List<SeatsBean> seats = this.findAll();
		for (SeatsBean seat: seats) {
			if (seat.getBusId() == busId) {
				reservedSeats.add(seat.getSeatId());
			}
		}
		return reservedSeats.toArray(new String[reservedSeats.size()]);
	}

	public boolean isExistsReserve(int userId, int busId, String seatId) {
		return this.findReserve(userId, busId, seatId) != null;
	}

	public void insert(ArrayList<SeatsBean> seats) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			for (SeatsBean seat: seats) {
				String sql = "INSERT INTO seats VALUES(?, ?, ?);";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, seat.getUserId());
				ps.setInt(2, seat.getBusId());
				ps.setString(3, seat.getSeatId());

				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BusBean;

public class SeatsDao extends CommonDao {
//	public SeatsDao() {
//		this.seatsDao = this;
//	}

	public ArrayList<SeatsDao> findAll() {
		ArrayList<SeatsDao> buses = new ArrayList<SeatsDao>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM timetable";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int busId = rs.getInt("busId");
				String start = rs.getString("start");
				String end = rs.getString("end");
				Date departure = rs.getDate("departure");
				int maxPassenger = rs.getInt("maxPassenger");
				int price = rs.getInt("price");

//				BusBean bus = new BusBean(busId, start, end, departure, maxPassenger, price);
//				buses.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return buses;
	}
	
	public BusBean findBusByBusId(int busId) {
		List<SeatsDao> buses = this.findAll();
		
//		for (SeatsBean bus: buses) {
//			if (bus.getBusId() == busId) return bus;
//		}
		
		return null;
	}
	
	public boolean isExistsBus(int busId) {
		return this.findBusByBusId(busId) != null;
	}

	public void insert(SeatsDao[] buses) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			for (SeatsDao bus: buses) {
				String sql = "INSERT INTO timetable(start, end, departure, maxPassenger, price) VALUES(?, ?, ?, ?, ?);";
				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setString(1, bus.getStart());
//				ps.setString(2, bus.getEnd());
//				ps.setDate(3, bus.getDeparture());
//				ps.setInt(4, bus.getMaxPassenger());
//				ps.setInt(5, bus.getPrice());

				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

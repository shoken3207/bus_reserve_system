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
import model.InsertBusBean;

public class BusDao extends CommonDao {
	public BusDao() {
		this.busDao = this;
	}

	public ArrayList<BusBean> findAll() {
		ArrayList<BusBean> buses = new ArrayList<BusBean>();

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

				BusBean bus = new BusBean(busId, start, end, departure, maxPassenger, price);
				buses.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return buses;
	}
	
	public BusBean findTimetable(int busId) {
		List<BusBean> buses = this.findAll();
		
		for (BusBean bus: buses) {
			if (bus.getBusId() == busId) return bus;
		}
		
		return null;
	}
	
	public boolean isExistsBus(int busId) {
		return this.findTimetable(busId) != null;
	}

	public void insert(InsertBusBean[] buses) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			for (InsertBusBean bus: buses) {
				String sql = "INSERT INTO timetable(start, end, departure, maxPassenger, price) VALUES(?, ?, ?, ?, ?);";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, bus.getStart());
				ps.setString(2, bus.getEnd());
				ps.setDate(3, bus.getDeparture());
				ps.setInt(4, bus.getMaxPassenger());
				ps.setInt(5, bus.getPrice());

				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

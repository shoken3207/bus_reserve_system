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

public class BusDao extends CommonDao {
	public BusDao() {
		this.busDao = this;
	}

	public List<BusBean> findAll() {
		List<BusBean> buses = new ArrayList<BusBean>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM user";
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
}

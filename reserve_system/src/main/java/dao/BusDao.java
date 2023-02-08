package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.BusBean;

public class BusDao extends CommonDao {
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
	
	public BusBean findBusByBusId(int busId) {
		List<BusBean> buses = this.findAll();
		
		for (BusBean bus: buses) {
			if (bus.getBusId() == busId) return bus;
		}
		
		return null;
	}

	public BusBean findBusByBusId(int busId, List<BusBean> buses) {
		for (BusBean bus: buses) {
			if (bus.getBusId() == busId) return bus;
		}

		return null;
	}

	public HashMap<Integer, BusBean> getBusBeans(int[] busIds) {
		HashMap<Integer, BusBean> map = new HashMap<>();
		List<BusBean> buses = this.findAll();

		for (int busId: busIds) {
			BusBean bus = this.findBusByBusId(busId, buses);
			map.put(busId, bus);
		}

		return map;
	}
	
	public boolean isExistsBus(int busId) {
		return this.findBusByBusId(busId) != null;
	}

	public void insert(BusBean bus) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO timetable(start, end, departure, maxPassenger, price) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bus.getStart());
			ps.setString(2, bus.getEnd());
			ps.setDate(3, bus.getDeparture());
			ps.setInt(4, bus.getMaxPassenger());
			ps.setInt(5, bus.getPrice());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(BusBean[] buses) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			for (BusBean bus: buses) {
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

	@Override
	public void delete(int id) {
		if (!this.isExistsBus(id)) return;

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "DETELE FROM bus WHERE busId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

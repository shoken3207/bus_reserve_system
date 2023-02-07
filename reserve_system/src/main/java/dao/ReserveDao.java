package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReserveBean;

public class ReserveDao extends CommonDao {
	public List<ReserveBean> findAll() {
		List<ReserveBean> reserves = new ArrayList<ReserveBean>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM reserve";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int reserveId = rs.getInt("reserveId");
				int userId = rs.getInt("userId");
				int busId = rs.getInt("busId");
				int seats = rs.getInt("seats");

				ReserveBean reserve = new ReserveBean(reserveId, userId, busId, seats);
				reserves.add(reserve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reserves;
	}

	public ReserveBean findReserve(int id) {
		List<ReserveBean> reserves = this.findAll();

		for (ReserveBean reserve: reserves) {
			if (reserve.getReserveId() == id) return reserve;
		}

		return null;
	}

	public boolean isExistsReserve(int id) {
		return this.findReserve(id) != null;
	}

	public void insert(ReserveBean reserve) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO reserve(userId, busId, seats) VALUES(?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reserve.getUserId());
			ps.setInt(2, reserve.getBusId());
			ps.setInt(3, reserve.getSeats());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ReserveBean> findAllReserveByUserId(int userId) {
		List<ReserveBean> userReserveList = new ArrayList<ReserveBean>();

		List<ReserveBean> reserves = this.findAll();
		for (ReserveBean reserve: reserves) {
			if (reserve.getUserId() == userId) userReserveList.add(reserve);
		}

		return userReserveList;
	}

	@Override
	public void delete(int id) {
		if (!this.isExistsReserve(id)) return;

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "DETELE FROM reserve WHERE reserveId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

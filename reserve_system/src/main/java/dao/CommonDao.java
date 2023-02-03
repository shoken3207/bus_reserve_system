package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import consts.Definition;

public class CommonDao {
	protected final String URL  = Definition.URL;
	protected final String USER = Definition.USER;
	protected final String PASS = Definition.PASS;
	
	protected UserDao userDao;
	protected BusDao  busDao;
	protected SeatsDao seatsDao;
	protected ReserveDao reserveDao;

	public void delete(int id, String table) {
		if (table == "user") {
			if (!userDao.isExistsUser(id)) return;
		} else if (table == "bus") {
			if (!busDao.isExistsBus(id)) return;
		} else if (table == "reserve") {
			if (!reserveDao.isExistsReserve(id)) return;
		}

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String idName = table == "timetable" ? "busId" : table + "Id";
	
			String sql = "DETELE FROM ? WHERE ? = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, table);
			ps.setString(2, idName);
			ps.setInt(3, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

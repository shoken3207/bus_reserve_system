package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReserveBean;

public class ReserveDao {
//	private final String URL = "fukushima-pc";
//	private final String USER = "teamF";
//	private final String PASS = "figMySQL";
	
	private final String URL = "localhost:54321";
	private final String USER = "root";
	private final String PASS = "passsword";

	public List<ReserveBean> findAll() {
		List<ReserveBean> reserves = new ArrayList<ReserveBean>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM sample";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				System.out.println("id: " + id + ", name: " + name + "\n");
				ReserveBean reserve = new ReserveBean();
				reserves.add(reserve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reserves;
	}
}

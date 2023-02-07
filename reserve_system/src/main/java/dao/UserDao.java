package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserBean;

public class UserDao extends CommonDao {
	public UserDao() {
		this.userDao = this;
	}

	public List<UserBean> findAll() {
		List<UserBean> users = new ArrayList<UserBean>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM user";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("userId");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String name = rs.getString("name");
				int phone = rs.getInt("phone");

				UserBean user = new UserBean(userId, password, email, name, phone);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public void insert(UserBean user) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO user(password, email, name, phone) VALUES(?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getName());
			ps.setInt(4, user.getPhone());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserBean findUser(int userId) {
		List<UserBean> users = this.findAll();
		
		for (UserBean user: users) {
			if (user.getUserId() == userId) return user;
		}

		return null;
	}
	
	public boolean isExistsUser(int userId) {
		return this.findUser(userId) != null;
	}

	public UserBean getUserByUserId(int userId) {
		List<UserBean> users = this.findAll();

		for (UserBean user: users) {
			if (user.getUserId() == userId) return user;
		}

		return null;
	}

	public UserBean getUserByEmail(String email) {
		List<UserBean> users = this.findAll();

		for (UserBean user: users) {
			if (user.getEmail().equals(email)) return user;
		}

		return null;
	}
}

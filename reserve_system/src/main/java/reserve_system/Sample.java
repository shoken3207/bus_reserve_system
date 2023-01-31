package reserve_system;

import dao.UserDao;

public class Sample {

	public static void main(String[] args) {
//		UserDao dao = new UserDao();
//		UserBean user = dao.findUser(1);
//		System.out.println(user.getPassword());
		UserDao dao = new UserDao();
		dao.delete(3, "user");
	}

}

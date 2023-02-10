package reserve_system;

import dao.BusDao;
import model.BusBean;

public class Sample {

	public static void main(String[] args) {
//		UserDao dao = new UserDao();
//		UserBean user = dao.findUser(1);
//		System.out.println(user.getPassword());
//		UserDao dao = new UserDao();
//		dao.delete(3, "user");
		BusDao busDao = new BusDao();
		for (BusBean bus: busDao.findAll()) {
			System.out.println(bus.getMaxPassenger());
		}
	}

}

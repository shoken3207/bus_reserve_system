package reserve_system;

import dao.ReserveDao;

public class Sample {

	public static void main(String[] args) {
		ReserveDao dao = new ReserveDao();
		dao.findAll();
	}

}

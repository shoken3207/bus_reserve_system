package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusDao;
import dao.ReserveDao;
import model.BusBean;
import model.ReserveBean;
import model.UserBean;
import util.Utils;

/**
 * Servlet implementation class ReserveListServlet
 */
@WebServlet("/ReserveListServlet")
public class ReserveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");

		ReserveDao reserveDao = new ReserveDao();
		Utils utils = new Utils();
		BusDao busDao = new BusDao();

		List<ReserveBean> reserves = reserveDao.findAllReserveByUserId(user.getUserId());
		Integer[] busIdInt = reserves.stream().map(r -> r.getBusId()).distinct().toArray(Integer[]::new);
		int[] busIds = utils.parseIntegerToIntArray(busIdInt);
		HashMap<Integer, BusBean> map = busDao.getBusBeans(busIds);

		request.setAttribute("reserves", reserves);
		request.setAttribute("map", map);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserveList.jsp");
		dispatcher.forward(request, response);
	}

}

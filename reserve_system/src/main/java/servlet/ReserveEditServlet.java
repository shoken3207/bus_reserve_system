package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusDao;
import dao.ReserveDao;
import dao.UserDao;
import model.BusBean;
import model.ReserveBean;
import model.UserBean;

/**
 * Servlet implementation class ReserveDetailServlet
 */
@WebServlet("/ReserveEditServlet")
public class ReserveEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");

		ReserveDao reserveDao = new ReserveDao();
		BusDao busDao = new BusDao();

		int reserveId = Integer.parseInt(request.getParameter("reserveId"));
		ReserveBean reserve = reserveDao.findReserve(reserveId);

		if (user == null) {
			UserDao userDao = new UserDao();
			user = userDao.getUserByUserId(1);
			session.setAttribute("user", user);
		} else {
			if (user.getUserId() != reserve.getUserId()) {
				/* TODO error */
			}
		}

		BusBean bus = busDao.findBusByBusId(reserve.getBusId());

		request.setAttribute("reserve", reserve);
		request.setAttribute("bus", bus);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserveDetail.jsp");
		dispatcher.forward(request, response);
	}

}

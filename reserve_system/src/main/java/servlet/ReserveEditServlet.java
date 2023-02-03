package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ServletContext application = request.getServletContext();
		UserBean user = (UserBean) application.getAttribute("user");

		ReserveDao reserveDao = new ReserveDao();
		BusDao busDao = new BusDao();

		int reserveId = Integer.parseInt(request.getParameter("reserveId"));
		ReserveBean reserve = reserveDao.findReserve(reserveId);

		if (user == null) {
			UserDao userDao = new UserDao();
			user = userDao.getUserByUserId(1);
			application.setAttribute("user", user);
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

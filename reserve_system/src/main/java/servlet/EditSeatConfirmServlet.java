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
import dao.UserDao;
import model.BusBean;
import model.UserBean;

/**
 * Servlet implementation class EditSeatConfirmServlet
 */
@WebServlet("/EditSeatConfirmServlet")
public class EditSeatConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedSeats = request.getParameter("selectedSeats");
		int passenger = selectedSeats.split(",").length;
		int reserveId = Integer.parseInt(request.getParameter("reserveId"));

		HttpSession session = request.getSession();
		int busId = (int) session.getAttribute("busId");
		
		BusDao busDao = new BusDao();
		BusBean bus = busDao.findBusByBusId(busId);

		session.setAttribute("reserveId", reserveId);
		session.setAttribute("bus", bus);
		session.setAttribute("passenger", passenger);
		session.setAttribute("reserveSeat", selectedSeats);

		UserBean user = (UserBean) session.getAttribute("user");
		if (user == null) {
			UserDao userDao = new UserDao();
			user = userDao.getUserByUserId(1);
			session.setAttribute("user", user);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/editSeatConfirm.jsp");
		dispatcher.forward(request, response);
	}

}

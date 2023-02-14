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
import model.BusBean;

/**
 * Servlet implementation class ReserveSeatConfirmServlet
 */
@WebServlet("/ReserveSeatConfirmServlet")
public class ReserveSeatConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedSeats = request.getParameter("selectedSeats");
		int passenger = selectedSeats.split(",").length;

		HttpSession session = request.getSession();
		int busId = (int) session.getAttribute("busId");
		
		BusDao busDao = new BusDao();
		BusBean bus = busDao.findBusByBusId(busId);
		session.setAttribute("bus", bus);
		session.setAttribute("passenger", passenger);
		session.setAttribute("reserveSeat", selectedSeats);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserveSeatConfirm.jsp");
		dispatcher.forward(request, response);
	}

}

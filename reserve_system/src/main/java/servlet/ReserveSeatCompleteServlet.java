package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReserveDao;
import dao.SeatsDao;
import model.ReserveBean;
import model.SeatsBean;
import model.UserBean;

/**
 * Servlet implementation class ReserveSeatCompleteServlet
 */
@WebServlet("/ReserveSeatCompleteServlet")
public class ReserveSeatCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selectedSeats = request.getParameter("reserveSeat").split(",");
		int busId = Integer.parseInt(request.getParameter("busId"));

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user != null ? user.getUserId(): 1;

		ArrayList<SeatsBean> seatsList = new ArrayList<SeatsBean>();
		for (String seat: selectedSeats) {
			SeatsBean seatBean = new SeatsBean(userId, busId, seat);
			seatsList.add(seatBean);
		}

		ReserveBean insertReserveBean = new ReserveBean(userId, busId, selectedSeats.length);
		ReserveDao reserveDao = new ReserveDao();
		int reserveId = reserveDao.insert(insertReserveBean);

		SeatsDao seatsDao = new SeatsDao();
		seatsDao.insert(seatsList, reserveId);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserveSeatComplete.jsp");
		dispatcher.forward(request, response);
	}

}

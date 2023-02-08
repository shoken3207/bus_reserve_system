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
import model.SeatsBean;
import model.UserBean;

/**
 * Servlet implementation class EditSeatCompleteServlet
 */
@WebServlet("/EditSeatCompleteServlet")
public class EditSeatCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selectedSeats = request.getParameter("reserveSeat").split(",");
		int busId = Integer.parseInt(request.getParameter("busId"));

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user != null ? user.getUserId(): 1;

		SeatsDao seatsDao = new SeatsDao();
		ReserveDao reserveDao = new ReserveDao();

		int reserveId = seatsDao.getReserveId(userId, busId, selectedSeats[0]);
		seatsDao.delete(reserveId);


		ArrayList<SeatsBean> seatsList = new ArrayList<SeatsBean>();
		for (String seat: selectedSeats) {
			SeatsBean seatBean = new SeatsBean(userId, busId, seat);
			seatsList.add(seatBean);
		}

		reserveDao.update(reserveId, selectedSeats.length);
		seatsDao.insert(seatsList, reserveId);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/editSeatComplete.jsp");
		dispatcher.forward(request, response);
	}

}

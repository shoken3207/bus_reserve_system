package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReserveDao;
import dao.SeatsDao;
import model.InsertReserveBean;
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

		ServletContext application = request.getServletContext();
		UserBean user = (UserBean) application.getAttribute("user");
		int userId = user != null ? user.getUserId(): 1;

		InsertReserveBean insertReserveBean = new InsertReserveBean(userId, busId, selectedSeats.length);
		ReserveDao reserveDao = new ReserveDao();
		reserveDao.insert(insertReserveBean);

		ArrayList<SeatsBean> seatsList = new ArrayList<SeatsBean>();
		for (String seat: selectedSeats) {
			SeatsBean seatBean = new SeatsBean(userId, busId, seat);
			seatsList.add(seatBean);
		}
		
		SeatsDao seatsDao = new SeatsDao();
		seatsDao.insert(seatsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserveSeatComplete.jsp");
		dispatcher.forward(request, response);
	}

}

package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusDao;
import dao.SeatsDao;
import model.BusBean;
import model.SeatsBean;
import model.UserBean;

/**
 * Servlet implementation class ReserveSeatServlet
 */
@WebServlet("/ReserveSeatServlet")
public class ReserveSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameterBusId = request.getParameter("busId");
		int busId = parameterBusId != null ? Integer.parseInt(parameterBusId): 1;

		BusDao busDao = new BusDao();
		SeatsDao seatsDao = new SeatsDao();

		BusBean bus = busDao.findBusByBusId(busId);
		String[] reservedSeats = seatsDao.getReservedSeats(busId);

		HttpSession session = request.getSession();
		session.setAttribute("busId", busId);
		session.setAttribute("bus", bus);
		session.setAttribute("reservedSeats", reservedSeats);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserveSeat.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selectedSeats = request.getParameter("selectedSeats").split(",");
		System.out.println(Arrays.toString(selectedSeats));
		HttpSession session = request.getSession();
		int busId = (int) session.getAttribute("busId");
		ServletContext application = request.getServletContext();
		UserBean user = (UserBean) application.getAttribute("userId");
		int userId = user != null ? user.getUserId(): 1;

		ArrayList<SeatsBean> seatsList = new ArrayList<SeatsBean>();
		for (String seat: selectedSeats) {
			SeatsBean seatBean = new SeatsBean(userId, busId, seat);
			seatsList.add(seatBean);
		}
		
		SeatsDao seatsDao = new SeatsDao();
		seatsDao.insert(seatsList);
	}

}

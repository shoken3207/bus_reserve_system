package servlet;

import java.io.IOException;
import java.util.Arrays;

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
		BusBean bus = busDao.findBusByBusId(busId);
		
		HttpSession session = request.getSession();
		session.setAttribute("bus", bus);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserveSeat.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selectedSeats = request.getParameter("selectedSeats").split(",");
		System.out.println(Arrays.toString(selectedSeats));
	}

}

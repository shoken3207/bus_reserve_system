package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReserveDao;
import dao.SeatsDao;
import model.ReserveBean;
import model.UserBean;

/**
 * Servlet implementation class ReserveDeleteServlet
 */
@WebServlet("/ReserveDeleteServlet")
public class ReserveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reserveId = Integer.parseInt(request.getParameter("reserveId"));

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");

		ReserveDao reserveDao = new ReserveDao();
		ReserveBean reserve = reserveDao.findReserve(reserveId);
		if (user.getUserId() == reserve.getUserId()) {
			SeatsDao seatsDao = new SeatsDao();
			seatsDao.delete(reserveId);
			reserveDao.delete(reserveId);
		}

		response.sendRedirect("ReserveListServlet");
	}

}

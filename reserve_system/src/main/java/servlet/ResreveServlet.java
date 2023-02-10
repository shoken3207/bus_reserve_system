package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusDao;
import model.BusBean;

/**
 * Servlet implementation class ResreveServlet
 */
@WebServlet("/ResreveServlet")
public class ResreveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusDao busDao = new BusDao();
		ArrayList<BusBean> buses = busDao.findAll();

		String[] startList = buses.stream().map(e -> e.getStart()).distinct().toArray(String[]::new);
		String[] endList = buses.stream().map(e -> e.getEnd()).distinct().toArray(String[]::new);

		request.setAttribute("busList", buses);
		request.setAttribute("startList", startList);
		request.setAttribute("endList", endList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserve.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

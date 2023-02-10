package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusDao;
import model.BusBean;

/**
 * Servlet implementation class SearchBusServlet
 */
@WebServlet("/SearchBusServlet")
public class SearchBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start = "";
		String end   = "";
		String date  = "";

		BusDao busDao = new BusDao();
		ArrayList<BusBean> buses = busDao.findAll();

		String[] startList = buses.stream().map(e -> e.getStart()).distinct().toArray(String[]::new);
		String[] endList = buses.stream().map(e -> e.getEnd()).distinct().toArray(String[]::new);

		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("date", date);
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
		request.setCharacterEncoding("UTF-8");
		String start = request.getParameter("start");
		String end   = request.getParameter("end");
		String date  = request.getParameter("date");
		System.out.println(start + end + date);

		BusDao busDao = new BusDao();
		ArrayList<BusBean> buses = busDao.findAll();
		List<BusBean> list = busDao.findBus(start, end, date);
		System.out.println("list" + list);

		String[] startList = buses.stream().map(e -> e.getStart()).distinct().toArray(String[]::new);
		String[] endList = buses.stream().map(e -> e.getEnd()).distinct().toArray(String[]::new);

		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("date", date);
		request.setAttribute("busList", list);
		request.setAttribute("endList", endList);
		request.setAttribute("startList", startList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/reserve.jsp");
		dispatcher.forward(request, response);
	}

}

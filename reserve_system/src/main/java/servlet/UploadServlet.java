package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.BusDao;
import model.BusBean;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("result", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/busDataInput.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String data = request.getParameter("data");
		String result;
		try {
			ObjectMapper mapper = new ObjectMapper();
			BusBean[] buses = mapper.readValue(data, BusBean[].class);
			BusDao busDao = new BusDao();
			busDao.insert(buses);
			result = "insert completed!";
		} catch (IOException e) {
//			e.printStackTrace();
			result = "an error occured...";
			session.setAttribute("data", data);
		}

		session.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/busDataInput.jsp");
		dispatcher.forward(request, response);
	}

}

/*
[
  {
    "start": "鹿児島",
    "end": "福岡",
    "departure": "2023-06-21",
    "maxPassenger": 40,
    "price": 2000
  },
  {
    "start": "福岡",
    "end": "大阪",
    "departure": "2023-06-21",
    "maxPassenger": 40,
    "price": 3000
  }
]
*/
package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/daysUntil")
public class DaysUntilServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	@Override protected void doGet(HttpServletRequest req, HttpServletResponse
			 resp) throws ServletException, IOException { LocalDate nyt = LocalDate.now();
				LocalDate joulu = LocalDate.of(2021, 12, 24);
				long paivia = ChronoUnit.DAYS.between(nyt, joulu);
				// välitetään päivien määrä JSP-sivulle attribuuttina
				req.setAttribute("valissaPaivia", paivia);
				// välitetään pyyntö JSP-sivulle
				req.getRequestDispatcher("/WEB-INF/days.jsp").forward(req, resp); }
	*/
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		LocalDate now = LocalDate.now();
		int year = Integer.parseInt(req.getParameter("year"));
	    int month = Integer.parseInt(req.getParameter("month"));
	    int day = Integer.parseInt(req.getParameter("day"));	    
	    LocalDate then = LocalDate.of(year, month, day);
	    long timeBetween = ChronoUnit.DAYS.between(now, then);
	 // välitetään päivien määrä JSP-sivulle attribuuttina
		req.setAttribute("paiviaKunnes", timeBetween);
		req.setAttribute("kohdepaiva", then);
		// välitetään pyyntö JSP-sivulle
		req.getRequestDispatcher("/WEB-INF/daysUntil.jsp").forward(req, resp);
	}
	
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		LocalDate now = LocalDate.now();
		int year = Integer.parseInt(req.getParameter("year"));
	    int month = Integer.parseInt(req.getParameter("month"));
	    int day = Integer.parseInt(req.getParameter("day"));	    
	    LocalDate then = LocalDate.of(year, month, day);
	    long timeBetween = ChronoUnit.DAYS.between(now, then);
	 // välitetään päivien määrä JSP-sivulle attribuuttina
		req.setAttribute("paiviaKunnes", timeBetween);
		req.setAttribute("kohdepaiva", then);
		// välitetään pyyntö JSP-sivulle
		req.getRequestDispatcher("/WEB-INF/daysUntil.jsp").forward(req, resp);
		
	}

}
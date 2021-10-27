package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.BalsalevyDAO;
import database.JDBCBalsalevyDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BalsalevyDAO balsalevyDAO = new JDBCBalsalevyDAO();
		try {
			String submittedPin = req.getParameter("password");
			if (submittedPin.equals(pin)) {
				//Cookie cookie = new Cookie("pin", "givenPin");
				//cookie.setPath("/database");
				//resp.addCookie(cookie);
				req.setAttribute("items", balsalevyDAO.getAll());
				//System.out.println(balsalevyDAO.getAll());
				resp.sendRedirect("/samipuuntiheys/database");
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
		
	}
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// jos kenttään kirjoitettu salasana on oikein, aseta se sessioniin
		if (req.getParameter("salasana").equals("42") || req.getParameter("salasana") == "42") {
			session.setAttribute("salasana", "42");
			// uudelleenohjaus pro-versioon
			resp.sendRedirect("/samipuuntiheys/database");

		} else {
			// jos salasana ei ollut oikein, palaa perusversioon
			resp.sendRedirect("/samipuuntiheys/index");
		}
	}
		
		
}

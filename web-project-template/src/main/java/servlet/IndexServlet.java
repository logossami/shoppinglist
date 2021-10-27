package servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BalsalevyDAO;
import database.JDBCBalsalevyDAO;
import model.Balsalevy;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BalsalevyDAO balsalevy = new JDBCBalsalevyDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String tulos ="";
		// String amerikanTulos = "";
		// DecimalFormat des = new DecimalFormat("0.00");
		try {
			/*
			Double paksuus = Double.parseDouble(req.getParameter("paksuus")) / 1000;
			Double pituus = Double.parseDouble(req.getParameter("pituus")) / 1000;
			Double leveys = Double.parseDouble(req.getParameter("leveys")) / 1000;
			Double paino = Double.parseDouble(req.getParameter("paino")) / 1000;
			//System.out.println(paino /(paksuus * pituus * leveys));
			
			amerikanTulos = des.format(paino * 2.20462262185 / ((paksuus * 3.2808399) * (pituus * 3.2808399) * (leveys * 3.2808399)));
			tulos = des.format(paino /(paksuus * pituus * leveys));
			*/

	        // PITÄISI SAADA LUETTUA LASKENTAAN TARVITTAVAT ARVOT
	    	String paksuus = req.getParameter("paksuus");
	    	String pituus = req.getParameter("pituus");
	    	String leveys = req.getParameter("leveys");
	    	String paino = req.getParameter("paino");
	    	// STRING TYYPPISET NUMEROT PITÄISI MUUNTAA DOUBLEKSI, JOTTA VOI LASKEA 
	    	double paksuusDouble = Double.parseDouble(paksuus);
	    	double pituusDouble = Double.parseDouble(pituus);
	    	double leveysDouble = Double.parseDouble(leveys);
	    	double painoDouble = Double.parseDouble(paino);
	    	// TIHEYDEN LASKEMISTOIMITUS - TULOS PITAISI OLLA KG/M3
	    	double tilavuusmm3 = (paksuusDouble * pituusDouble * leveysDouble);
	    	double tulosDouble = (painoDouble/1000.0) / (tilavuusmm3/1000000000.0);
	    	// SITTEN VÄLITETÄÄN TIETO NÄHTÄVÄKSI SELAIMELLE
	    	
	    	System.out.println(tulosDouble);
	    	
			req.setAttribute("tulos", tulosDouble);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		resp.sendRedirect("/index");

	}
	
	@Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

}


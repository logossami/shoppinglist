package servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/laske")
public class IndexServletti extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
    	double tiheys = (painoDouble/1000.0) / (tilavuusmm3/1000000000.0);
    	System.out.println(tiheys);
    	// SEURAAVAKSI KÄYTETÄÄN MEKANISMIA VALITTAA TIETO NAHTAVAKSI SELAIMESSA
    	req.setAttribute("tiheys", tiheys);
        // lähetä request edelleen index.jsp sivulle
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// KÄYTTÄJÄN ANTAMA PIN-KOODI PITÄISI SAADA STRING-MUUTTUJAAN TÄNNE
    	System.out.println("POSTISSA");
    	String pin = req.getParameter("pin");
    	System.out.println(pin);
    	if(pin.equals("42")) {
    		req.getRequestDispatcher("/WEB-INF/pro.jsp").forward(req, resp);
    	} else {
    		req.getRequestDispatcher("/kirjaudu.jsp").forward(req, resp);
    	}
    }
}
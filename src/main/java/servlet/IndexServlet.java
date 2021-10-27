package servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	// Tämä oli valmiina GitHubista ladatussa tiedostossa.

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 resp) throws ServletException, IOException { String timeString =
	 LocalTime.now().toString();
	 
	 // pass the time string to the JSP page as an attribute
	 req.setAttribute("timeNow", timeString);
	 
	 // Luodaan testiksi lista oluista
	 // Huom. stringin sijaan shoppinglistitemeitä!
	 List<String> oluet = new ArrayList<String>();
	 String olut1 = "Karhu";
	 String olut2 = "Sandels";
	 
	 oluet.add(olut1);
	 oluet.add(olut2);
	 // Asetetaan lista requestiin, jolloin sen pystyy purkamaan JSP-sivulla
	 req.setAttribute("oluet", oluet);
	 
	 /* Tag libraryn käyttö:
	 <c:forEach items="$(oluet)"> var="beer">;
	 // Huom. oluet on stringejä, meillä pitää olla olioita
	 */
	 
	 // forward the request to the index.jsp page
	 req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp); }
}



 


/*
DOPOST-metodi on post-pyyntöjä varten doPost
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException, javax.servlet.ServletException {
			// Asetuksia, Kontrolleri-tyyppisessä sovelluksessa ei tarvita
			res.setContentType("text/html");
			java.io.PrintWriter out = res.getWriter();
			// Oletetaan, että URL-rivillä on parametri nimeltään nimi
			// Haetaan nimen arvo
			//String nimi = req.getParameter("nimi");
			
			// System.out.println("TESTI" + nimi);
			
			// Mitä jos nimi olisikin numero, miten se muutetaan numeroksi?
			// int luku2 = Integer.parseInt("nimi");
			
			// Tulostetaan HTML-sisältö
			out.println("<head><title><title>Kone on kaapattu</head></title>");
			out.println("</head></body>");
			out.println("<h1>Koneesi on kaapattu Kuubaan!</h1>");
			out.println("<h2>Maksa miljoona bitcoinia nyt.</h1>");
			out.println("</body></html>");
			// lopetetaan sisällön tulostaminen
			out.close();
	}
*/	
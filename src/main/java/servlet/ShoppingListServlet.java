package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCShoppingListItemDao;
import model.ShoppingListItem;

@WebServlet("/shoppinglist")
public class ShoppingListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JDBCShoppingListItemDao dao = new JDBCShoppingListItemDao();
		
		List<ShoppingListItem> tuotteet = dao.getAllItems();

		req.setAttribute("listaNakyviin", tuotteet);

		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// todo: get the product title from request parameters
		String itemTitle = req.getParameter("title");
		
		// todo: use the title to create a new product object
		ShoppingListItem lisaaTuote = new ShoppingListItem();
		lisaaTuote.setTuote(itemTitle);
		
		JDBCShoppingListItemDao dao = new JDBCShoppingListItemDao();
		
		// todo: use the DAO to store the product object into the database
		dao.addItem(lisaaTuote);

		resp.sendRedirect("/shoppinglist");
	}


}

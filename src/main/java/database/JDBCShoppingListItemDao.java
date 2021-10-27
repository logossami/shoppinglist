package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ShoppingListItem;

public class JDBCShoppingListItemDao implements ShoppingListItemDao {
	
	public List<ShoppingListItem> getAllItems() {
		
		List<ShoppingListItem> tuotteet = new ArrayList<ShoppingListItem>();
		
		try {
    		Class.forName("org.sqlite.JDBC"); 		
    		String url = "jdbc:sqlite:./shoppinglist.sqlite";
    		Connection connection = DriverManager.getConnection(url);	
    		/*
    		Database db = new Database();
    		Connection connection = db.connect();
    		*/
    		String sql = "SELECT * FROM ShoppingListItem;";	
    		PreparedStatement statement = connection.prepareStatement(sql);
    		ResultSet tulokset = statement.executeQuery();		
    		while(tulokset.next()) {
    			int id = tulokset.getInt("id");
    			String ostoksenNimi = tulokset.getString("title");			
    			ShoppingListItem tuote = new ShoppingListItem(ostoksenNimi);    			
    			tuote.setId(id);    			
    			tuotteet.add(tuote);
    		}
    		statement.close();
    		connection.close();    		
    	} catch(Exception ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Connection to database failed!");
    	}
		return tuotteet;		
	}

    public ShoppingListItem getItem(long id) {	
    	
    	ShoppingListItem tuoteRivi = new ShoppingListItem();
    	
    	try {    		
    		Class.forName("org.sqlite.JDBC");    		
    		String url = "jdbc:sqlite:./shoppinglist.sqlite";
    		Connection connection = DriverManager.getConnection(url);    		
    		String sql = "SELECT * FROM ShoppingListItem";    		
    		PreparedStatement statement = connection.prepareStatement(sql);  		
    		ResultSet tulokset = statement.executeQuery();
    		while (tulokset.next()) {    			
    			if (id == tulokset.getInt("id")) {
    				tuoteRivi.setId(tulokset.getInt("id"));
    				tuoteRivi.setTuote(tulokset.getString("title"));
    			}
    		}
    		tulokset.close();
    		statement.close();
    		connection.close();
    		
    	} catch(Exception ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Connection to database failed!");
    	}
    	return tuoteRivi;
    }

    public boolean addItem(ShoppingListItem newItem) {
    	String tuotenimi = newItem.getTitle();
    	
    	try {    		
    		Class.forName("org.sqlite.JDBC");    		
    		String url = "jdbc:sqlite:./shoppinglist.sqlite";
    		Connection connection = DriverManager.getConnection(url);    		
    		String sql = "INSERT INTO ShoppingListItem(title) VALUES(?); ";    		
    		PreparedStatement statement = connection.prepareStatement(sql);    		
    		statement.setString(1, tuotenimi);    		
    		statement.executeUpdate();
    		System.out.println("\nSuccessfully added " + tuotenimi);
    		statement.close();
    		connection.close();
    		
    	} catch(Exception ex) {
    		return false;
    	}
    	return true;
    }

    public boolean removeItem(ShoppingListItem item) {
    	String tuotenimi = item.getTitle();
    	
    	try {    		
    		Class.forName("org.sqlite.JDBC");    		
    		String url = "jdbc:sqlite:./shoppinglist.sqlite";
    		Connection connection = DriverManager.getConnection(url);    		
    		String sql = "DELETE FROM ShoppingListItem WHERE title=?";    		
    		PreparedStatement statement = connection.prepareStatement(sql);    		
    		statement.setString(1, tuotenimi);    		
    		int tulos = statement.executeUpdate();
    		int deletedId = tulos;
			if (deletedId > 0) {
				System.out.println("\nSuccessfully removed " + tuotenimi);
			}
			else {
				System.out.println("\nCould not remove " + "'" + tuotenimi + "'. Please try again. Use 'help' for available commands.");
			}
    		statement.close();
    		connection.close();
    		
    	} catch(Exception ex) {
    		return false;
    	}
    	return true;
    }

}




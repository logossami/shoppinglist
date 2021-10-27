package servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.JDBCShoppingListItemDao;
import model.ShoppingListItem;

public class ShoppingListProgram {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		JDBCShoppingListItemDao dao = new JDBCShoppingListItemDao();		
		String command = "";
		String parameter = "";		
		System.out.println("Welcome to Sami's little shopping list app!\n");
		System.out.println(
				"Please choose your command: \n list \n search [product ID, e.g. 'search 1'] \n add [product name] \n remove [product name] \n quit \n help");		
		while (true) {			
			System.out.print("\n> ");
			String line = lukija.nextLine();			
			if (line.equals("quit")) {
				System.out.println("\nThank you for using the app. Bye!");
				break;
			}			
			else {				
				if (line.contains(" ")) {
					int firstWhitespace = line.indexOf(" ");
					command = line.substring(0, firstWhitespace);
					parameter = line.substring(firstWhitespace + 1);
				} else {
					command = line;
				}				
				ArrayList<String> komennot = new ArrayList<>();
				komennot.add("add");
				komennot.add("remove");
				komennot.add("list");
				komennot.add("search");
				komennot.add("help");
				if (komennot.contains(command) == false) {
				    System.out.println("Unknown command.\n");					
				}				
				switch (command) {
				case "add":					
					ShoppingListItem tuote = new ShoppingListItem(parameter);
					dao.addItem(tuote);					
					break;
				case "remove":					
					tuote = new ShoppingListItem(parameter);
					dao.removeItem(tuote);
					break;
				case "list":					
					System.out.println("\nShopping list contents: ");
					List<ShoppingListItem> tuotteet = dao.getAllItems();
					for (int i = 0; i < tuotteet.size(); i++) {
						ShoppingListItem haeTuote = tuotteet.get(i);
						System.out.print("(" + haeTuote.getId() + ") " );
						System.out.println(haeTuote.getTitle());
					}
					System.out.println();
					break;
				case "search":
					long numero = Long.parseLong(parameter);
					ShoppingListItem haettava = dao.getItem(numero);
					long tuoteId = haettava.getId();
					String tuoteNimi = haettava.getTitle();
					System.out.println("\nThe item with the requested ID " + tuoteId + " is " + tuoteNimi + ".");
					break;	
				case "help":					
					System.out.println(
							"\nAvailable commands: \n list \n search [product ID, e.g. 'search 1'] \n add [product name] \n remove [product name] \n quit \n help");
					break;
				default:					
					System.out.println(
							"Available commands: \n list \n search [product ID, e.g. 'search 1'] \n add [product name] \n remove [product name] \n quit \n help");
					break;
				}	
			}						
		}
		lukija.close();
	}
}
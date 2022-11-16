import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GuenthersMarket {

	private static Scanner scnr;
	private static Map<String, Double> items = new TreeMap<>(); 
	private static List<String> orderNames = new ArrayList<>();
	private static List<Double> orderPrices = new ArrayList<>();
	static Double avg = 0.0;
	static Double sum = 0.0;
	
	
	public static void main(String[] args) {
		scnr = new Scanner(System.in);	
		
		fillItemsMap();
		 System.out.println("Welcome to Guenther's Market !");
		
		printMenu();
		
		System.out.print("What item would you like to order ? ");
		String itemName = scnr.nextLine();
		
//		if (itemName.equalsIgnoreCase(itemName))
//			
//		}
//		catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("Error !! - Item Name Do not Match !!");
//		
//		}
		
		Double itemPrice = items.get(itemName);
		System.out.println("Adding " + itemName + " to cart at $ " + itemPrice);	
		
		addToArrays(itemName, itemPrice);
	
		boolean promptingToContinue = true;
			
		while (promptingToContinue) {
			System.out.println("");
			System.out.print("Would you like to order anything else (y/n)?");
			
			 String userContinues = scnr.nextLine();
				
			if (userContinues.equalsIgnoreCase("y")) {
				printMenu();
				System.out.print("What item would you like to order ? ");		
				
				String itemName3 = scnr.nextLine();	
				Double itemPrice3 = items.get(itemName3);
				System.out.println("Adding " + itemName3 + " to cart at $ " + itemPrice3);
				addToArrays(itemName3, itemPrice3);			
			}
			
			else if (userContinues.equalsIgnoreCase("n")) 
				{
					promptingToContinue = false;
					System.out.println("Thanks for your order !");
					System.out.println("Here is what you got :");
					finalPrint();					
					calculateAverage(orderPrices);	
				}
		}
		scnr.close();		
	}
	
	
	
	
	
	// created method to calculate average
	private static Double calculateAverage(List <Double> orderPrices) {	   	  
	      for (int i=0; i< orderPrices.size(); i++) {	         
	    	  sum += orderPrices.get(i);
	          avg = sum / orderPrices.size();
	       }
	      System.out.println("Average price per item in oder was $ " + avg);
	      return avg;
	}
	
	
	// created method that adds to Parallel Arrays
	public static void addToArrays (String itemName1, Double itemPrice1 ) {
		orderNames.add(itemName1);
		orderPrices.add(itemPrice1);		
	}
	
	
    // added items in Map
	private static void fillItemsMap() {
		items.put("apple", 0.99);
		items.put("banana", 0.59);
		items.put("cauliflower", 1.59);
		items.put("dragonfruit", 2.19);
		items.put("elderberry", 1.79);
		items.put("figs", 2.09);
		items.put("grapefruit",1.99);
		items.put("honeydew", 3.49);
	}
	
	
	// this method prints Menu every time the user selects "y"
	private static void printMenu() {
		System.out.println("Item\t\t\tPrice");
		System.out.println("====\t\t\t=====");
		
		for(Map.Entry<String, Double> entry : items.entrySet()) {
			System.out.println(entry.getKey() + "\t\t $ " + entry.getValue());
		}
	}		
	
	
	// this method prints list of items before showing average price
	private static void finalPrint() {		
		for(int i=0; i< orderNames.size(); i++) {
			System.out.println(orderNames.get(i) + "    $" + orderPrices.get(i));
		}		
	}
	
	
}







/*

GUENTHER’S MARKET
Collections, Generics
Task: Make a shopping list application which uses collections to store your items. (NOTE: There is an optional video tutorial for starting this lab. The video mentions "lab 9", which was an old number for this lab.)

What will the application do?
Display a list of at least 8 item names and prices.
Ask the user to enter an item name
If that item exists, display that item and price and add that item and its price to the user’s order.
If that item doesn’t exist, display an error and re-prompt the user.  (Display the menu again if you’d like.)
Ask if they want to add another. Repeat if they do. (Th user can enter an item more than once; we’re not taking quantity at this point.)
When they’re done adding items, display a list of all items ordered with prices in columns.
Display the average price of items ordered.

Build Specifications
Use a Map to keep track of the menu of items. It should have a String key (for item name) and Double value (for item price).
Use parallel ArrayLists (one of strings, one of doubles) to store the items ordered and their prices.
Write 3 methods to find 1) the average cost of the items ordered and the indexes of the 2) highest and 3) lowest cost items.

Extended Challenges
Implement a menu system so the user can enter just a letter or number for the item.
Make a third ArrayList for quantities of items ordered and allow the user to order more than one at a time.
Extended: If they order an item already in their cart, increase the quantity rather than adding another entry.
Display the most and least expensive item ordered.

Console Preview:
Welcome to Guenther's Market!

Item            Price
==============================
apple           $0.99
banana          $0.59
cauliflower     $1.59
dragonfruit     $2.19
elderberry      $1.79
figs            $2.09
grapefruit      $1.99
honeydew        $3.49

What item would you like to order? apple
Adding apple to cart at $0.99

Would you like to order anything else (y/n)? y

{menu redisplays}

What item would you like to order? watermelon
Sorry, we don't have those.  Please try again.

{menu redisplays}

What item would you like to order? dragonfruit
Adding dragonfruit to cart at $2.19

Would you like to order anything else (y/n)? y

{menu redisplays}

What item would you like to order? honeydew
Adding honeydew to cart at $3.49

Would you like to order anything else (y/n)? y

{menu redisplays}

What item would you like to order? figs
Adding figs to cart at $2.09

Would you like to order anything else (y/n)? n

Thanks for your order!
Here's what you got:
apple           $0.99
dragonfruit     $2.19
honeydew        $3.49
figs            $2.09
Average price per item in order was 2.19


Grading Criteria:
There are ten possible points.
Use a Map to track the menu of items
Use parallel ArrayLists (one String, one double) to store ordered items and prices
Prompts and accepts item name from user
If item exists, name and item price are displayed, and item and price are added to user's order
If item doesn't exist, display error and re-prompt user
Once the user selects an item, ask if they want to continue shopping
When order is complete, display all items in the list with final prices in the column
Display average price of items ordered
(2pts) Uses the 3 methods defined in the build specs


*/
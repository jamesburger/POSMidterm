
/**
 * 
 * @author mperez
 * @author sbernardy
 * @author jburger
 * 
 * Developed by "Two Beards and a Smile."
 * Samuel Bernardy, Marcus J. Perez, and James Burger.
 * 
 * Point of Sale demonstration program for Grand Circus Java Developer Bootcamp.
 * This program will accept manual entry of employ credentials, admin menu, 
 * and inventory management with a text file representation. 
 * The program will also simulate card, check, and cash transactions.
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class POSMain {

	public static void main(String[] args) {
		ArrayList<Product> shopMenu = new ArrayList<Product>(12);
		ArrayList<Product> shopCart = new ArrayList<Product>(1);
		Scanner scan = new Scanner(System.in);

		int selectProductNumber;
		int selectProductQuantity;
		String continueShopping = "";
		boolean allowed = false;

		// List of employ profiles. Admin has inventory access.
		HashMap<String, String> login = new HashMap<String, String>();
		login.put("empl1201", "Qwerty!");
		login.put("empl1202", "QWerty!");
		login.put("empl1203", "QwErty!");
		login.put("empl1204", "QweRty!");
		login.put("empl1205", "QwerTy!");
		login.put("log_admin", "QwertY!");

		// auth and access admin options
		while (!allowed) {
			String enteredID = Validator.getString(scan, "USER_ID:   ");
			String enteredPass = Validator.getString(scan, "USED_PASS:   ");
			if (enteredPass.equals(login.get(enteredID))) {
				if (enteredID.equals("log_admin")) {
					while ((Validator.getChar(scan, "Would you like to add or remove an inventory item?(a/r/n)", "a",
							"r", "n")).equals("a")) {

						InventoryManagement.writeProduct(scan, "ProductLists", "inventory.txt");
					}
				}
				allowed = true;
			}
		}
		// confirm log in
		System.out.println("You have successfully logged in to checkout service.");
		System.out.println("Add an item to the cart? (y/n)");
		continueShopping = Validator.userChoice(scan);

		// shopMenu.add(new Product("Pickles", "super pickles", "seriously, the best
		// pickles", 20.00, 50));

		// import inventory
		shopMenu = InventoryManagement.createMenu("ProductLists", "Inventory.txt");

		// begin checkout process
		while (continueShopping.equalsIgnoreCase("y")) {
			printArray(shopMenu);
			selectProductNumber = Validator.getInt(scan, "Choose an item to add to the cart.", 1, shopMenu.size());
			selectProductQuantity = Validator.getInt(scan, "Choose a quantity to add.", 1,
					shopMenu.get(0).getProductQty());
			shopCart = purchaseSelection(selectProductNumber, selectProductQuantity, shopCart, shopMenu);
			System.out.println("Would you like to add another item to the cart? (y/n)");
			continueShopping = Validator.userChoice(scan);
		}
		new GrandTotal(shopCart);
		// print shopping cart
		System.out.println("Current shopping cart:");
		printArray(shopCart);

		// formated table for Cart
		System.out.println("Sub Total: " + GrandTotal.calculateSubTotal());
		System.out.println("Sales Tax: " + GrandTotal.calculateSalesTax());
		System.out.println("Total: " + GrandTotal.calculateGrandTotal());

		// Selecting payment type
		System.out.println("Please select a payment type:  cash , card, check");
		/*
		 * TODO if cash tender with change if card take Name/Number/expiration/CVV if
		 * check take check#/name
		 */

		System.out.println(" Receipt ");
		printArray(shopCart);
		/*
		 * TODO repeat grandTotal Method print payment method give change last 4 of
		 * credit card + name check# +
		 */

	}

	public static void printArray(ArrayList<Product> shopMenu) {

		System.out.printf("%-3s %-70s %-25s %-60s %10s %10s\n\n\n", "No.", "Product", "Category", "Description",
				"Price", "InStock");
		for (int i = 0; i < shopMenu.size(); ++i) {
			System.out.printf("%-3s %-70s %-25s %-60s %10.2f %10s\n", i + 1, shopMenu.get(i).getProductName(),
					shopMenu.get(i).getProductType(), shopMenu.get(i).getProductDes(),
					shopMenu.get(i).getProductPrice(), shopMenu.get(i).getProductQty());

		}
	}

	public static ArrayList<Product> purchaseSelection(int selectProductNumber, int selectProductQuantity,
			ArrayList<Product> shopCart, ArrayList<Product> shopMenu) {

		shopCart.add(new Product(shopMenu.get(selectProductNumber - 1).getProductName(),
				shopMenu.get(selectProductNumber - 1).getProductPrice(), selectProductQuantity));

		shopMenu.get(selectProductNumber - 1)
				.setProductQty(shopMenu.get(selectProductNumber - 1).getProductQty() - selectProductQuantity);

		return shopCart;
	}

}

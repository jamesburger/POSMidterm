
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

import org.omg.Messaging.SyncScopeHelper;

public class POSMain {

	public static void main(String[] args) {
		ArrayList<Product> shopMenu = new ArrayList<Product>(12);
		ArrayList<Product> shopCart = new ArrayList<Product>(1);
		Scanner scan = new Scanner(System.in);

		int selectProductNumber;
		int selectProductQuantity;
		String continueShopping = "";
		boolean allowed = false;
		String[] paymentType = { "Cash", "Card", "Check" };
		int selectPayment = 0;

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
		Coupon couponCode = new Coupon();
		// formated table for Cart
		System.out.println("Do you have a coupon today? (y/n): ");
		String couponValidate = Validator.userChoice(scan);
		if (couponValidate.equalsIgnoreCase("y")) {
			int userCouponCode = Validator.getInt(scan, "Please enter your coupon code: ", 00000, 99999);
			if (userCouponCode == 56478) {
				
				System.out.println("Sub Total: " + GrandTotal.calculateSubTotal());
				System.out.println("Sales Tax: " + GrandTotal.calculateSalesTax());
				System.out.println("Total: " + (GrandTotal.calculateGrandTotal() - (GrandTotal.calculateGrandTotal()*0.1)));

			} else {
				System.out.println("That is not a valid coupon code");
			}
			
		} else {
			printAllTotals();
			
		}

		printPayment(paymentType);
		/*
		 * TODO if cash tender with change if card take Name/Number/expiration/CVV if
		 * check take check#/name
		 */

		System.out.println(" Receipt ");
		printArray(shopCart);
		paymentType(scan);
		couponCode.couponGenerator(shopCart);
		
		/*
		 * TODO repeat grandTotal Method print payment method give change last 4 of
		 * credit card + name check# +
		 */

	}

	public static void printAllTotals() {
		System.out.println("Sub Total: " + GrandTotal.calculateSubTotal());
		System.out.println("Sales Tax: " + GrandTotal.calculateSalesTax());
		System.out.println("Total: " + GrandTotal.calculateGrandTotal());
	}

	public static void paymentType(Scanner scan) {
		int selectPayment;
		selectPayment = Validator.getInt(scan, "How is this being paid?", 1, 3);
		if (selectPayment == 1) {
			Payment cashing = new Cash();
			cashing.setPaid(Validator.getDouble(scan, "Enter amount tendered.", GrandTotal.calculateGrandTotal(),
					Double.MAX_VALUE));

			System.out.println(cashing.getPaid());
		} else if (selectPayment == 2) {
			Payment carding = new CreditCard((Validator.getString(scan, "Enter Name on Card: ")),
					(Validator.getLong(scan, "Enter Card Number:", 1000000000000000l, 9999999999999999l)),
					Validator.getInt(scan, "Enter expiration month", 1, 12),
					Validator.getInt(scan, "enter expiration year", 17, 30),
					Validator.getInt(scan, "Enter CVV", 1, 999));

			System.out.println(carding.getIdNum() + carding.getName() + carding.getCvv() + carding.getExpirationMonth()
					+ carding.getExpirationYear());

		} else {
			Payment checking = new Check();
			checking.setRouteNum(Validator.getLong(scan, "Enter Routing Number:   ", 000000001l, 999999999l));
			checking.setAccNum(Validator.getLong(scan, "Enter Account number:   ", 000000000001l, 999999999999l));
			checking.setIdNum(Validator.getInt(scan, "Enter check number:   ", 1, 999999999));

			System.out.println(checking.getRouteNum() + checking.getAccNum() + checking.getIdNum());
		}
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

	public static void printPayment(String[] paymentMenu) {

		for (int i = 0; i < paymentMenu.length; i++) {
			System.out.println((i + 1) + paymentMenu[i]);
		}
	}
}

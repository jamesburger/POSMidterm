import java.util.ArrayList;
import java.util.Scanner;

public class POSMain {

	public static void main(String[] args) {
		ArrayList<Product> shopMenu = new ArrayList<Product>(12);
		ArrayList<Product> shopCart = new ArrayList<Product>(1);
		Scanner scan = new Scanner(System.in);

		System.out.println("Hello Shopper");
		int i;
		int selectProductNumber;
		int itemQuantity;
		int selectProductQuantity;

		String continueShopping = "";

		System.out.println("Welcome to our store!");
		System.out.println("Would you like to being shopping? (y/n): ");
		continueShopping = Validator.userChoice(scan);

		shopMenu.add(new Product("Pickles", "super pickles", "seriously, the best pickles", 20.00, 50));

		while (continueShopping.equalsIgnoreCase("y")) {
			System.out.println("Please select an item from our menu!!");
			printArray(shopMenu);
			System.out.println("Please select the item you'd like to add to your cart!");
			selectProductNumber = Validator.getInt(scan, "", 1, shopMenu.size());
			System.out.println("Please enter the number of the item you'd like to add to your cart");
			selectProductQuantity = Validator.getInt(scan, "", 1, shopMenu.get(0).getProductQty());
			shopCart = purchaseSelection(selectProductNumber, selectProductQuantity, shopCart, shopMenu);
			System.out.println("would you like to continue shpping (y/n)");
			continueShopping = Validator.userChoice(scan);
		}
		new GrandTotal(shopCart);

		System.out.println("shopping cart print " + shopCart);

		// formated table for Cart

		System.out.println("Sub Total: " + GrandTotal.calculateSubTotal());
		System.out.println("Sales Tax: " + GrandTotal.calculateSalesTax());
		System.out.println("Total: " + GrandTotal.calculateGrandTotal());

		// Selecting payment type
		System.out.println("Please select a payment type:  cash , card, check");
		// if cash tender with change
		// if card take Name/Number/expiration/CVV
		// if check take check#/name

		System.out.println(" Receipt ");
		printArray(shopCart);
		// repeat grandTotal Method
		// print payment method
		// give change
		// last 4 of credit card + name
		// check# +

	}

	public static void printArray(ArrayList<Product> shopMenu) {
		for (int i = 0; i < shopMenu.size(); ++i) {
			System.out.print((i + 1) + ":");
			System.out.println(shopMenu.get(i));

		}
	}

	public static ArrayList<Product> purchaseSelection(int selectProductNumber, int selectProductQuantity,
			ArrayList<Product> shopCart, ArrayList<Product> shopMenu) {

		shopCart.add(new Product(shopMenu.get(selectProductNumber - 1).getProductName(),
				shopMenu.get(selectProductNumber - 1).getProductPrice(), selectProductQuantity));
		return shopCart;
	}

}

import java.util.ArrayList;
import java.util.Scanner;

public class POSMain {

	public static void main(String[] args) {
		ArrayList<Product> shopMenu = new ArrayList<Product>(12);
		ArrayList<Product> shopCart = new ArrayList<Product>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Hello Shopper");
		int i;
		int selectProductNumber;
		int itemQuantity;
		
		String continueShopping = "y";

		System.out.println("Please select an item from our menu!!");
		shopMenu.add(new Product("Pickles", "super pickles", "seriously, the best pickles", 20.00, 50));
		// System.out.println(shopMenu.get(0));
		printArray(shopMenu);

		while (continueShopping == "y") {
			System.out.println("Please enter the number of the item you'd like to add to your cart");
			selectProductNumber = Validator.getInt(scan, "", 1, shopMenu.size());
			// add from one array to another
			// TODO grab item name price and amount wanted
			shopCart.add(shopMenu.get(selectProductNumber - 1));
			// test print
			printArray(shopCart);
			System.out.println("would you like to continue shpping (y/n)");
			// exit loop
			continueShopping = "n";
			
			System.out.println(shopCart.get(0).getProductPrice());
			
		}
		System.out.println("shoping cart print " + shopCart);
		//for loop add shop cart price 
		//formated table for Cart	
		
		//TODO grab item quantity * item amount repeat for each item = subtotal
		System.out.println("subtotal " + shopCart.get(0).getProductPrice());
		// subTotal * .06 = salesTax
		System.out.println("sales tax" +shopCart.get(0).getProductPrice() * (.06));
		//subTOtal + salesTax = GrandTotal
		System.out.println("grand total" +(shopCart.get(0).getProductPrice() * (.06) + shopCart.get(0).getProductPrice()));
		
		
		//Selecting payment type
		System.out.println("Please select a payment type:  cash , card, check");
		//if cash tender with change
		//if card take Name/Number/expiration/CVV
		//if check take check#/name
		
		System.out.println(" Receipt ");
		printArray(shopCart);
		//repeat grandTotal Method
		//print payment method
		//give change
		//last 4 of credit card + name
		//check# + 
		
		
	}
	
	

	public static void printArray(ArrayList<Product> shopMenu) {
		for (int i = 0; i < shopMenu.size(); ++i) {
			System.out.print((i + 1) + ":");
			System.out.println(shopMenu.get(i));

		}
	}

}

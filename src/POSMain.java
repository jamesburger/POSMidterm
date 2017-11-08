import java.util.ArrayList;
import java.util.Scanner;

public class POSMain {

	public static void main(String[] args) {
		ArrayList<Product> shopMenu = new ArrayList(12); 
		ArrayList<Product> shopCart = new ArrayList(); 
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello Shopper");
		
	int selectProductNumber;	
	int itemQuantity; 
	
	
	System.out.println("Please select an item from our menu!!");
	shopMenu.add(new Product("Pickles", "super pickles", "seriously, the best pickles", 20.00, 50));
	//System.out.println(shopMenu.get(0));
		printArray(shopMenu);  
		
		System.out.println("Please enter the number of the item you'd like to add to your cart");
		selectProductNumber = Validator.getInt(scan, "", 1, shopMenu.size());
		
		

	}
	
	public static void printArray(ArrayList<Product> shopMenu) {
		for (int i = 0; i < shopMenu.size(); ++i) {
			System.out.print((i + 1) + ":");
			System.out.println(shopMenu.get(i));

		}
}

}

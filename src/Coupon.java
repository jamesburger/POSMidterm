import java.util.ArrayList;

public class Coupon extends Product{
	
	String itemSelect;
	public static int discountRate = (int) ((Math.random() + 1) * 5.0); 
	
/*	itemSelect = (shopCart.getProductName((int) Math.random() * shopCart.length())); 
	dollarAmount = (int) Math.random() * ((shopCart.getProductPrice.getProductName(item)) * 0.2);
	
	*/
	
	public static int couponGenerator(ArrayList<Product> shopCart) {
	 
      String couponItem = shopCart.get((int) Math.random() * shopCart.size()).getProductName();
      System.out.println("**			We hope to see you again!				**");
      System.out.println("**			Coupon code: 56478						**");
      System.out.println("**Come again soon, and for a limited time you'll get	**");
      System.out.println("$" + discountRate + ".00 off your next purchase of " + couponItem + "!!!");
      
      return discountRate;
  }
	
}


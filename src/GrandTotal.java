import java.util.ArrayList;

public class GrandTotal {
private static double salesTax;
private static double subTotal;
private static ArrayList<Product> shopping;

 

public GrandTotal(ArrayList shoppingCart) {
	this.shopping = shoppingCart;
	
}
public static double calculateSubTotal() {
	double gtotal = 0;
	for(int i = 0; i< shopping.size(); i++) {
		subTotal = (shopping.get(i).getProductPrice() * shopping.get(i).getProductQty() ) ;
		gtotal = subTotal + gtotal;
	} return gtotal;
}

public static double calculateSalesTax() {
	
	salesTax = calculateSubTotal() * (.06);

return salesTax;
}

public static double calculateGrandTotal() {
	double gTotal = calculateSalesTax() + calculateSubTotal();
	return gTotal;
}
public double getTax() {
	return salesTax;
}
public void setTax(double tax) {
	this.salesTax = tax;
}
public double getSubTotal() {
	return subTotal;
}
public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}
}
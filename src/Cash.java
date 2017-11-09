
public class Cash extends Payment{
	public static double cashTransaction(double cashin, double total) {
		double change = cashin - total;
		return change;
	}
}

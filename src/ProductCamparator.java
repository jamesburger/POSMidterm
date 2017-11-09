import java.util.Comparator;

public class ProductCamparator implements Comparator {

	@Override
	public int compare(Object prod1, Object prod2) {
		return ((Product) prod1).getProductName().compareTo(((Product) prod2).getProductName());
	}

}

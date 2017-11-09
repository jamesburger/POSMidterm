
public class CreditCard extends Payment {

	/*
	 * public CreditCard (String name ,int cardNumber, int expiration , int cvv ) {
	 * 
	 * }
	 */
	public int expiration;
	public int cvv;
	
	

	public CreditCard(int expiration, int cvv) {
		super();
		this.expiration = expiration;
		this.cvv = cvv;
	}

	public int getExpiration() {
		return expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}

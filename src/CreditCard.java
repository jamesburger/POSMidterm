
public class CreditCard extends Payment {

	/*
	 * public CreditCard (String name ,int cardNumber, int expiration , int cvv ) {
	 * 
	 * }
	 */
	public long idNum;
	public int expirationMonth;
	public int expirationYear;
	public int cvv;
	
	
	
	public int getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}


	public CreditCard(String cardName, long cardNum, int expirationMonth, int expirationYear,int cvv) {
		super(cardNum, cardName);
		
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
	}

	public int getExpiration() {
		return expirationMonth;
	}

	public void setExpiration(int expiration) {
		this.expirationMonth = expiration;
	}

	public long getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}

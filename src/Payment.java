import java.math.BigDecimal;

public abstract class Payment {
private double paid ;
private long idNum;
private String name;


public Payment() {
	
}
public Payment(long idNum, String name) {
	super();
	this.idNum = idNum;
	this.name = name;
}
public double getPaid() {
	return paid;
}
public void setPaid(double d) {
	this.paid = d;
}
public long getIdNum() {
	return idNum;
}
public void setIdNum(long idNum) {
	this.idNum = idNum;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void setRouteNum(long long1) {
	// TODO Auto-generated method stub
	
}
public void setAccNum(long long1) {
	// TODO Auto-generated method stub
	
}
public long getCvv() {
	// TODO Auto-generated method stub
	return 0;
}
public long getExpirationMonth() {
	// TODO Auto-generated method stub
	return 0;
}
public int getExpirationYear() {
	// TODO Auto-generated method stub
	return 0;
}
public long getRouteNum() {
	// TODO Auto-generated method stub
	return 0;
}
public long getAccNum() {
	// TODO Auto-generated method stub
	return 0;
}

}

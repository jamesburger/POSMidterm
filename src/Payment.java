import java.math.BigDecimal;

public abstract class Payment {
private BigDecimal paid ;
private int idNum;
private String name;



public Payment() {
	
}
public Payment(int idNum, String name) {
	super();
	this.idNum = idNum;
	this.name = name;
}
public BigDecimal getPaid() {
	return paid;
}
public void setPaid(BigDecimal paid) {
	this.paid = paid;
}
public int getIdNum() {
	return idNum;
}
public void setIdNum(int idNum) {
	this.idNum = idNum;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

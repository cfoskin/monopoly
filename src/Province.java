/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 *
 */

public class Province extends BoardSpace {
	protected int rent1;
	protected int rent2;
	protected int rent3;
	protected int rent4;
	protected int mortgage;
	protected int value;

	public Province(String name, String colour,Player owner,boolean isItOwned,int rent1, int rent2, int rent3, int rent4,int mortgage, int value) {
		super(name, colour, owner, isItOwned);
		this.rent1=rent1;
		this.rent2=rent2;
		this.rent3=rent3;
		this.rent4=rent4;
		this.mortgage=mortgage;
		this.value=value;
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value= value;
	}

	public int getRent1() {
		return rent1;
	}

	public void setRent1(int rent1) {
		this.rent1=rent1;
	}

	public int getRent2() {
		return rent2;
	}

	public void setRent2(int rent2) {
		this.rent2=rent2;
	}

	public int getRent3() {
		return rent3;
	}

	public void setRent3(int rent3) {
		this.rent3=rent3;
	}

	public int getRent4() {
		return rent4;
	}

	public void setRent4(int rent4) {
		this.rent4=rent4;
	}

	public int getMortgage() {
		return mortgage;
	}

	public void setMortgage(int mortgage) {
		this.mortgage=mortgage;
	}

	public String toString() {
		return   "Cost of this Province is: " + value + "  " + "rent1=" + rent1 + ", rent2=" + rent2 + ", rent3="
				+ rent3 + ", rent4=" + rent4 + ", mortgage=" + mortgage
				+ "\n" + " name=" + name + " colour=" + colour + " " + "is it owned = " + isItOwned
				+ ", owner=" + owner + "\n" + "====================>>>>>>>>>>>>>>>>>>";
	}
	

}
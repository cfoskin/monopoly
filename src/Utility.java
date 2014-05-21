/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 *
 */
public class Utility extends BoardSpace {
	private int value;
	private int mortgage;

	public Utility(String name, String colour, Player owner, boolean isItOwned, int value, int mortgage) {
		super(name, colour, owner, isItOwned);
		this.value=value;
		this.mortgage=mortgage;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getMortgage() {
		return mortgage;
	}

	public void setMortgage(int mortgage) {
		this.mortgage = mortgage;
	}

	public String toString() {
		return "Cost of this Utility" + value + ", mortgage=" + mortgage + ", name="
				+ name + ", colour=" + colour + ", owner=" + owner+ "\n" + "====================>>>>>>>>>>>>>>>>>>" ;
	}

	

}

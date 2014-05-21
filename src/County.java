
/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 *
 */
public class County extends Province {
	private String deeds;
	private int rentSite;
	private int hotelRent;
	private int apartmentCost;
	private int hotelCost;
	public County(String name, String colour,Player owner, boolean isItOwned, int value, String deeds, int rentSite, int rent1, int rent2, int rent3, int rent4, int hotelRent, int apartmentCost,int hotelCost,  int mortgage)
	{
		super(name, colour, owner, isItOwned, rent1,rent2, rent3, rent4,mortgage, value); 
		this.deeds= deeds;
		this.rentSite= rentSite;
		this.rent1= rent1;
		this.rent2= rent2;
		this.rent3= rent3;
		this.rent4= rent4;
		this.hotelRent= hotelRent;
		this.apartmentCost= apartmentCost;
		this.hotelCost= hotelCost;
		this.mortgage= mortgage;
	}
	
	public String getDeeds()
	{
		return deeds;
	}
	public void setDeeds(String deeds)
	{
		this.deeds=deeds;
	}
	public int getRentSite()
	{
		return rentSite;
	}
	public void setRentSite(int rentSite)
	{
		this.rentSite=rentSite;
	}
	public int getHotelCost()
	{
		return hotelCost;
	}
	public void setHotelCost(int hotelCost)
	{
		this.hotelCost= hotelCost;
	}
	public int getApartmentCost()
	{
		return apartmentCost;
	}
	public void setApartmentCost(int apartmentCost)
	{
		this.apartmentCost=apartmentCost;
	}
	public int getHotelRent()
	{
		return hotelRent;
	}
	public void setHotelRent(int hotelRent)
	{
		this.hotelRent= hotelRent;
	}
	

	public String toString() {
		return " Cost of this County: " + value
				+"  " + deeds + ", rentSite=" + rentSite
				+ ", hotelRent=" + hotelRent + ", apartmentCost="
				+ apartmentCost + ", hotelCost=" + hotelCost + ", rent1="
				+ rent1 + "\n" + " rent2=" + rent2 + ", rent3=" + rent3 + ", rent4="
				+ rent4 + ", mortgage=" + mortgage +  ", name=" + name + ", colour=" + colour + " "  + "is it owned = "+ isItOwned + ", owner=" + owner + "\n" + "=====================>>>>>>>>>>>>>>>>";
	}

}

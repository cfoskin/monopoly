import java.util.ArrayList;

public class Bank
{
    private ArrayList<Integer> money;
	
	public Bank()
	{
		money= new ArrayList<Integer>();
		
	}
	
	public ArrayList<Integer> getMoney()
	{
		return money;
	}
	public void setMoney(ArrayList<Integer> money)
	{
		money= new ArrayList<Integer>();
	}
}

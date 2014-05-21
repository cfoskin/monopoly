import java.util.ArrayList;
/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 *
 */
public class Details  extends GamePlay{

	public Details() {
		// Populating the array of spaces with the details for each space
		BoardSpace zero = new BoardSpace("Start/ Pass Go and collect 2million Euros", " White", null,false);
		spaces.add(zero);
		BoardSpace one = new County("Westmeath", "Brown",null,false, 600000,"Westmeath deeds", 20000, 100000, 300000, 900000, 1600000,2500000, 500000, 500000, 300000);
		spaces.add(one);
		BoardSpace two = new BoardSpace("Community chest ", " White",null,false);
		spaces.add(two);
		BoardSpace three = new County("Donegal ", " Brown", null,false,60000,"Donegal deeds", 40000, 200000, 600000, 1800000, 3200000,4500000, 500000, 500000, 300000);
		spaces.add(three);
		BoardSpace four = new BoardSpace("Income tax: pay 2 million euros!"," White",null,false);
		spaces.add(four);
		BoardSpace five = new Province("Munster ", " White",null,false, 250000, 500000,1000000, 2000000, 1000000, 2000000);
		spaces.add(five);
		BoardSpace six = new County("Sligo ", " Blue",null,false, 1000000, "Sligo deeds",60000, 300000, 900000, 2700000, 4000000, 5500000, 500000,500000, 500000);
		spaces.add(six);
		BoardSpace seven = new BoardSpace("Chance ", " White",null,false);
		spaces.add(seven);
		BoardSpace eight = new County("Down ", " Blue",null,false, 1000000, "Down deeds",60000, 300000, 900000, 2700000, 4000000, 5500000, 500000,500000, 500000);
		spaces.add(eight);
		BoardSpace nine = new County("Laois ", " Blue", null,false,1200000," Laois deeds", 80000, 400000, 1000000, 3000000, 4500000,6000000, 500000, 500000, 600000);
		spaces.add(nine);
		BoardSpace ten = new BoardSpace("IN JAIL ", " White",null,false);
		spaces.add(ten);
		BoardSpace eleven = new County("Tyrone ", " Pink",null,false, 1400000,"Tyrone deeds", 100000, 500000, 1500000, 4500000, 6250000,7500000, 1000000, 1000000, 700000);
		spaces.add(eleven);
		BoardSpace twelve = new Utility("Telecoms ", " White", null,false,1500000, 750000);
		spaces.add(twelve);
		BoardSpace thirteen = new County("Cavan", " Pink", null,false,1400000,"Cavan deeds", 100000, 500000, 1500000, 4500000, 6250000,7500000, 1000000, 1000000, 700000);
		spaces.add(thirteen);
		BoardSpace fourteen = new County("Kerry ", " Pink",null,false, 1600000,"Kerry deeds", 120000, 600000, 1800000, 5000000, 7000000,9000000, 1000000, 1000000, 800000);
		spaces.add(fourteen);
		BoardSpace fifteen = new Province("Connaught ", " White",null,false, 250000,500000, 1000000, 2000000, 1000000, 2000000);
		spaces.add(fifteen);
		BoardSpace sixteen = new County("Fermanagh ", " Orange ",null,false, 1800000," Fermanagh deeds ", 140000, 700000, 2000000, 5500000, 7500000,9500000, 1000000, 1000000, 900000);
		spaces.add(sixteen);
		BoardSpace seventeen = new BoardSpace("Community Chest ", " White",null,false);
		spaces.add(seventeen);
		BoardSpace eighteen = new County("Leitrim ", " Orange ", null,false,1800000," Leitrim deeds ", 140000, 700000, 2000000, 5500000, 7500000,9500000, 1000000, 1000000, 900000);
		spaces.add(eighteen);
		BoardSpace nineteen = new County("Galway ", " Orange ",null,false, 2000000," Galway deeds ", 160000, 800000, 2200000, 6000000, 8000000,10000000, 1000000, 1000000, 1000000);
		spaces.add(nineteen);
		BoardSpace twenty = new BoardSpace("FREE PARKING ", " White",null,false);
		spaces.add(twenty);
		BoardSpace twentyone = new County("Meath ", " Red ",null,false, 2200000," Meath deeds ", 180000, 900000, 2500000, 7000000, 8750000,10500000, 1500000, 1500000, 1100000);
		spaces.add(twentyone);
		BoardSpace twentytwo = new BoardSpace("Chance ", " White",null,false);
		spaces.add(twentytwo);
		BoardSpace twentythree = new County("Kilkenny ", " Red ",null,false, 2200000," Kilkenny deeds ", 180000, 900000, 2500000, 7000000, 8750000,10500000, 1500000, 1500000, 1100000);
		spaces.add(twentythree);
		BoardSpace twentyfour = new County("Offaly ", " Red ",null,false, 2400000," Offaly deeds ", 200000, 1000000, 3000000, 7500000, 9225000,11000000, 1500000, 1500000, 1200000);
		spaces.add(twentyfour);
		BoardSpace twentyfive = new Province("Leinster ", " White",null,false, 250000,500000, 1000000, 2000000, 1000000, 2000000);
		spaces.add(twentyfive);
		BoardSpace twentysix = new County("Mayo ", " Yellow ",null,false, 2600000," Mayo deeds ", 220000, 1100000, 3300000, 8000000, 9750000,11500000, 1500000, 1500000, 1300000);
		spaces.add(twentysix);
		BoardSpace twentyseven = new County("Dublin ", " Yellow ",null,false, 2600000," Dublin deeds ", 220000, 1100000, 3300000, 8000000, 9750000,11500000, 1500000, 1500000, 1300000);
		spaces.add(twentyseven);
		BoardSpace twentyeight = new Utility("Internet ", " White", null,false,1500000,750000);
		spaces.add(twentyeight);
		BoardSpace twentynine = new County("Louth ", " Yellow ",null,false, 2800000," Louth deeds ", 240000, 1200000, 3600000, 8500000, 10250000,12000000, 1500000, 1500000, 1400000);
		spaces.add(twentynine);
		BoardSpace thirty = new BoardSpace("GO TO JAIL ", " White",null,false);
		spaces.add(thirty);
		BoardSpace thirtyone = new County("Wexford ", " Green ", null,false,3000000,	" Wexford deeds ", 260000, 1300000, 3900000, 9000000, 11000000, 12750000, 2000000, 2000000, 1500000);
		spaces.add(thirtyone);
		BoardSpace thirtytwo = new County("Limerick ", " Green ",null,false, 3000000," Limerick deeds ", 260000, 1300000, 3900000, 9000000,11000000, 12750000, 2000000, 2000000, 1500000);
		spaces.add(thirtytwo);
		BoardSpace thirtythree = new BoardSpace("Community Chest ", " White",null,false);
		spaces.add(thirtythree);
		BoardSpace thirtyfour = new County("Waterford ", " Green ",null,false, 3200000," Waterford deeds ", 280000, 1500000, 4500000, 10000000,12000000, 14000000, 2000000, 2000000, 1600000);
		spaces.add(thirtyfour);
		BoardSpace thirtyfive = new Province("Ulster ", " White",null,false, 250000,500000, 1000000, 2000000, 1000000, 2000000);
		spaces.add(thirtyfive);
		BoardSpace thirtysix = new BoardSpace("Chance ", " White",null,false);
		spaces.add(thirtysix);
		BoardSpace thirtyseven = new County("Cork ", " Navy ",null,false, 3500000," Cork deeds ", 350000, 1750000, 5000000, 11000000, 13000000,15000000, 2000000, 2000000, 1750000);
		spaces.add(thirtyseven);
		BoardSpace thirtyeight = new BoardSpace("Stamp Duty: Pay 1 million euros! ", " White",null,false);
		spaces.add(thirtyeight);
		BoardSpace thirtynine = new County("Roscommon ", " Navy ",null,false, 4000000," Roscommon deeds ", 500000, 2000000, 6000000, 14000000,17000000, 20000000, 2000000, 2000000, 2000000);
		spaces.add(thirtynine);
		//end
	   //populating the arrays of cards both chance and community chest
		//cardsChance = new ArrayList<ChanceCards>();
		//comChest = new ArrayList<CommunityChest>();

		cardsChance.add(new ChanceCards("Advance to roscommon"));
		cardsChance.add(new ChanceCards("Pay private school fees"));
		cardsChance.add(new ChanceCards(
				"Rush hour traffic, go back three spaces"));
		cardsChance
				.add(new ChanceCards(
						"Get out of jail free card. This card may be kept until needed or sold"));
		cardsChance.add(new ChanceCards(
				"Sell your shares for a profit Collect $1M"));
		cardsChance.add(new ChanceCards(
				"Advance to Tyrone, if you pass GO  collect $2 M"));
		cardsChance
				.add(new ChanceCards(
						"Get out of jail free card. This card may be kept until needed or sold"));
		cardsChance.add(new ChanceCards("Advance to go"));
		cardsChance.add(new ChanceCards(
				"Advance to Offaly, if you pass GO  collect $2 M"));
		comChest.add(new CommunityChest(
				"You win tickets to a sold out All-Ireland final and sell for a huge profit. Collect $200K"));
		comChest.add(new CommunityChest(
				"Pay $500k for a 5-star weekend spa break in Donegal"));
		comChest.add(new CommunityChest(
				"Collect $1M profits for chartering your private helicopter."));
		comChest.add(new CommunityChest(
				"Your car insurance claim is settled. Collect $250k"));
		comChest.add(new CommunityChest(
				"You are investigated for identity fraud. Go to jail. Move directly to jail. Do not pass go. Do not collect $2M"));
		comChest.add(new CommunityChest("Advance to GO"));
		comChest.add(new CommunityChest("Go back to Westmeath"));
		comChest.add(new CommunityChest(
				"Your colleagues hire your holiday home for a week. Collect $100k from each player."));
		comChest.add(new CommunityChest(
				"GET OUT OF JAIL FREE card. This card may be kept until needed or sold."));
	}
	
	private void save() {
		StdStream.saveToFile(spaces, "myBoardSpaces.xml");
	}

	private void load() {
		spaces = (ArrayList<BoardSpace>) StdStream
				.readFromFile("myBoardSpaces.xml");
	}
	
}

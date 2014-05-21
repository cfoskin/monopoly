import java.util.ArrayList;

/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 *
 */
public class Player extends GamePlay {

	private String name;
	private int money;
	private int position;
	private String token;
	private int numOfHotels;
	private int numOfApartments;
	private int numOfUtilities;
	private int numOfCounties;
	private int numOfProvinces;
	private int numOfJailCards;
	private boolean jailCardOwned;
	
	public Player(String name, String token) {
		this.name = name;
		this.money = 15000000;
		this.position = 0;
		this.token = token;
		this.numOfHotels = 0;
		this.numOfCounties=0;
		this.jailCardOwned= false;
	}
	
	public boolean getJailCardOwned() {
		return jailCardOwned;
	}
	public void setJailCardOwned(boolean jailCardOwned) {
		this.jailCardOwned = jailCardOwned;
	}
	public int getNumOfProvinces() {
		return numOfProvinces;
	}
	public void setNumOfProvinces(int numOfProvinces) {
		this.numOfProvinces = numOfProvinces;
	}
	public int getNumOfCounties() {
		return numOfCounties;
	}
	public void setNumOfCounties(int numOfCounties) {
		this.numOfCounties = numOfCounties;
	}
	public int getNumOfHotels() {
		return numOfHotels;
	}
	public void setNumOfHotels(int numOfHotels) {
		this.numOfHotels = numOfHotels;
	}
	public int getNumOfApartments() {
		return numOfApartments;
	}
	public void setNumOfApartments(int numOfApartments) {
		this.numOfApartments = numOfApartments;
	}
	public String getName() {
		return name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = 15000000;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getNumOfUtilities() {
		return numOfUtilities;
	}
	public void setNumOfUtilities(int numOfUtilities) {
		this.numOfUtilities = numOfUtilities;
	}

	public void showPlayersSpaces(ArrayList<BoardSpace> spaces) {
		boolean foundAny = false;
		for (int i = 0; i < spaces.size(); i++) {
			if (spaces.get(i).getOwner() != null
					&& spaces.get(i).getOwner().equals(this)) {
				StdOut.println(spaces.get(i).getName());
				foundAny = true;
			}
		}
		if (!foundAny) {
			StdOut.println("no spaces owned");
		}
	}
	// /This is a list of all the methods for when a player lands on a county
	// type board space
	public void payRentSite(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int rentSite = mySpace.getRentSite();
		if (myMoney >= rentSite) {
			myMoney = myMoney - rentSite;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner= mySpace.getOwner();
            int spaceOwnerMoney = spaceOwner.getMoney();
            spaceOwnerMoney += rentSite;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rentSite + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");       
			} else {
			StdOut.println(this.name + " does not have enough money left for this!!");this.money = 0;
		}
	}

	public void payRent1(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int rent1 = mySpace.getRent1();
		if (myMoney > rent1) {
			myMoney = myMoney - rent1;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent1;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent1 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");       
         } else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	}

	public void payRent2(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int rent2 = mySpace.getRent2();
		if (myMoney > rent2) {
			myMoney = myMoney - rent2;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent2;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent2 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	}

	public void payRent3(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int rent3 = mySpace.getRent3();
		if (myMoney > rent3) {
			myMoney = myMoney - rent3;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent3;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent3 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
		
	}

	public void payRent4(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int rent4 = mySpace.getRent4();
		if (myMoney > rent4) {
			myMoney = myMoney - rent4;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent4;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent4 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!"); this.money = 0;
		}
	}

	public void payHotelRent(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int hotelRent = mySpace.getHotelRent();
		if (myMoney > hotelRent) {
			myMoney = myMoney - hotelRent;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += hotelRent;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + hotelRent + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	
	}

	public void buildApartment(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int apartmentCost = mySpace.getApartmentCost();
		if (myMoney > apartmentCost) {
			myMoney = myMoney - apartmentCost;
			this.money = myMoney;
			numOfApartments++;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!" + "" + "now has: " + numOfApartments + " apartments");
		} else {
			StdOut.println(this.name + " does not have enough money left for this!!");
		}
	}

	public void buildHotel(ArrayList<BoardSpace> spaces) {
		if (this.numOfApartments >= 4) {
			int myMoney = this.getMoney();
			int newPosition = this.getPosition();
			County mySpace = (County) spaces.get(newPosition);
			int hotelCost = mySpace.getHotelCost();
			if (myMoney > hotelCost) {
				myMoney = myMoney - hotelCost;
				this.money = myMoney;
				numOfHotels++;
				StdOut.println(this.name + " " + "now has :" + myMoney
						+ "left!!" + "" + "now has: " + numOfHotels + " hotels");
			} else {
				StdOut.println(this.name
						+ " does not have enough money left for this!!");
			}
		} else {
			StdOut.println("you need to own at least 4 apartments to buy a hotel!"
					+ "\n"
					+ " please select another option"
					+ "\n"
					+ "====>>>>>>>>>>");
		}
	 }

	public void payMortgage(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
		int mortgage = mySpace.getMortgage();
		if (myMoney > mortgage) {
			myMoney = myMoney - mortgage;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");
		}
	}
	
	public void buyCounty(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		County mySpace = (County) spaces.get(newPosition);
			int countyValue = mySpace.getValue();
			if (myMoney > countyValue) {
				myMoney = myMoney - countyValue;
				this.money = myMoney;
				mySpace.setOwner(this);
				mySpace.setIsItOwned(true);
				StdOut.println(this.name + " " + "now has :" + myMoney + "left!!" + "and owns :" + mySpace.getName());
				numOfCounties++;
			} else {
				StdOut.println(this.name
				+ " does not have enough money left for this!!");
			}
	   }
	// / end of county type methods
	
	// This is a list of all the methods for when a player lands on a province
	// type board space
	public void payRent1Prov(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Province mySpace = (Province) spaces.get(newPosition);
		int rent1 = mySpace.getRent1();
		if (myMoney > rent1) {
			myMoney = myMoney - rent1;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent1;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent1 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
		 }

	public void payRent2Prov(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Province mySpace = (Province) spaces.get(newPosition);
		int rent2 = mySpace.getRent2();
		if (myMoney > rent2) {
			myMoney = myMoney - rent2;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent2;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent2 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	}
	
	public void payRent3Prov(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Province mySpace = (Province) spaces.get(newPosition);
		int rent3 = mySpace.getRent3();
		if (myMoney > rent3) {
			myMoney = myMoney - rent3;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent3;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent3 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} 
		else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
		 }

	public void payRent4Prov(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Province mySpace = (Province) spaces.get(newPosition);
		int rent4 = mySpace.getRent4();
		if (myMoney > rent4) {
			myMoney = myMoney - rent4;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent4;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent4 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		} 
		else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
		 }

	public void payMortgageProv(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Province mySpace = (Province) spaces.get(newPosition);
		int mortgage = mySpace.getMortgage();
		if (myMoney > mortgage) {
			myMoney = myMoney - mortgage;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");
		}
	}

	public void buyProvince(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Province mySpace = (Province) spaces.get(newPosition);
		int provinceValue = mySpace.getValue();
		if (myMoney > provinceValue) {
			myMoney = myMoney - provinceValue;
			this.money = myMoney;
			mySpace.setOwner(this);
			mySpace.setIsItOwned(true);
			numOfProvinces++;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!"	+ "owns :" + mySpace.getName());
		} else {
			StdOut.println(this.name + " does not have enough money left for this!!");
		}
	}// end of province methods

	// Start of utility methods
	public void payRent1Util(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Utility mySpace = (Utility) spaces.get(newPosition);
		int rent1 = utilityRent1();
		if (myMoney > rent1) {
			myMoney = myMoney - rent1;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		    int spaceOwnerMoney = spaceOwner.getMoney();
			spaceOwnerMoney += rent1;
			StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent1 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");   
		}
		else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	     }

	public void payRent2Util(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Utility mySpace = (Utility) spaces.get(newPosition);
		int rent2 = utilityRent2();
		if (myMoney > rent2) {
			myMoney = myMoney - rent2;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
			// getting the owner of the space and his money and then adding the rent to it
			Player spaceOwner = mySpace.getOwner();
		   int spaceOwnerMoney = spaceOwner.getMoney();
		   spaceOwnerMoney += rent2;
		   StdOut.println(spaceOwner.getName() + " " + "has collected: " + rent2 + "" + "& now has: " + spaceOwnerMoney + "" + "left!!");
		}
		else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
		 }

	public void payMortgageUtil(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Utility mySpace = (Utility) spaces.get(newPosition);
		int mortgage = mySpace.getMortgage();
		if (myMoney > mortgage) {
			myMoney = myMoney - mortgage;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");
		}
	}

	public void buyUtility(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		int newPosition = this.getPosition();
		Utility mySpace = (Utility) spaces.get(newPosition);
		int utilityValue = mySpace.getValue();
		if (myMoney > utilityValue) {
			myMoney = myMoney - utilityValue;
			this.money = myMoney;
			mySpace.setOwner(this);
			mySpace.setIsItOwned(true);
			numOfUtilities++;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!"
					+ "owns :" + numOfUtilities + " utilities");
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");
		}
	}

	// End of the utility menus
	
	// pay taxes spaces
	public void payStampDuty(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		if (myMoney > 1000000) {
			myMoney = myMoney - 1000000;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	}

	public void payIncomeTax(ArrayList<BoardSpace> spaces) {
		int myMoney = this.getMoney();
		if (myMoney > 2000000) {
			myMoney = myMoney - 2000000;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	}

	
	//passGo
	public void passGo(ArrayList<BoardSpace> spaces){
		int myMoney=this.getMoney();
		myMoney = myMoney + 2000000;
		this.money = myMoney;
	}
	// start of chance cards methods

	public void goToJail(ArrayList<BoardSpace> spaces) {
		this.position = 10;
		StdOut.println(spaces.get(getPosition()).getName());
	}

	public void pickChanceRosscommon(ArrayList<BoardSpace> spaces) {
		StdOut.println("Advance To Roscommon");
		this.position = 39;
		StdOut.println("Your are now on" + ""
				+ spaces.get(getPosition()).getName());
	}

	public void pickChanceSchoolFees(ArrayList<BoardSpace> spaces) {
		StdOut.println("Private School Fees Pay E1.5M");
		int myMoney = this.getMoney();
		if (myMoney >= 1500000) {
			myMoney = myMoney - 1500000;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		}else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	}

	public void pickChanceGoBack3Spaces(ArrayList<BoardSpace> spaces) {
		StdOut.println("Rush Hour Traffic, Go Back 3 spaces");
		this.position = this.position - 3;
		StdOut.println("Your are now on" + " "
				+ spaces.get(getPosition()).getName());
	}

	public void pickChanceGetoutofJail(ArrayList<BoardSpace> spaces) {

		setJailCardOwned(true);
		numOfJailCards++;
		StdOut.println("GET OUT OF JAIL FREE card. This card may be kept until needed or sold.");
		StdOut.println(this.name + numOfJailCards
				+ "Get out of jail free cards");
	}

	public void pickChanceSellShares(ArrayList<BoardSpace> spaces) {
		StdOut.println("Sell your shares for a profit Collect E1M");
		int myMoney = this.getMoney();
		myMoney = myMoney + 1000000;
		this.money = myMoney;
		StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
	}

	public void pickChanceTyrone(ArrayList<BoardSpace> spaces) {
		StdOut.println("Advance To Tyrone, If you pass GO collect E2.M");
		if (position >= 12) {
			int myMoney = this.getMoney();
			myMoney = myMoney + 2000000;
			this.money = myMoney;
			this.position = 11;
			StdOut.println("Your are now on" + " "
					+ spaces.get(getPosition()).getName());
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		} else {
			this.position = 11;
			StdOut.println("Your are now on" + " "
					+ spaces.get(getPosition()).getName());
		}
	}

	public void pickChanceAdvanceToGo(ArrayList<BoardSpace> spaces) {
		StdOut.println("Advance To GO");
		int myMoney = this.getMoney();
		myMoney = myMoney + 2000000;
		this.money = myMoney;
		this.position = 0;
		StdOut.println("Your are now on" + " "
				+ spaces.get(getPosition()).getName());
		StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
	}

	public void pickChanceOffaly(ArrayList<BoardSpace> spaces) {
		StdOut.println("Advance To Offaly, If you pass GO collect E2.M");
		if (position >= 25) {
			int myMoney = this.getMoney();
			myMoney = myMoney + 2000000;
			this.money = myMoney;
			this.position = 24;
			StdOut.println("Your are now on" + " "
					+ spaces.get(getPosition()).getName());
			StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
		} else {
			this.position = 24;
			StdOut.println("Your are now on" + " "
					+ spaces.get(getPosition()).getName());
		}
	}

	// community chest cards
	public void pickCommunityAllIreland(ArrayList<BoardSpace> spaces) {
		StdOut.println("You win tickets to a sold out All-Ireland final and sell for a huge profit. Collect E200K");
		int myMoney = this.getMoney();
		myMoney = myMoney + 200000;
		this.money = myMoney;
		StdOut.println(this.name + " " + "now has :" + myMoney + "left!!");
	}

	public void pickCommunityDonegal(ArrayList<BoardSpace> spaces) {
		StdOut.println("Pay E500k for a 5-star weekend spa break in Donegal");
		int myMoney = this.getMoney();
		if (myMoney >= 500000) {
			myMoney = myMoney - 500000;
			this.money = myMoney;
			StdOut.println(this.name + " " + "now has: " + myMoney + " left!!");
		} else {
			StdOut.println(this.name+ " does not have enough money left for this!!");this.money = 0;
		}
	}

	public void pickCommunityCharterHelicopter(ArrayList<BoardSpace> spaces) {
		StdOut.println("Collect E1M profits for chartering your private helicopter.");
		int myMoney = this.getMoney();
		myMoney = myMoney + 1000000;
		this.money = myMoney;
		StdOut.println(this.name + " " + "now has: " + myMoney + " left!!");
	}

	public void pickCommunityInsuranceClaim(ArrayList<BoardSpace> spaces) {
		StdOut.println("Your car insurance claim is settled. Collect E250k");
		int myMoney = this.getMoney();
		myMoney = myMoney + 250000;
		this.money = myMoney;
		StdOut.println(this.name + " " + "now has: " + myMoney + " left!!");
	}

	public void pickCommunityGoToJail(ArrayList<BoardSpace> spaces) {
		StdOut.println("You are investigated for identity fraud. "
				+ "Go to jail. Move directly to jail. Do not pass go. Do not collect $2M");
		if (position >= 11) {
			int myMoney = this.getMoney();
			myMoney = myMoney + 0;
			this.money = myMoney;
			this.position = 10;
			StdOut.println("Your are now in" + " "
					+ spaces.get(getPosition()).getName());

		} else {
			this.position = 10;
			StdOut.println("Your are now in" + " "
					+ spaces.get(getPosition()).getName());
		}
	}

	public void pickCommunityAdvanceToGo(ArrayList<BoardSpace> spaces) {
		StdOut.println("Advance to GO");
		int myMoney = this.getMoney();
		myMoney = myMoney + 2000000;
		this.money = myMoney;
		StdOut.println(this.name + " " + "now has: " + myMoney + " left!!");
	}

	public void pickCommunityWestmeath(ArrayList<BoardSpace> spaces) {
		StdOut.println("Go back to Westmeath");
		this.position = 1;
		StdOut.println("Your are now on" + " "
				+ spaces.get(getPosition()).getName());
	}

	public void pickCommunityHolidayHome(ArrayList<BoardSpace> spaces) {
		StdOut.println("Your colleagues hire your holiday home for a week. Collect E100k from each player");
		int myMoney = this.getMoney();
		myMoney = myMoney + 100000 * getPlayers().size(); // times how many are
															// playing
		this.money = myMoney;
		StdOut.println(this.name + " " + "now has: " + myMoney + " left!!");
	}

	public void pickCommunityGetOutOfJail(ArrayList<BoardSpace> spaces) {
		setJailCardOwned(true);
		numOfJailCards++;
		StdOut.println("GET OUT OF JAIL FREE card. This card may be kept until needed or sold.");
		StdOut.println(this.name + numOfJailCards
				+ "Get out of jail free cards");
	}

	// End of Community Chest cards

	public void move(int moves) {
		this.position = (this.position + moves) % 40;
	}

	public String toString() {
		return "name" + name + ", money" + money + ", position"
				+ position + ", token" + token + ", numOfHotels"
				+ numOfHotels + ", numOfApartments=" + numOfApartments
				+ ", numOfUtilities=" + numOfUtilities + ", numOfCounties"
				+ numOfCounties + ", numOfProvinces=" + numOfProvinces;
	}

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 * This class controls the game of monopoly.
 */
public class GamePlay {

	protected ArrayList<CommunityChest> comChest;
	protected ArrayList<BoardSpace> spaces;
	protected ArrayList<Player> players;
	protected ArrayList<ChanceCards> cardsChance;
	Random randomNum = new Random();
	private int dice1;
	private int dice2;
	private int diceTotal;
	private int aPlayer;
	private int aChanceCard;
	private int aComChestCard;
	private int newBid;

	public GamePlay() {
		players = new ArrayList<Player>();
		randomNum = new Random();
		spaces = new ArrayList<BoardSpace>();
		cardsChance = new ArrayList<ChanceCards>();
		comChest = new ArrayList<CommunityChest>();

		cardsChance.add(new ChanceCards("Advance to roscommon"));
		cardsChance.add(new ChanceCards("Pay private school fees"));
		cardsChance.add(new ChanceCards("Rush hour traffic, go back three spaces"));
		cardsChance.add(new ChanceCards("Get out of jail free card. This card may be kept until needed or sold"));
		cardsChance.add(new ChanceCards("Sell your shares for a profit Collect $1M"));
		cardsChance.add(new ChanceCards("Advance to Tyrone, if you pass GO  collect $2 M"));
		cardsChance.add(new ChanceCards("Get out of jail free card. This card may be kept until needed or sold"));
		cardsChance.add(new ChanceCards("Advance to go"));
		cardsChance.add(new ChanceCards("Advance to Offaly, if you pass GO  collect $2 M"));
		comChest.add(new CommunityChest("You win tickets to a sold out All-Ireland final and sell for a huge profit. Collect $200K"));
		comChest.add(new CommunityChest("Pay $500k for a 5-star weekend spa break in Donegal"));
		comChest.add(new CommunityChest("Collect $1M profits for chartering your private helicopter."));
		comChest.add(new CommunityChest("Your car insurance claim is settled. Collect $250k"));
		comChest.add(new CommunityChest("You are investigated for identity fraud. Go to jail. Move directly to jail. Do not pass go. Do not collect $2M"));
		comChest.add(new CommunityChest("Advance to GO"));
		comChest.add(new CommunityChest("Go back to Westmeath"));
		comChest.add(new CommunityChest("Your colleagues hire your holiday home for a week. Collect $100k from each player."));
		comChest.add(new CommunityChest("GET OUT OF JAIL FREE card. This card may be kept until needed or sold."));
	}

	// main method
	public static void main(String[] argvs) {
		GamePlay app = new GamePlay();
		app.run();
	}

	public void setcommchest(ArrayList<CommunityChest> commchest) {
		spaces = new ArrayList<BoardSpace>();
	}
	public ArrayList<CommunityChest> getcomchest() {
		return comChest;
	}
	public void setSpaces(ArrayList<BoardSpace> spaces) {
		spaces = new ArrayList<BoardSpace>();
	}
	public ArrayList<BoardSpace> getSpaces() {
		return spaces;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		players = new ArrayList<Player>();
	}
	public void setcardsChance(ArrayList<ChanceCards> cardsChance) {
		cardsChance = new ArrayList<ChanceCards>();
	}
	public ArrayList<ChanceCards> getcardsChance() {
		return cardsChance;
	}
	public Random getRandomNum() {
		return randomNum;
	}
	public void setRandomNum(Random randomNum) {
		this.randomNum = randomNum;
	}
	
	// The dice method
	public int dice() {
		int doublesThrown = 0;
		dice1 = (int) (Math.random() * 6) + 1;
		dice2 = (int) (Math.random() * 6) + 1;
		diceTotal = dice1 + dice2;
		StdOut.println("Dice one rolled : " + dice1 + " and Dice two rolled : "+ dice2);
		StdOut.println("Total rolled : " + diceTotal);
		StdOut.println("Move " + diceTotal + " spaces");
		{
			if (dice1 == 1 && dice2 == 1 || dice1 == 2 && dice2 == 2
					|| dice1 == 3 && dice2 == 3 || dice1 == 4 && dice2 == 4
					|| dice1 == 5 && dice2 == 5 || dice1 == 6 && dice2 == 6) {
				doublesThrown = doublesThrown + 1;
				StdOut.println("You rolled a double! Roll again!");
				dice();
				if (doublesThrown == 3)
				{
					players.get(aPlayer).goToJail(spaces);
				}
			}
			return diceTotal;
		}
	}

	public void play() {

		if (players.size() > 0) {
			Player currentPlayer = players.get(aPlayer);
			int currentPosition = currentPlayer.getPosition();
			currentPlayer.move(dice());
			int newPosition = currentPlayer.getPosition();
			StdOut.println(currentPlayer.getName() + ": You have moved onto: "
			+ spaces.get(newPosition).getName() + "\n");
			if (newPosition < currentPosition) {
				currentPlayer.passGo(spaces);
				StdOut.println(currentPlayer.getName()
						+ " has Passed go! you collect 2 million!" + "& now has: " + currentPlayer.getMoney());
			}
			BoardSpace mySpace = spaces.get(newPosition);
			if (mySpace instanceof County && mySpace.getIsItOwned() == true && mySpace.getOwner() == currentPlayer) {
				StdOut.println("The details of this county are : " + mySpace);
			 myCountyOptions();// if I own this county
			} else if (mySpace instanceof County && mySpace.getIsItOwned() == true && mySpace.getOwner() != currentPlayer) {
				StdOut.println("The details of this county are : " + mySpace);
				anOwnedCountyOptions(); // if someone else owns this county
			} else if (mySpace instanceof County && mySpace.getIsItOwned() == false) {
				StdOut.println("The details of this county are : " + mySpace);
				unOwnedCountyOptions(); // if nobody owns this county
				} else if (mySpace instanceof Province && mySpace.getIsItOwned() == true && mySpace.getOwner() == currentPlayer) {
				StdOut.println("The details of this province are : " + mySpace);
                myProvinceOptions(); // if i own this province
			} else if (mySpace instanceof Province && mySpace.getIsItOwned() == true && mySpace.getOwner() != currentPlayer) {
				StdOut.println("The details of this province are : " + mySpace);
				anOwnedProvinceOptions(); // if someone else owns this province
			} else if (mySpace instanceof Province && mySpace.getIsItOwned() == false) {
				StdOut.println("The details of this province are : "+ mySpace);
				unOwnedProvinceOptions() ;// if nobody owns this province
			} else if (mySpace instanceof Utility && mySpace.getIsItOwned() == true && mySpace.getOwner() == currentPlayer) {
				StdOut.println("The details of this utility are : " + mySpace);
				myUtilityOptions(); // if i own this utility
			} else if (mySpace instanceof Utility && mySpace.getIsItOwned() == true && mySpace.getOwner() != currentPlayer) {
				StdOut.println("The details of this utility are : " + mySpace);
                anOwnedUtilityOptions(); //if someone else owns the utility
	    	} else if (mySpace instanceof Utility && mySpace.getIsItOwned() == false) {
				StdOut.println("The details of this utility are : " + mySpace);
                 UnOwnedUtilityOptions(); // if i own the utility
		    } else if (mySpace == spaces.get(2) || mySpace == spaces.get(17)
					|| mySpace == spaces.get(33)) {
				pickCommunityChest();
			} else if (mySpace == spaces.get(7) || mySpace == spaces.get(22)
					|| mySpace == spaces.get(36)) {
				pickChance();
			} else if (mySpace == spaces.get(30)) {
				currentPlayer.goToJail(spaces);
			} else if (mySpace == spaces.get(10)) {
				StdOut.println("Visiting jail!!");
			} else if (mySpace == spaces.get(4)) {
				StdOut.println("Landed on Income Tax! Pay 2 million euros");
				currentPlayer.payIncomeTax(spaces);
			} else if (mySpace == spaces.get(38)) {
				StdOut.println("Landed on Stamp duty! Pay 1 million euros");
				currentPlayer.payStampDuty(spaces);}
			if (aPlayer == players.size() - 1) {
				aPlayer = 0;
			} else {
				aPlayer++;
			}
			if (aPlayer == 0) {
				stopGameOptions();
			}
			if (currentPlayer.getMoney() <= 0) {
				players.remove(currentPlayer);
				StdOut.println(currentPlayer.getName()
						+ " does not have any money left!!- GAMEOVER!! YOU'RE BANKRUPT");
			}
			if (players.size() == 1) {
				StdOut.println("Congratulations! You are the last player left! You win!");		
				System.exit(0);
			}
		}		
	}
	
	// Add the players
	public void addPlayer() {
		if (players.size() <= 4) {
			StdOut.println("Player name: ");
			String player1Name = StdIn.readString();
			StdOut.println("Select a token: eg...car, hat, bus, dog : ");
			String token = StdIn.readString();
			Player player = new Player(player1Name, token);
			players.add(player);
		} else {
			StdOut.println("Max 4 players allowed!");
		}
	}

	private void listSpacesInfo() {
		if (spaces.size() > 0) {
			int i = 0;
			for (i = 0; i < spaces.size(); i++) {
				StdOut.println(i + ":" + spaces.get(i));
			}
		} else {
			StdOut.print("No spaces, please add a space first" + "\n");
		}
	}
	
	public void showPlayerInfo() {
		if (players.size() > 0) {
			for (int i = 0; i < players.size(); i++) {
				Player currentPlayer = players.get(i);
				int myMoney = currentPlayer.getMoney();
				String name = currentPlayer.getName();
				String token = currentPlayer.getToken();
				int position = currentPlayer.getPosition();
				boolean jailCardOwned = currentPlayer.getJailCardOwned();
				StdOut.println( name + " "
						+ "your position is : " + position
						+ "  your token is :" + token + " " + "and you have :"
						+ myMoney + " left!" + "Jail cards owned " + jailCardOwned + " " );
			   StdOut.println(name + "owns :"); currentPlayer.showPlayersSpaces(spaces);
			}
		} else {
			StdOut.println("No players yet!");
		}
	}

// auction for the board spaces
	public void auction(int aPlayer) {
		Player landedPlayer = players.get(aPlayer);
		int maxBid = 0;
		int newBid = 0;
		for (int i = 0; i < players.size(); i++) {
			Player currentPlayer= players.get(i);
			StdOut.println("do you want to bid for this space (y/n)?");
			String decision = StdIn.readString();
			if (decision.contains("y")) {
				StdOut.println("Please enter your maximum bid...");
				newBid = StdIn.readInt();
				if (newBid > maxBid) {
					maxBid = newBid;
					int position = landedPlayer.getPosition();
					BoardSpace mySpace =  spaces.get(position);
					mySpace.setOwner(currentPlayer);
					mySpace.setIsItOwned(true);
					StdOut.println(currentPlayer.getName() + "  you are the higest bidder" + "and you own: "+ mySpace.getName());
				}
			}
			else StdOut.println("move on nobody wants to buy this space");
			
		}

	}
	// picking one random chance card calling method
	public void pickChance() {
		Player currentPlayer = players.get(aPlayer);
		if (cardsChance.size() > 0) {
			StdOut.println("you have landed on chance! your card is : ");
			Collections.shuffle(cardsChance);
			ChanceCards oneCard = cardsChance.get(aChanceCard);
			if (oneCard == cardsChance.get(0)) {
				currentPlayer.pickChanceRosscommon(spaces);
			} else if (oneCard == cardsChance.get(1)) {
				currentPlayer.pickChanceSchoolFees(spaces);
			} else if (oneCard == cardsChance.get(2)) {
				currentPlayer.pickChanceGoBack3Spaces(spaces);
			} else if (oneCard == cardsChance.get(3)) {
				currentPlayer.pickChanceGetoutofJail(spaces);
			} else if (oneCard == cardsChance.get(4)) {
				currentPlayer.pickChanceSellShares(spaces);
			} else if (oneCard == cardsChance.get(5)) {
				currentPlayer.pickChanceTyrone(spaces);
			} else if (oneCard == cardsChance.get(6)) {
				currentPlayer.pickChanceGetoutofJail(spaces);
			} else if (oneCard == cardsChance.get(7)) {
				currentPlayer.pickChanceAdvanceToGo(spaces);
			} else if (oneCard == cardsChance.get(8)) {
				currentPlayer.pickChanceOffaly(spaces);
			}
		}
	}

	// picking one random community chest card and calling that method
	public void pickCommunityChest() {
		Player currentPlayer = players.get(aPlayer);
		if (comChest.size() > 0) {
			StdOut.println("You have landed on Communuty Chest! Your card is : ");
			Collections.shuffle(comChest);
			CommunityChest oneCard = comChest.get(aComChestCard);
			if (oneCard == comChest.get(0)) {
				currentPlayer.pickCommunityAllIreland(spaces);
			} else if (oneCard == comChest.get(1)) {
				currentPlayer.pickCommunityDonegal(spaces);
			} else if (oneCard == comChest.get(2)) {
				currentPlayer.pickCommunityCharterHelicopter(spaces);
			} else if (oneCard == comChest.get(3)) {
				currentPlayer.pickCommunityInsuranceClaim(spaces);
			} else if (oneCard == comChest.get(4)) {
				currentPlayer.pickCommunityGoToJail(spaces);
			} else if (oneCard == comChest.get(5)) {
				currentPlayer.pickCommunityAdvanceToGo(spaces);
			} else if (oneCard == comChest.get(6)) {
				currentPlayer.pickCommunityWestmeath(spaces);
			} else if (oneCard == comChest.get(7)) {
				currentPlayer.pickCommunityHolidayHome(spaces);
			} else if (oneCard == comChest.get(8)) {
				currentPlayer.pickCommunityGetOutOfJail(spaces);
			}
		}
	}

	
	// user menus
	private int mainMenu() {
		StdOut.println("Welcome to Monopoly Administrator Menu! Please select an option"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) Play Monopoly");
		StdOut.println("2) list Board spaces details");
		StdOut.println("3) Load Board space details");
		StdOut.println("4) save Board space details");
		StdOut.println("0) Exit");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
	}

	public void run() {
		load();
		int option = mainMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				runGame();
				break;
			case 2:
				listSpacesInfo();
				break;
			case 3:
				load();
				break;
			case 4:
				save();
				break;
			default:
				break;
			}
			option = mainMenu();
		}
		StdOut.println("Exiting... bye");
	}

	public void runGame() {
		int option = beginGameMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				addPlayer();
				break;
			case 2: if (players.size() >= 2) {
				inGamePlay();
			} else {
				StdOut.println("please add at least 2 players to play!");
			}
				break;
			case 3:
				listSpacesInfo();
				break;
			default:
				break;
			}
			option = beginGameMenu();
		}
		StdOut.println("Ending game... bye");
	}

	private int beginGameMenu() {
		StdOut.println("Welcome to Monopoly menu to begin and add players to the game! Please select an option"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) Add players to the game");
		StdOut.println("2) begin game!");
		StdOut.println("3) list Board spaces info");
		StdOut.println("0) Exit");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
	}

	// The in game menus
	private int gamePlay() {
		StdOut.println("Welcome to Monopoly gameplay menu! Please select an option"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) Roll the dices!");
		StdOut.println("2) Show each players information");
		StdOut.println("3) list Board spaces info");
		StdOut.println("0) Exit");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
	}

	public void inGamePlay() {
		int option = gamePlay();
		while (option != 0) {

			switch (option) {
			case 1:
				play();
				break;
			case 2:
				showPlayerInfo();
				break;
			case 3:
				listSpacesInfo();
				break;
			default:
				break;
			}
			option = gamePlay();
		}
		StdOut.println("Exiting... bye");
	}

	// menus for when the current player lands on a space that is an instance of county
	// county space menu for when someone else owns the county the player has landed on.
	public int anOwnedCountyMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a county!"
				+ "\n"
				+ "This county is owned by another player so pay rent amount required!!"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) pay rent for site only");
		StdOut.println("2) pay rent for 1 apartment");
		StdOut.println("3) pay rent for 2 apartments");
		StdOut.println("4) pay rent for 3 apartments");
		StdOut.println("5) pay rent for 4 apartments");
		StdOut.println("6) pay rent for hotel");
		StdOut.println("0) return for next players go ==>>" + "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void anOwnedCountyOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = anOwnedCountyMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				currentPlayer.payRentSite(spaces);
				break;
			case 2:
				currentPlayer.payRent1(spaces);
				break;
			case 3:
				currentPlayer.payRent2(spaces);
				break;
			case 4:
				currentPlayer.payRent3(spaces);
				break;
			case 5:
				currentPlayer.payRent4(spaces);
				break;
			case 6:
				currentPlayer.payHotelRent(spaces);
				break;
			default:
				break;
			}
			option = anOwnedCountyMenu();
		}
		StdOut.println("Next players dice roll..." + "\n"
				+ "===========================>>>>");	}

	// end

	// menu for if the current player owns the county they have landed on
	public int myCountyMenu() {
		StdOut.println(" Welcome to the monopoly menu for your county!" + "\n");
		StdOut.println("1) Build an apartment");
		StdOut.println("2) Build a hotel");
		StdOut.println("3) mortgage property");
		StdOut.println("0) return for next players go ==>>" + "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void myCountyOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = myCountyMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				currentPlayer.buildApartment(spaces);
				break;
			case 2:
				if (currentPlayer.getNumOfApartments() >= 4) {
					currentPlayer.buildHotel(spaces);
				} else {
					StdOut.println("you need to own at least 4 apartments to buy a hotel!"
							+ "\n"
							+ " please select another option"
							+ "\n"
							+ "====>>>>>>>>>>");
				} case 9:
				currentPlayer.payMortgage(spaces);
				break;
			default:
				break;
			}
			option = myCountyMenu();
		}
		StdOut.println("Next players dice roll...");
	}// end

	// menu for if the county is not owned by anyone.
	public int unOwnedCountyMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a county!"
				+ "\n"
				+ "This county is not owned, select one of the following options"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) Buy this county for its value");
		StdOut.println("2) Send this county to auction");
		StdOut.println("0) return for next players go ==>>" + "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void unOwnedCountyOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = unOwnedCountyMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				currentPlayer.buyCounty(spaces);
				break;
			case 2:
				auction(aPlayer);
			default:
				break;
			}
			option = myCountyMenu();
		}
		StdOut.println("Next players dice roll..." + "\n"
				+ "===========================>>>>");
	} // end
		// end of the county space menus

	// menus for when the current player lands on a space that is an instance of province
	// menu for if the current player owns the province they have landed on
	public int myProvinceMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a province!"
				+ "\n"
				+ "select which option for your province"
				+ "\n"
				+ "=========================>>>>");
		StdOut.println("1) mortgage the province");
		StdOut.println("0) return for next players go after youve selected!==>>"
				+ "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void myProvinceOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = myProvinceMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				currentPlayer.payMortgageProv(spaces);
			default: 
				break;
			}
			option = myProvinceMenu();
		}
		StdOut.println("Next players dice roll...");
	} // end of my province menus

	// Province space menus for when someone else owns the province the player has landed on.
	public int anOwnedProvinceMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a province!"
				+ "\n"
				+ "This province is owned by another player so pay rent amount required!!"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) pay rent for 1 province only");
		StdOut.println("2) pay rent for 2 provinces");
		StdOut.println("3) pay rent for 3 provinces");
		StdOut.println("4) pay rent for 4 provinces");
		StdOut.println("0) return for next players go after youve selected!==>>"
				+ "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void anOwnedProvinceOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = anOwnedProvinceMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				currentPlayer.payRent1Prov(spaces);
				break;
			case 2:
				currentPlayer.payRent2Prov(spaces);
				break;
			case 3:
				currentPlayer.payRent3Prov(spaces);
				break;
			case 4:
				currentPlayer.payRent4Prov(spaces);
				break;
			case 5:
				currentPlayer.payMortgageProv(spaces);
				break;
			default:
				break;
			}
			option = anOwnedProvinceMenu();
		}
		StdOut.println("Next players dice roll...");
	} // end of province menus for when another player owns the province the player has landed on

	// menus for if the province the current player has landed on is not owned by anyone.
	public int unOwnedProvinceMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a province!"
				+ "\n"
				+ "This province is not owned, select one of the following options"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) Buy the province for its value");
		StdOut.println("2) Send this province to auction");
		StdOut.println("0) return for next players go ==>>" + "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void unOwnedProvinceOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = unOwnedProvinceMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				currentPlayer.buyProvince(spaces);
				break;
			case 2:
				auction(aPlayer);
			default:
				break;
			}
			option = myProvinceMenu();
		}
		StdOut.println("Next players dice roll..." + "\n"
				+ "===========================>>>>");
	} // end
	// end of the province space menus

	// menus for when the current player lands on a space that is an instance of utility
	// menu for when the current player owns the utility they have landed on
	public int myUtilityMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a utility!"
				+ "\n"
				+ "You own this Utility! select an option for your utility or do nothing and wait for your next turn"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) mortgage your utility");
		StdOut.println("0) Return for next players go after youve selected!==>>"
				+ "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void myUtilityOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = myUtilityMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				currentPlayer.payMortgageUtil(spaces);
				break;
			default:
				break;
			}
			option = myUtilityMenu();
		}
		StdOut.println("Next players dice roll...");
	} // end of the my utility menus

	// start of menus for when another player other than the current player owns
	// the utility they have landed on.
	public int anOwnedUtilityMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a utility!"
				+ "\n"
				+ "Another player owns this utility so pay the required rent to the owner!!"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) Pay rent for 1 utility only");
		StdOut.println("2) Pay rent for 2 utilities");
		StdOut.println("0) Return for next players go after youve selected!==>>"
				+ "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void anOwnedUtilityOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = anOwnedUtilityMenu();
		while (option != 0) {

			switch (option) {
			case 3:
				currentPlayer.payRent1Util(spaces);
				break;
			case 2:
				currentPlayer.payRent2Util(spaces);
				break;
			default:
				break;
			}
			option = anOwnedUtilityMenu();
		}
		StdOut.println("Next players dice roll...");
	} // end of the menus for when another player owns the utility the current
		// player lands on
		// start of menus for when another player other than the current player
		// owns the utility they have landed on.

	public int UnOwnedUtilityMenu() {
		StdOut.println(" Welcome to the monopoly menu for landing on a utility!"
				+ "\n"
				+ "Another Nobody owns this utility so please select an option!"
				+ "\n" + "=========================>>>>");
		StdOut.println("1) Buy this utility");
		StdOut.println("2) Send this utilityto auction");
		StdOut.println("0) Return for next players go after youve selected!==>>"
				+ "\n");
		int option = StdIn.readInt();
		return option;
	}

	public void UnOwnedUtilityOptions() {
		Player currentPlayer = players.get(aPlayer);
		int option = UnOwnedUtilityMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				currentPlayer.buyUtility(spaces);
				break;
			case 2:
				auction(aPlayer);
			default:
				break;
			}
			option = myUtilityMenu();
		}
		StdOut.println("Next players dice roll...");
	} // end of the menus for when no player owns the utility the current player
		// lands on

	//menu for giving each player the option of ending the game after each full round of dice rolls
	public int stopGameMenu() {
		StdOut.println("Do you want to end the game now?");
		StdOut.println("1) No, continue playing");
		StdOut.println("0) Yes, stop the game");
		StdOut.println("=======================");
		int option = StdIn.readInt();
		return option;
	}

	public void stopGameOptions() {
		int option = stopGameMenu();
		while (option != 1) {
			switch (option) {
			case 0:
				gameOver();
				break;
			default:
				break;
			}
			option = stopGameMenu();
		}
		StdOut.println("Continue playing the game...");
		StdOut.println("============================");
	}

	public void gameOver() {
		StdOut.println("The Game has ended!");
		StdOut.println("===================");
		System.exit(0);
	}
	// end

	// methods for calculating utility rent called from player class
	public int utilityRent1() {
		int i = 10000 * dice() * 4;
		return i;
	}

	public int utilityRent2() {
		int i = 10000 * dice() * 10;
		return i;
	}

	// end of all of the utility menus

	private void save() {
		StdStream.saveToFile(spaces, "myBoardSpaces.xml");
	}

	private void load() {
		spaces = (ArrayList<BoardSpace>) StdStream
				.readFromFile("myBoardSpaces.xml");
	}
}

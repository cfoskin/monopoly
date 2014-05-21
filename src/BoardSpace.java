import java.util.ArrayList;
/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 * This is the superClass of which type the Arraylist of boardSpaces are.
 */
public class BoardSpace {

	protected String name;
	protected String colour;
	protected Player owner;
	protected boolean isItOwned;

	

	public BoardSpace(String name, String colour, Player owner, boolean isItOwned) {
		this.name= name;
		this.colour=colour;
		this.owner=owner;
		this.isItOwned= false;
		
	}

	public boolean getIsItOwned() {
		return isItOwned;
	}

	public void setIsItOwned(boolean isItOwned) {
		this.isItOwned = isItOwned;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player player) {
		this.owner=player;
	}
	public String toString() {
		return "name=" + name + ", colour=" + colour  + "is it owned = " + isItOwned + "owned by :" + owner;
	}

	
}
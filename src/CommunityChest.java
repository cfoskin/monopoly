/**
 * @author Colum Foskin, Conor Burke, Richard Harpur.
 * @version 1.
 *
 */
public class CommunityChest {
private String name;

	public CommunityChest(String name) {
		this.name= name;
		
	}

	public String getName() {
	 return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return  name;
	}
}

package lab7;

import javafx.scene.input.KeyCode;

/*Written by Jacob Burton on 10/20/2018
This is the Player. The player should move around and collect trash.
*/

public class Player
{
	private String truckerName = "";
	private String imageFile = "";
	private int trash = 0;
	
	public Player(String truckerName, String imageFile, int trash) {
		
		super();
		this.truckerName = truckerName;
		this.imageFile = imageFile;
		trash = trash;
	}
	
	public String toString()
	{
		return "UserName: " + truckerName + "\n" + "Trash collected: " + trash;
	}

	public String getTruckerName() {
		return truckerName;
	}

	public int getTrash() {
		return trash;
	}
}

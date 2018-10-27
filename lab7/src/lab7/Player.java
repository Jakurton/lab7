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
	
	private static int playerX = 0;
	private static int playerY = 0;
	
	public Player(String truckerName, String imageFile, int trash)
	{
		
		super();
		this.truckerName = truckerName;
		this.imageFile = imageFile;
		this.trash = trash;
	}
	
	public static int getPlayerX()
	{
		return playerX;
	}

	public void setPlayerX(int playerX) {
		Player.playerX = playerX;
	}

	public void setPlayerY(int playerY) {
		Player.playerY = playerY;
	}

	public static int getPlayerY()
	{
		return playerY;
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
	
	public void movePlayer(KeyCode keyCode)
	{
		 if (keyCode == KeyCode.A)
		    {
		        setPlayerX(playerX - 10);
		    }
		   
		    else if (keyCode == KeyCode.S)
		    {
		        setPlayerX(playerY + 10);

		    }
		    
		    else if (keyCode == KeyCode.W)
		    {
		        setPlayerX(playerY - 10);

		    }
		    
		    else if (keyCode == KeyCode.D)
		    {
		        setPlayerX(playerX + 10);

		    }
	}
}


package lab7;

/*Written by Jacob Burton on 10/20/2018 (Collision detection code from Professor Cassens)
 This class is the enemy. The enemy will be a raccoon that attacks the trash truck and causes the player to lose.
 */

public class Enemy {
	//Enemy should chase Player around scene made in Game class
	
	private String raccoonName = "";
	private String imageFile = "";
	private boolean feeding = false;
	
	public Enemy(String name, String imageFile, boolean isDead) {
		
		super();
		this.raccoonName = name;
		this.imageFile = imageFile;
		this.feeding = isDead;
	}

	public String getRaccoonName() {
		return raccoonName;
	}

	public String getImageFile() {
		return imageFile;
	}
	
	public String toString()
	{
		return "Raccoon's name: " + raccoonName + "\n" + "Has eaten from the trash truck: " + feeding;
	}
	/*private boolean areRectsColliding(int r1TopLeftX, int r1BottomRightX,int r1TopLeftY, int r1BottomRightY, int r2TopLeftX,int r2BottomRightX, int r2TopLeftY, int r2BottomRightY)
	{
	if (r1TopLeftX < r2BottomRightX && r1BottomRightX > r2TopLeftX&& r1TopLeftY < r2BottomRightY && r1BottomRightY > r2TopLeftY)
	{
	return true;
	}
	else
	{
	return false;
	}
	}*/
}

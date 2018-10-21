package lab7;

public class Driver {
	public static void main(String[] args)
	{		
		Player player = new Player("Jacob", "file:/lab7/src/trashtruck.jpg", 0);
		
		System.out.println(player);
		
		Enemy enemy = new Enemy("Steven", "file:/lab7/src/raccoon.jpg", false);
		
		System.out.println(enemy);
	}
}

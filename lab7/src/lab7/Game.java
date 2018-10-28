package lab7;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 Written by Jacob Burton on 10/20/2018
 This is the game scene/stage. Just the playing field.
 */

public class Game extends Application
{
	
	// Need to be global scope to be accessed by other methods.
	private ArrayList<TrashCan> trashCoords = new ArrayList<TrashCan>();
	private static int items = 2;
	
	private FlowPane gameRoot = new FlowPane();

	private Enemy enemy = new Enemy(900,550,"raccoon.jpg");

	private Image enemyimg = new Image("File:"+enemy.getImg());
	private ImageView enemyView = new ImageView(enemyimg);
   
	public static void main(String[] args)
	{
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		String truckerName = "";
		String imageFile = "";
		int trash = 0;
		int playerX = 0;
		int playerY = 0;
		
		Image wasdImage = new Image("file:wasd.jpg");
		ImageView wasdView = new ImageView(wasdImage);
	    wasdView.setPreserveRatio(true);  
	    wasdView.setFitHeight(125); 

		primaryStage.setTitle("GarbageCollector");
		
		FlowPane pane = new FlowPane();
				
		Button startButton = new Button("Start");
		
		pane.getChildren().addAll(startButton, wasdView);
		
		Group root = new Group(pane);
		
		Player player = new Player(truckerName, imageFile, trash, playerX, playerY);
		
		

		startButton.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent startClick)
			{

				Image playerImage = new Image("file:trashtruck.jpg");
				ImageView playerView = new ImageView(playerImage);
				playerView.setFitWidth(120); 
				playerView.setPreserveRatio(true);
			    playerView.setManaged(false);

				enemyView.setFitWidth(50);
				enemyView.setPreserveRatio(true);
				enemyView.setManaged(false);
				enemyView.setLayoutX(enemy.getpX());
				enemyView.setLayoutY(enemy.getpY());
				enemyView.toFront();
				
				gameRoot.getChildren().add(playerView);
				gameRoot.getChildren().add(enemyView);

				addTrashCans();

				Scene sceneStart = new Scene(gameRoot, 1000, 600);
				
				sceneStart.setOnKeyPressed(a -> {
				   player.movePlayer(a.getCode());
				   playerView.setLayoutY(player.getPlayerY());
				   playerView.setLayoutX(player.getPlayerX());
				});
				
				// Adds trash cans
				Stage gameStage = (Stage) ((Node) startClick.getSource()).getScene().getWindow();											
				gameStage.setScene(sceneStart);
				gameStage.show();
				
			}
			
		});
		
		Scene sceneInitial = new Scene(root, 1000, 600);
		primaryStage.setScene(sceneInitial);
		primaryStage.show();
	}
	
	private void addTrashCans(){
		
		// Just adds two at first. We increment this every level.
		for (int i = 0; i < items; i++) {
			Random r = new Random();
			int randomY = r.nextInt((560) + 1);
			int randomX = r.nextInt((960) + 1);
			TrashCan newCan = new TrashCan(randomX, randomY);
			trashCoords.add(newCan);
			Image can = new Image(trashCoords.get(i).getImg());
		    ImageView canView = new ImageView(can);
		    canView.setFitWidth(50);
		    canView.setPreserveRatio(true);
		    canView.setManaged(false);
		    canView.setLayoutX(trashCoords.get(i).getX());
		    canView.setLayoutY(trashCoords.get(i).getY());
			gameRoot.getChildren().add(canView);
		}
	}
}

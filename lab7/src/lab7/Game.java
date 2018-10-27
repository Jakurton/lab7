package lab7;

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
				
				playerView.setLayoutX(player.getPlayerX());	//This doesn't work 
				playerView.setLayoutY(player.getPlayerY());	// "		"
				
				playerView.setFitWidth(120); 
				playerView.setPreserveRatio(true);
				
				FlowPane gameRoot = new FlowPane();
				
				gameRoot.getChildren().add(playerView);
					
				Scene sceneStart = new Scene(gameRoot, 500, 500);
				Stage gameStage = (Stage) ((Node) startClick.getSource()).getScene().getWindow();
				
				sceneStart.setOnKeyPressed(a -> {
				   player.movePlayer(a.getCode());
				});
				
																
				gameStage.setScene(sceneStart);
				gameStage.show();
				
			}
			
		});
		
		Scene sceneInitial = new Scene(root, 500, 500);
		primaryStage.setScene(sceneInitial);
		primaryStage.show();
	}
}

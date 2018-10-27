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
	
	private int playerX = Player.getPlayerX();
	private int playerY = Player.getPlayerY();
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{

		Image wasdImage = new Image("file:/lab7/src/wasd.jpg");
		ImageView wasdView = new ImageView(wasdImage);
	    wasdView.setPreserveRatio(true);  

		primaryStage.setTitle("GarbageCollector");
		
		FlowPane pane = new FlowPane();
				
		Button startButton = new Button("Start");
		
		pane.getChildren().addAll(startButton, wasdView);
		
		Group root = new Group(pane);
		
		Player player = new Player("Jacob", "file:/lab7/src/trashtruck.jpg", 0);
		
		startButton.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent startClick)
			{
				Image playerImage = new Image("file:/src/trashtruck.jpg");
				ImageView playerView = new ImageView(playerImage);
				
				System.out.println("Image loading error: " + playerImage.isError());
				
				playerView.setX(playerX); 
				playerView.setY(playerY);
				playerView.setPreserveRatio(true);
				
				StackPane gameRoot = new StackPane();
				
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

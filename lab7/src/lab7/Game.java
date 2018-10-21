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

		Image image = new Image("file:/lab7/src/wasd.jpg");
		
		ImageView imageView = new ImageView(image);
		
		primaryStage.setTitle("GarbageCollector");
		
		FlowPane pane = new FlowPane();
				
		Button startButton = new Button("Start");
		
		pane.getChildren().addAll(startButton, imageView);
		
		Group root = new Group(pane);
		
		startButton.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent startClick)
			{
				StackPane gameRoot = new StackPane();
												
				Scene sceneStart = new Scene(gameRoot, 500, 500);
				Stage gameStage = (Stage) ((Node) startClick.getSource()).getScene().getWindow();
				
				sceneStart.setOnKeyPressed(a -> {
				    if (a.getCode() == KeyCode.A)
				    {
				        System.out.println("A pressed");
				    }
				   
				    else if (a.getCode() == KeyCode.S)
				    {
				    	System.out.println("S pressed");
				    }
				    
				    else if (a.getCode() == KeyCode.W)
				    {
				    	System.out.println("W pressed");
				    }
				    
				    else if (a.getCode() == KeyCode.D)
				    {
				    	System.out.println("D pressed");
				    }
				    
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

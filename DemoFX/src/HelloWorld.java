import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloWorld extends Application{
	
    //Practice with a GUI
    public void start(Stage primaryStage) {
        
	//Create two buttons
	Button btn = new Button();
        
	//Set the text of the buttons
	btn.setText("Print 'Hello World!'");
		
	//Have button 1 print to the console what is in the text field
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        //Create a box for putting in your GUI elements
  	VBox root = new VBox();
        root.getChildren().addAll(btn);
        root.setAlignment(Pos.CENTER);
        
        //Create a scene in put in your box 
        Scene scene = new Scene(root, 350, 500);
        
		//Set up the scene, including the title
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}

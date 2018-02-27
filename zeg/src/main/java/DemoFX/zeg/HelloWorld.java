package DemoFX.zeg;
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
        
	//Create a button
	Button btn = new Button();
        
	//Set the text of the button
	btn.setText("Print 'Hello World!'");
		
	//Have the button print "Hello World"
        btn.setOnAction(event -> {
       
                System.out.println("Hello World!");
           
        });
        
        //Create a box for putting in your GUI elements
  	VBox root = new VBox();
        root.getChildren().addAll(btn);
        root.setAlignment(Pos.CENTER);
        
        //Create a scene to put the box into 
        Scene scene = new Scene(root, 350, 500);
        
	//Set up the scene, including the title
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}

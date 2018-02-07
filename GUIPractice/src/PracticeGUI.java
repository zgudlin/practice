
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PracticeGUI extends Application{
	
//Practice with a GUI
    public void start(Stage primaryStage) {
        
	//Create two buttons
	Button btn = new Button();
        Button btn2 = new Button();
        
	//Set the text of the buttons
	btn.setText("Print the Text");
	btn2.setText("Change the Font Color");
        
	//Create label and set the color of the text
	Label lbl = new Label("Click the button!");
        lbl.setTextFill(Color.CHARTREUSE);
        
	//Create a text field
	TextField text = new TextField();
        text.setMaxWidth(200);
        btn.setMaxWidth(200);
		
	//Have button 1 print to the console what is in the text field
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println(text.getText());
            }
        });
		
	//Have button two change the label's text color 
        btn2.setOnAction (new EventHandler<ActionEvent>() {
          
  	    @Override
            public void handle(ActionEvent event) {
               lbl.setTextFill(Color.CRIMSON);
            }     
    });
        
        /*StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(text);
        root.getChildren().add(lbl);*/
        
	//Create a box for putting in your GUI elements
	VBox root = new VBox();
        root.getChildren().addAll(text,lbl,btn,btn2);
        root.setAlignment(Pos.CENTER);
        
	//Create a scene in put in your box 
        Scene scene = new Scene(root, 350, 500);
        
	//Set up the scene, including the title
        primaryStage.setTitle("Practice Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	public static void main(String[] args) {
		
		//Launch the program
		launch(args);
	}

}

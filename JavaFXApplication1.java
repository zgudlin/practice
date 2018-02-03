/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Zak
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Button btn2 = new Button();
        btn2.setText("Change the Font Color");
        Label lbl = new Label("Click the button!");
        lbl.setTextFill(Color.CHARTREUSE);
        TextField text = new TextField();
        text.setMaxWidth(200);
        btn.setText("Print the Text");
        btn.setMaxWidth(200);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println(text.getText());
            }
        });
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
        VBox root = new VBox();
        root.getChildren().addAll(text,lbl,btn,btn2);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 350, 500);
        
        primaryStage.setTitle("Practice Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

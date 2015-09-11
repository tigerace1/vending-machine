import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.*;
public class AlertWindow {
	private static boolean ans;
	public static boolean AlertBox(String title)
   {
	  
	   Stage window = new Stage();
	   window.setWidth(300);
	   Button button1 = new Button("Yes");
	   Button button2 = new Button("No");
	   Label label = new Label("Do you love me?");
	   label.setTextFill(Color.RED);
	   button1.setOnAction(e -> {ans=true;window.close();});
	   button2.setOnAction(e-> { 
	   ans = false;window.close();});
	   VBox box = new VBox();
	   box.getChildren().addAll(button1,label,button2);
	   box.setAlignment(Pos.CENTER);
	   window.setScene(new Scene(box));
	   window.showAndWait();
	   return ans;
   }
}

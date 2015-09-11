import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.*;
public class GraphInterface extends Application{
   Label a;
   Button button;
   ListView<String> list = new ListView<>();
   public static void main(String[] args){
	  launch(args);
  }

@Override
public void start(Stage primaryStage) throws Exception {
    FoodItem one = new FoodItem();
    one.readSoup();
	button = new Button("open");
	list.getItems().addAll(one.getSoup());
	button.setOnAction(e-> buttonClicked());
	VBox window = new VBox();
	window.getChildren().addAll(button);
	Scene scene = new Scene(window,300,200);
	primaryStage.setScene(scene);
	primaryStage.show();
  }

private void buttonClicked() {
	String message ="";
	String items;
	items = list.getSelectionModel().getSelectedItem();
	System.out.println(items);
}

}

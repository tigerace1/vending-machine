package Restaurant;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class AlertWindow {
  private String message="",category="";
  private TextField A,B,C,D;
  private TextArea New;
  private ChoiceBox<String> cate;
  private String food="";
  private Stage editWindow = new Stage();
  public void InforWindow(String newMessage)
  {
    message = newMessage;
	TextArea TA;
	Label label;
	Button button1;
	Button button2;
	Button button3;
	Stage window = new Stage();
	MenuInformation infor = new MenuInformation();
	window.setTitle("Chengen Li's restaurant");
	window.setWidth(370);
	window.setHeight(340);
	label = new Label("Food description");
	label.setTextFill(Color.RED);
	label.setFont(Font.font(20));
	label.setLayoutX(100);
	TA = new TextArea();
	TA.setPrefColumnCount(80);
	TA.setPrefRowCount(10);
	TA.setWrapText(true);
	TA.setLayoutY(40);
	TA.setMaxWidth(350);
	TA.setMaxHeight(320);
	TA.setFont(Font.font(14));
	button1 = new Button("OK");
	button2 = new Button("Cancel");
	button3 = new Button("Edit");
	button1.setFont(Font.font(14));
	button2.setFont(Font.font(14));
	button3.setFont(Font.font(14));
	button1.setLayoutY(260);
	button2.setLayoutY(260);
	button1.setLayoutX(220);
	button2.setLayoutX(280);
	button3.setLayoutX(40);
	button3.setLayoutY(260);
	button3.setTextFill(Color.ORANGERED);
	TA.setEditable(false);
	TA.setText(infor.DisplayInfor(message));
	button1.setOnAction(e -> window.close());
	button2.setOnAction(e-> window.close());
	button3.setOnAction(e-> EditWindow());
	Pane box = new Pane();
	box.getChildren().addAll(button1,button2,button3,TA,label);
	window.setScene(new Scene(box));
	window.showAndWait();
  }
  public void EditWindow()
  {
	 Pane editPane = new Pane();
	 setEditWindow();
	 editWindow.setTitle("Edit window");
	 editWindow.initModality(Modality.APPLICATION_MODAL);
	 Button one = new Button("Submit");
	 Button two = new Button("Cancel");
	 one.setOnAction(e->{category=cate.getValue();ConfirmEditWindow();});
	 two.setOnAction(e->editWindow.close());
	 Label first = new Label("Name:");
	 Label second = new Label("Prize:");
	 Label third = new Label("Quailty:");
	 Label fourth = new Label("Size:");
	 Label last = new Label("Edit Pane");
	 last.setLayoutX(200);
	 last.setTextFill(Color.ORANGERED);
	 last.setFont(Font.font(20));
	 one.setLayoutY(296);
	 one.setLayoutX(320);
	 two.setLayoutY(296);
	 two.setLayoutX(400);
	 one.setTextFill(Color.BLUEVIOLET);
	 first.setLayoutX(15);
	 first.setLayoutY(50);
	 second.setLayoutX(260);
	 second.setLayoutY(50);
	 third.setLayoutX(15);
	 third.setLayoutY(80);
	 fourth.setLayoutX(260);
	 fourth.setLayoutY(80);
	 editPane.getChildren().addAll(cate,one,two,first,second,third,fourth,A,B,C,D,New,last);
	 editWindow.setScene(new Scene(editPane));
	 editWindow.showAndWait();
  }
  private void setEditWindow()
  {
	 String[] ary = message.split("  ");
	 String name = ary[0];
	 String prize = ary[1];
	 String quality = ary[2];
	 String size = ary[3];
	 A = new TextField();
	 B = new TextField();
	 C = new TextField();
	 D = new TextField();
	 New = new TextArea();
	 cate = new ChoiceBox<>();
	 New.setWrapText(true);
	 New.setText(MenuInformation.getLine());
	 A.setText(name);
	 B.setText(prize);
	 C.setText(quality);
	 D.setText(size);
	 A.setLayoutX(70);
	 A.setLayoutY(50);
	 B.setLayoutX(310);
	 B.setLayoutY(50);
	 C.setLayoutX(70);
	 C.setLayoutY(80);
	 D.setLayoutX(310);
	 D.setLayoutY(80);
	 New.setLayoutX(15);
	 New.setLayoutY(120);
	 cate.setLayoutY(296);
	 cate.setLayoutX(50);
	 cate.setMinWidth(150);
	 editWindow.setHeight(380);
	 editWindow.setWidth(500);
	 FoodItem menu = new FoodItem();
	 menu.readFoodCategory();
	 for(int i=0;i<menu.getcategoryCount();i++)
	    cate.getItems().addAll( menu.getFoodCate().getData(i));
	 cate.setStyle("-fx-background-color: white;");
	 cate.setValue(menu.getFoodCate().getData(0));
  }
  private void ConfirmEditWindow() {
	Stage win = new Stage();
	Pane box = new Pane();
	Label text = new Label("Are you Sure the changes?");
	Button o = new Button("Yes");
	Button x = new Button("No");
	win.setTitle("Confirm window");
	win.initModality(Modality.APPLICATION_MODAL);
	win.setWidth(250);
	win.setHeight(150);
	o.setLayoutX(80);
	o.setLayoutY(70);
	x.setLayoutX(130);
	x.setLayoutY(70);
	x.setOnAction(e->win.close());
	o.setOnAction(e->{Edit();win.close();editWindow.close();});
	text.setLayoutX(10);
	text.setLayoutY(30);
	text.setFont(Font.font(18));
	text.setTextFill(Color.RED);
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
   }
   private void Edit() {
     Editor edit = new Editor();
     String name = A.getText();
     String prize = B.getText();
     String quality = C.getText();
     String size = D.getText();
     String description = New.getText();
     edit.EditMenu(category,name,prize,quality,size,description,message);
     New.setText(edit.getDescription());
   }
   void ExceptionWindow()
   {
 	 Stage Exceptionwin = new Stage();
 	 Pane box = new Pane();
 	 Label text = new Label("Null Value");
 	 Button o = new Button("OK");
 	 Exceptionwin.setTitle("Exception window");
 	 Exceptionwin.initModality(Modality.APPLICATION_MODAL);
 	 Exceptionwin.setWidth(200);
 	 Exceptionwin.setHeight(150);
 	 o.setLayoutX(80);
 	 o.setLayoutY(70);
 	 o.setOnAction(e->Exceptionwin.close());
 	 text.setLayoutX(30);
 	 text.setLayoutY(30);
 	 text.setFont(Font.font(18));
 	 text.setTextFill(Color.RED);
 	 box.getChildren().addAll(o,text);
 	 Exceptionwin.setScene(new Scene(box));
 	 Exceptionwin.showAndWait();
   }
   void EditFoodCateWindow() 
   {
	 Stage FoodCateWin = new Stage();
	 Pane box = new Pane();
	 Label text = new Label("Food Categorise Window");
	 text.setFont(Font.font(16));
	 Button a = new Button("Adding food categorise");
	 Button ed = new Button("Editing food categorise");
	 Button d = new Button("Deleting food categorise");
	 Button c = new Button("Close");
	 a.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	 ed.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	 d.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	 c.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	 a.setTextFill(Color.CORNFLOWERBLUE);
	 ed.setTextFill(Color.CORNFLOWERBLUE);
	 d.setTextFill(Color.CORNFLOWERBLUE);
	 c.setTextFill(Color.CORNFLOWERBLUE);
	 FoodCateWin.setWidth(200);
	 FoodCateWin.setHeight(250);
	 a.setLayoutX(20);
	 a.setLayoutY(45);
	 ed.setLayoutX(20);
	 ed.setLayoutY(90);
	 d.setLayoutX(20);
	 d.setLayoutY(130);
	 c.setLayoutX(20);
	 c.setLayoutY(170);
	 a.setMinWidth(145);
	 ed.setMinWidth(145);
	 d.setMinWidth(140);
	 c.setMinWidth(145);
     a.setOnAction(e->addFoodCate());
	 ed.setOnAction(e->editFoodCate());
	 d.setOnAction(e->delFoodCate());
	 c.setOnAction(e->FoodCateWin.close());
	 text.setLayoutX(15);
	 text.setFont(Font.font(14));
	 text.setTextFill(Color.BLUE);
	 box.getChildren().addAll(a,ed,d,c,text);
	 FoodCateWin.setScene(new Scene(box));
	 FoodCateWin.showAndWait();
   }
   private void editFoodCate() 
   {
	 Stage EditFoodCateWin = new Stage();
	 Pane box = new Pane();
	 Button o = new Button("OK");
	 Button c = new Button("Select");
	 Button E = new Button("Exit");
	 Label label = new Label("Editing window");
	 label.setTextFill(Color.BLUEVIOLET);
	 TextField text = new TextField();
	 ChoiceBox<String> cate = new ChoiceBox<>();
	 FoodItem edit = new  FoodItem();
	 edit.readFoodCategory();
	 for(int i = 0; i<edit.getcategoryCount();i++)
		 cate.getItems().add((String) edit.getFoodCate().getData(i));
	 EditFoodCateWin.setTitle("Edit Category window");
	 EditFoodCateWin.initModality(Modality.APPLICATION_MODAL);
	 EditFoodCateWin.setWidth(200);
	 EditFoodCateWin.setHeight(200);
	 o.setLayoutX(130);
	 o.setLayoutY(75);
	 c.setLayoutX(130);
	 c.setLayoutY(35);
	 cate.setLayoutX(10);
	 cate.setLayoutY(35);
	 cate.setMinWidth(100);
	 E.setLayoutX(80);
	 E.setLayoutY(120);
	 text.setLayoutX(10);
	 text.setLayoutY(75);
	 text.setMaxWidth(100);
	 label.setLayoutX(30);
	 label.setFont(Font.font(16));
     c.setOnAction(e->{
     try{food = cate.getValue();
      if(food.equals(""))
    	throw new Exception();
     }catch(Exception R){
     ExceptionWindow();}text.setText(food);});
	 o.setOnAction(e->confirmEditCate(text.getText()));
	 E.setOnAction(e->EditFoodCateWin.close());
	 box.getChildren().addAll(o,c,E,cate,text,label);
	 EditFoodCateWin.setScene(new Scene(box));
	 EditFoodCateWin.showAndWait();	 
   }
   private void confirmEditCate(String message) 
   {
	 Stage win = new Stage();
	 Pane box = new Pane();
	 Editor editCa = new Editor();
	 Label text = new Label("Are you Sure the changes?");
	 Button o = new Button("Yes");
	 Button x = new Button("No");
	 win.setTitle("Confirm window");
	 win.initModality(Modality.APPLICATION_MODAL);
	 win.setWidth(250);
	 win.setHeight(150);
	 o.setLayoutX(80);
	 o.setLayoutY(70);
	 x.setLayoutX(130);
	 x.setLayoutY(70);
	 x.setOnAction(e->win.close());
	 o.setOnAction(e->{editCa.EditCate(message,food);win.close();});
	 text.setLayoutX(10);
	 text.setLayoutY(30);
	 text.setFont(Font.font(18));
	 text.setTextFill(Color.BLUEVIOLET);
	 box.getChildren().addAll(o,x,text);
	 win.setScene(new Scene(box));
	 win.showAndWait();
   }
   private void delFoodCate() 
   {
	 Stage DelFoodCateWin = new Stage();
	 Pane box = new Pane();
	 Button c = new Button("Delete");
	 Button E = new Button("Exit");
	 Label label = new Label("Editing window");
	 label.setTextFill(Color.BLUEVIOLET);
	 ChoiceBox<String> cate = new ChoiceBox<>();
	 FoodItem edit = new  FoodItem();
	 edit.readFoodCategory();
	 for(int i = 0; i<edit.getcategoryCount();i++)
		cate.getItems().add((String) edit.getFoodCate().getData(i));
	 DelFoodCateWin.setTitle("Delete Category window");
	 DelFoodCateWin.initModality(Modality.APPLICATION_MODAL);
	 DelFoodCateWin.setWidth(200);
	 DelFoodCateWin.setHeight(150);
	 c.setLayoutX(120);
     c.setLayoutY(35);
     E.setLayoutX(75);
	 E.setLayoutY(80);
	 cate.setLayoutX(15);
	 cate.setLayoutY(35);
	 cate.setMinWidth(100);
	 label.setLayoutX(40);
	 label.setFont(Font.font(16));
	 c.setOnAction(e->{
	 try{food = cate.getValue();
	   if(food.equals(""))
	     throw new Exception();
	 }catch(Exception R){
	   ExceptionWindow();}confirmDelCateWindow(food);});
	 E.setOnAction(e->DelFoodCateWin.close());
	 box.getChildren().addAll(c,E,cate,label);
	 DelFoodCateWin.setScene(new Scene(box));
	 DelFoodCateWin.showAndWait();	 
   }
   private void confirmDelCateWindow(String message) 
   {
	 Stage win = new Stage();
	 Pane box = new Pane();
	 EditorTwo delCa = new EditorTwo();
	 Label text = new Label("Are you Sure to delete?");
	 Button o = new Button("Yes");
	 Button x = new Button("No");
	 win.setTitle("Confirm window");
     win.initModality(Modality.APPLICATION_MODAL);
	 win.setWidth(250);
	 win.setHeight(150);
	 o.setLayoutX(80);
	 o.setLayoutY(70);
	 x.setLayoutX(130);
	 x.setLayoutY(70);
	 x.setOnAction(e->win.close());
	 o.setOnAction(e->{delCa.DelCate(message);win.close();});
	 text.setLayoutX(20);
	 text.setLayoutY(30);
	 text.setFont(Font.font(18));
	 text.setTextFill(Color.BLUEVIOLET);
	 box.getChildren().addAll(o,x,text);
	 win.setScene(new Scene(box));
	 win.showAndWait();
   }
   private void addFoodCate() 
   {
	Stage AddFoodCateWin = new Stage();
	Pane box = new Pane();
	Button o = new Button("Add");
	Button E = new Button("Exit");
	Label label = new Label("Editing window");
	label.setTextFill(Color.BLUEVIOLET);
	TextField text = new TextField();
	FoodItem add = new FoodItem();
	add.readFoodCategory();
	for(int i = 0; i<add.getcategoryCount();i++){ 
	    String ca = (String) add.getFoodCate().getData(i);}
	AddFoodCateWin.setTitle("Add Category window");
	AddFoodCateWin.initModality(Modality.APPLICATION_MODAL);
	AddFoodCateWin.setWidth(200);
	AddFoodCateWin.setHeight(150);
	o.setLayoutX(120);
	o.setLayoutY(35);
	E.setLayoutX(75);
	E.setLayoutY(80);
	text.setLayoutX(15);
	text.setLayoutY(35);
	text.setMaxWidth(100);
	label.setLayoutX(40);
	label.setFont(Font.font(16));
	o.setOnAction(e->{
	try{food = text.getText();
	  if(food.equals(""))
		throw new Exception();
	}catch(Exception R){
	  ExceptionWindow();}confirmAddCateWindow(food);});
	E.setOnAction(e->AddFoodCateWin.close());
	box.getChildren().addAll(o,E,text,label);
	AddFoodCateWin.setScene(new Scene(box));
	AddFoodCateWin.showAndWait();	 
  }
  private void confirmAddCateWindow(String newFood) 
  {
    Stage win = new Stage();
	Pane box = new Pane();
	EditorThree addCa = new EditorThree();
	Label text = new Label("Are you Sure to add?");
	Button o = new Button("Yes");
	Button x = new Button("No");
	win.setTitle("Confirm window");
	win.initModality(Modality.APPLICATION_MODAL);
    win.setWidth(250);
	win.setHeight(150);
	o.setLayoutX(80);
	o.setLayoutY(70);
	x.setLayoutX(130);
	x.setLayoutY(70);
	x.setOnAction(e->win.close());
	o.setOnAction(e->{addCa.DelCate(newFood);win.close();});
	text.setLayoutX(30);
	text.setLayoutY(30);
	text.setFont(Font.font(18));
	text.setTextFill(Color.BLUEVIOLET);
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
  }
}

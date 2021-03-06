package Restaurant;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class AlertWindow {
  private String message,category;
  private TextField A,B,C,D;
  private TextArea New;
  private ComboBox<String> cate;
  private String food;
  private Stage editWindow;
  public AlertWindow()
  {
	 message = "";
	 category = "";
	 A = new TextField();
	 B = new TextField();
	 C = new TextField();
	 D = new TextField();
	 New = new TextArea();
	 cate = new ComboBox<>();
	 food = "";
     editWindow = new Stage();	 
  }
  private void setMessage(String newMessage)
  {
	  this.message = newMessage;
  }
  private void setCategory(String newCategory)
  {
	  this.category = newCategory;
  }
  public void inforWindow(String newMessage,String cate)
  {
    setMessage(newMessage);
    setCategory(cate);
    MenuInformation infor = new MenuInformation();
	TextArea TA;
	Label label;
	Button button1;
	Button button2;
	Button button3;
	Stage window = new Stage();
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
	TA.setText(infor.displayInfor(message));
	button1.setOnAction(e -> window.close());
	button2.setOnAction(e-> window.close());
	button3.setOnAction(e-> editWindow());
	Pane box = new Pane();
	box.getChildren().addAll(button1,button2,button3,TA,label);
	box.setStyle("-fx-background-color: lightyellow");
	window.setScene(new Scene(box));
	window.showAndWait();
  }
  public void editWindow()
  {
	 Pane editPane = new Pane();
	 editPane.setStyle("-fx-background-color: lightyellow");
	 setEditWindow();
	 editWindow.setTitle("Edit window");
	 Button one = new Button("Submit");
	 Button two = new Button("Cancel");
	 one.setOnAction(e->{category=cate.getValue();confirmEditWindow();});
	 two.setOnAction(e->editWindow.close());
	 Label first = new Label("Name:");
	 Label second = new Label("Price:");
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
	 cate.setEditable(true);
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
	 for(int i=0;i<menu.getCategoryCount();i++)
	    cate.getItems().addAll( menu.getFoodCate().getData(i));
	 cate.setStyle("-fx-background-color: white;");
	 cate.setValue(category);
  }
  private void confirmEditWindow() {
	Stage win = new Stage();
	Pane box = new Pane();
	box.setStyle("-fx-background-color: lightyellow");
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
	o.setOnAction(e->{Edit();save();;win.close();editWindow.close();});
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
     String newLine = category+";"+A.getText()+";"+B.getText()+";"+C.getText()+";"+D.getText()+";"+New.getText();
     edit.EditMenu(newLine,message);
     New.setText(edit.getDescription());
   }
   void exceptionWindow()
   {
 	 Stage Exceptionwin = new Stage();
 	 Pane box = new Pane();
 	 box.setStyle("-fx-background-color: lightyellow");
 	 Label text = new Label("Null Value");
 	 Button o = new Button("OK");
 	 Exceptionwin.setTitle("Exception window");
 	 Exceptionwin.initModality(Modality.APPLICATION_MODAL);
 	 Exceptionwin.setWidth(200);
 	 Exceptionwin.setHeight(150);
 	 o.setLayoutX(80);
 	 o.setLayoutY(70);
 	 o.setOnAction(e->Exceptionwin.close());
 	 text.setLayoutX(50);
 	 text.setLayoutY(30);
 	 text.setFont(Font.font(18));
 	 text.setTextFill(Color.RED);
 	 box.getChildren().addAll(o,text);
 	 Exceptionwin.setScene(new Scene(box));
 	 Exceptionwin.showAndWait();
   }
   void editFoodCateWindow() 
   {
	 Stage FoodCateWin = new Stage();
	 Pane box = new Pane();
	 box.setStyle("-fx-background-color: lightyellow");
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
	 box.setStyle("-fx-background-color: lightyellow");
	 Button o = new Button("OK");
	 Button E = new Button("Exit");
	 Label label = new Label("Editing window");
	 label.setTextFill(Color.BLUEVIOLET);
	 TextField text = new TextField();
	 ComboBox<String> cate = new ComboBox<>();
	 cate.setEditable(true);
	 FoodItem edit = new  FoodItem();
	 edit.readFoodCategory();
	 for(int i = 0; i<edit.getCategoryCount();i++)
		 cate.getItems().add((String) edit.getFoodCate().getData(i));
	 EditFoodCateWin.setTitle("Edit Category window");
	 EditFoodCateWin.initModality(Modality.APPLICATION_MODAL);
	 EditFoodCateWin.setWidth(200);
	 EditFoodCateWin.setHeight(200);
	 o.setLayoutX(130);
	 o.setLayoutY(75);
	 cate.setLayoutX(8);
	 cate.setLayoutY(35);
	 cate.setMinWidth(120);
	 cate.setMaxWidth(120);
	 E.setLayoutX(80);
	 E.setLayoutY(120);
	 text.setLayoutX(10);
	 text.setLayoutY(75);
	 text.setMaxWidth(100);
	 label.setLayoutX(30);
	 label.setFont(Font.font(16));
     cate.getSelectionModel().selectedIndexProperty().addListener((v,oldValue,newValue)->{
     try{food = cate.getValue();
      if(newValue.equals(""))
    	throw new Exception();
     }catch(Exception R){
     exceptionWindow();}text.setText(food);});
	 o.setOnAction(e->confirmEditCate(text.getText()));
	 E.setOnAction(e->EditFoodCateWin.close());
	 box.getChildren().addAll(o,E,cate,text,label);
	 EditFoodCateWin.setScene(new Scene(box));
	 EditFoodCateWin.showAndWait();	 
   }
   private void confirmEditCate(String message) 
   {
	 Stage win = new Stage();
	 Pane box = new Pane();
	 box.setStyle("-fx-background-color: lightyellow");
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
	 o.setOnAction(e->{editCa.EditCate(message,food);
	 save();win.close();});
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
	 box.setStyle("-fx-background-color: lightyellow");
	 Button c = new Button("Delete");
	 Button E = new Button("Exit");
	 Label label = new Label("Editing window");
	 label.setTextFill(Color.BLUEVIOLET);
	 ComboBox<String> cate = new ComboBox<>();
	 FoodItem edit = new  FoodItem();
	 edit.readFoodCategory();
	 for(int i = 0; i<edit.getCategoryCount();i++)
		cate.getItems().add((String) edit.getFoodCate().getData(i));
	 DelFoodCateWin.setTitle("Delete Category window");
	 DelFoodCateWin.initModality(Modality.APPLICATION_MODAL);
	 DelFoodCateWin.setWidth(200);
	 DelFoodCateWin.setHeight(150);
	 c.setLayoutX(70);
     c.setLayoutY(80);
     E.setLayoutX(130);
	 E.setLayoutY(80);
	 cate.setLayoutX(23);
	 cate.setLayoutY(35);
	 cate.setMaxWidth(120);
	 cate.setEditable(true);
	 label.setLayoutX(40);
	 label.setFont(Font.font(16));
	 c.setOnAction(e->{
	 try{food = cate.getValue();
	   if(food.equals(""))
	     throw new Exception();
	  confirmDelCateWindow(food);
	 }catch(Exception R){
	   exceptionWindow();}});
	 E.setOnAction(e->DelFoodCateWin.close());
	 box.getChildren().addAll(c,E,cate,label);
	 DelFoodCateWin.setScene(new Scene(box));
	 DelFoodCateWin.showAndWait();	 
   }
   private void confirmDelCateWindow(String message) 
   {
	 Stage win = new Stage();
	 Pane box = new Pane();
	 box.setStyle("-fx-background-color: lightyellow");
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
	 o.setOnAction(e->{delCa.delCate(message);
	 save();win.close();});
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
	box.setStyle("-fx-background-color: lightyellow");
	Button o = new Button("Add");
	Button E = new Button("Exit");
	Label label = new Label("Adding window");
	label.setTextFill(Color.BLUEVIOLET);
	TextField text = new TextField();
	FoodItem add = new FoodItem();
	add.readFoodCategory();
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
	  exceptionWindow();}confirmAddCateWindow(food);});
	E.setOnAction(e->AddFoodCateWin.close());
	box.getChildren().addAll(o,E,text,label);
	AddFoodCateWin.setScene(new Scene(box));
	AddFoodCateWin.showAndWait();	 
  }
  private void confirmAddCateWindow(String newFood) 
  {
    Stage win = new Stage();
	Pane box = new Pane();
	box.setStyle("-fx-background-color: lightyellow");
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
	o.setOnAction(e->{addCa.addCate(newFood);
	addFood(newFood);save();win.close();});
	text.setLayoutX(30);
	text.setLayoutY(30);
	text.setFont(Font.font(18));
	text.setTextFill(Color.BLUEVIOLET);
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
  }
  public void save()
  {
	FoodItem save = new FoodItem();
	save.readFoodCategory();
	save.writeFoods();
	save.writeExcel();
  }
  private void addFood(String newFood) 
  {
	EditorThree addfood = new EditorThree();
	addfood.addMenu(newFood+";?;?;?;?;No Description");
  }
  public String getMessage()
  {
	  return message;
  }
  public String getCategory()
  {
	  return category;
  }
}

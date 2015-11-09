package Searching;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**A GUI class for displaying the menu*/
public class UserInterface extends Application{
  private Button button1,button2,button3;
  private Label title,empty,foods;
  private ListView<String> listAll;
  private BorderPane window;
  private Pane layout;
  private MenuBar menuBar;
  private Menu menu;
  private TextField Search;
  private FoodList<String> list;
  private FoodLL<String> link;
  private FoodItems food;
  private Stage primaryStage;
  private String message;
  public static void main(String[] args)
  {
	launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
	primaryStage = new Stage();
	this.primaryStage=primaryStage;
	this.primaryStage.setTitle("Chengen Li's restaurant");
	setLinkedList();
	setButton();
	setLabel();
	setTextField();
	setListView();
	setListAll();
	setMenu();
	message="";
	this.primaryStage.setOnCloseRequest(e->{
		if(list.getCount()!=food.getCount())
		  savingWindow();
	});
	window = new BorderPane();
	layout = new Pane();
	window.setStyle("-fx-background-color: black;");
	window.setTop(menuBar);
	window.setCenter(layout);
	layout.getChildren().addAll(button1,button2,button3,title,empty,listAll,Search,foods);
	button1.setOnAction(e->{
		if(Search.getText().trim().equals("")&&listAll.getSelectionModel().getSelectedItem()==null)
			setListAll();
		else if(listAll.getSelectionModel().getSelectedItem()!=null)
		  searching(listAll.getSelectionModel().getSelectedItem());
		else searching(Search.getText().trim());});
	listAll.setOnKeyPressed(e->{switch(e.getCode()){case ENTER:
		if(listAll.getSelectionModel().getSelectedItem()!=null)
		 searching(listAll.getSelectionModel().getSelectedItem());else
		 exceptionWindow();break;
	    default:
		break;}});
	button2.setOnAction(e->{deleteFood();setListAll();});
	button3.setOnAction(e->save());
	Scene scene = new Scene(window,360,490);
	this.primaryStage.setScene(scene);
	this.primaryStage.show();
  }
  private void savingWindow() 
  {
	Stage win = new Stage();
	win.setOnCloseRequest(e->win.close());
	Pane box = new Pane();
	box.setStyle("-fx-background-color: black");
	Label text = new Label("Do you want to save the changes?");
	Button o = new Button("Yes");
	Button x = new Button("No");
	o.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	x.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	win.setTitle("Confirm save window");
	win.initModality(Modality.APPLICATION_MODAL);
	win.setWidth(300);
	win.setHeight(150);
	o.setLayoutX(80);
	o.setLayoutY(70);
	x.setLayoutX(150);
	x.setLayoutY(70);
	x.setOnAction(e->{win.close();primaryStage.close();});
	o.setOnAction(e->{save();win.close();primaryStage.close();});
	text.setLayoutX(10);
	text.setLayoutY(30);
	text.setFont(Font.font(18));
	text.setTextFill(Color.GOLD);
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
   }
  /**setting the menu bar and the file menu*/
  private void setMenu()
  {
	menu = new Menu("_File");
	menu.setStyle("-fx-effect: dropshadow(one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	MenuItem add = new MenuItem("_Add foods");
	MenuItem save = new MenuItem("_Save");
	MenuItem exit = new MenuItem("_Exit");
	menu.getItems().addAll(add,save,exit);
	menuBar = new MenuBar();
	menuBar.getMenus().add(menu);
	menuBar.setStyle("-fx-background-color: gray;");
	add.setOnAction(e->{adding();setListAll();});
	save.setOnAction(e->save());
	exit.setOnAction(e->primaryStage.close());
  }
  /**set buttons*/
  private void setButton()
  {
	button1 = new Button("Search");
	button2 = new Button("-");
	button3 = new Button("save");
	button1.setLayoutY(425);
	button1.setLayoutX(270);
	button2.setLayoutY(35);
	button2.setLayoutX(332);
	button3.setLayoutY(35);
	button3.setLayoutX(290);
	button1.setFont(Font.font(14));
	button2.setFont(Font.font(12));
	button3.setFont(Font.font(12));
	button1.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	button2.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	button3.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
  }
  /**set labels*/
  private void setLabel()
  {
	title = new Label("Restaurant Menu");
	empty = new Label("Item not find");
	foods = new Label("Foods:");
	title.setLayoutX(80);
	title.setLayoutY(5);
	title.setTextFill(Color.GOLD);
	title.setFont(Font.font(24));
	empty.setLayoutX(80);
	empty.setLayoutY(140);
	empty.setFont(Font.font(24));
	empty.setTextFill(Color.GOLD);
	foods.setLayoutY(35);
	foods.setLayoutX(5);
	foods.setFont(Font.font(14));
	foods.setTextFill(Color.GOLD);
	title.setStyle("-fx-effect: dropshadow( one-pass-box , Gold , 14 , 0.0 , 10 , 0 );");
	empty.setStyle("-fx-effect: dropshadow( one-pass-box , Gold , 8 , 0.0 , 2 , 0 );");
	foods.setStyle("-fx-effect: dropshadow( one-pass-box , Gold , 8 , 0.0 , 2 , 0 );");
  }
  private void setTextField()
  {
	Search = new TextField();
	Search.setLayoutX(100);
	Search.setLayoutY(430);
	Search.setMinWidth(120);
	Search.setPromptText("Search foods");
	Search.setOnKeyPressed(e->{switch(e.getCode())
	{case ENTER:
		if(Search.getText().trim().equals(""))
			setListAll();
		else 
		 searching(Search.getText().trim()); break;
	 default:break;}});
	Search.textProperty().addListener(new ChangeListener<String>(){
		 @Override
		 public void changed(ObservableValue<? extends String> arg0, String oldV, String newV)
		 {
		   if(!(oldV.equals(newV))){
			 listAll.getItems().clear();
			for(int i=0;i<food.getCount();i++){
			  String line = link.Suggested(newV,i);
			  if(line!=null){
				listAll.getItems().add(setString(link.getData(i)));
			  }
			}
			if(listAll.getItems()==null)
			   listAll.setVisible(false);
		   }
		 }
	    }
		);
	Search.setStyle("-fx-effect: dropshadow( one-pass-box , Gold , 8 , 0.0 , 2 , 0 );-fx-background-color: lightyellow;");
  }
  private void setListView()
  {
    listAll = new ListView<>();
	listAll.setVisible(true);
	listAll.setLayoutY(60);
	listAll.setLayoutX(5);
	listAll.setMaxHeight(350);
	listAll.setMinWidth(350);
	listAll.setStyle("-fx-textfill-color: yellow;-fx-foreground-color: black;");
  }
  private void setListAll()
  {  
    listAll.getItems().clear();
    listAll.setVisible(false);
    link = new FoodLL<>();
    link.inOrderTree(list.getRoot());
    inOrder(list.getRoot()); 
	listAll.setVisible(true);
  }
  /**Using recursion to put the items from the tree into the list view*/
  private void inOrder(Node<String> root)
  {
	 if(root!=null)
	 {
	   inOrder(root.getLeft());
	   listAll.getItems().add((String)setString(root.getData()));
	   inOrder(root.getRight());
	 }
  }
  private String setString(Object data)
  {
	 String[] ary = ((String) data).split("  ");
	 return ary[0];
  }
  private void setLinkedList()
  {
    food = new FoodItems();
    list = new FoodList<>();
	link = new FoodLL<>();
	food.readFoods();
	list =food.getList();
	link=food.getLink();
  }
  /**add one food item into the restaurant menu*/
  private void adding() 
  {
	Stage addStage = new Stage();
	Pane addWin = new Pane();
	addWin.setStyle("-fx-background-color: black;");
	Label one = new Label("Food name:");
	Label two = new Label("Ingredents:");
	Button submit = new Button("Submit");
	Button exit = new Button("Exit");
    one.setTextFill(Color.GOLD);
	two.setTextFill(Color.GOLD);
	TextField name = new TextField();
	TextArea infor = new TextArea();
	name.setLayoutX(70);
	name.setLayoutY(10);
	infor.setLayoutX(5);
	infor.setLayoutY(60);
	infor.setMaxSize(230,150);
	one.setLayoutX(5);
	one.setLayoutY(10);
	two.setLayoutX(5);
	two.setLayoutY(40);
	submit.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	exit.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	submit.setLayoutX(120);
	submit.setLayoutY(220);
	exit.setLayoutX(200);
	exit.setLayoutY(220);
	name.setText(message);
	addWin.getChildren().addAll(one,two,name,infor,submit,exit);
	exit.setOnAction(e->addStage.close());
	submit.setOnAction(e->confirmAddingWindow(name.getText()+"  ("+infor.getText()+")"));
	submit.setOnKeyPressed(e->{switch(e.getCode()){case ENTER:
    confirmAddingWindow(name.getText()+"  ("+infor.getText()+")");
	break;default:break;}});
	Scene scene = new Scene(addWin,250,250);
	addStage.setScene(scene);
	addStage.showAndWait();
  }
  /**Confirming window for the use to make sure if his/she want to add*/
  private void confirmAddingWindow(String Message) 
  {
	Stage win = new Stage();
	Pane box = new Pane();
	box.setStyle("-fx-background-color: black");
	Label text = new Label("Are you Sure the changes?");
	Button o = new Button("Yes");
	Button x = new Button("No");
	o.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	x.setStyle("-fx-effect: dropshadow( one-pass-box , gold , 8 , 0.0 , 2 , 0 );-fx-background-color: gold;");
	win.setTitle("Confirm window");
	win.initModality(Modality.APPLICATION_MODAL);
	win.setWidth(250);
	win.setHeight(150);
	o.setLayoutX(80);
	o.setLayoutY(70);
	x.setLayoutX(150);
	x.setLayoutY(70);
	x.setOnAction(e->win.close());
	o.setOnAction(e->{list.bstAdd(Message);
	setListAll();win.close();});
	text.setLayoutX(10);
	text.setLayoutY(30);
	text.setFont(Font.font(18));
	text.setTextFill(Color.GOLD);
	o.setOnKeyPressed(e->{switch(e.getCode()){case ENTER:
	{list.bstAdd(Message);list.balance();setListAll();win.close();};break;
	default:break;}});
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
  }
  /**delete one food item from the linked list and menu*/
  private void deleteFood() 
  {
	String message="";
	message = listAll.getSelectionModel().getSelectedItem();
	try{
		if(message.equals(""))
		  throw new Exception("");
		String[]ary = message.split("  ");
		confirmDeleteWindow(ary[0]);
	}
	catch(Exception e)
	{
	   e.getMessage();
	   exceptionWindow();
	}
  }
  /**Confirming window for the use to make sure if he/she want to delete*/
  private void confirmDeleteWindow(String message) 
  {
	Stage win = new Stage();
	Pane box = new Pane();
	box.setStyle("-fx-background-color: black");
	Label text = new Label("Are you Sure you want to delete this food?");
	Button o = new Button("Yes");
	Button x = new Button("No");
	o.setStyle("-fx-background-color: gold");
	x.setStyle("-fx-background-color: gold");
	win.setTitle("Confirm window");
	win.initModality(Modality.APPLICATION_MODAL);
	win.setWidth(270);
	win.setHeight(150);
	o.setLayoutX(80);
	o.setLayoutY(70);
	x.setLayoutX(150);
	x.setLayoutY(70);
	x.setOnAction(e->win.close());
	o.setOnMouseClicked(e->{list.remove(message);
	setListAll();win.close();});
	text.setLayoutY(30);
	text.setLayoutX(8);
	text.setFont(Font.font(12));
	text.setTextFill(Color.GOLD);
	o.setOnKeyPressed(e->{switch(e.getCode()){case ENTER:
	list.remove(message);setListAll();win.close();break;
	default:break;}});
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
  }
  /**Allow user to search a food by its name*/
  private void searching(String food) 
  {
	String data = list.bstSearch(food);
	if(data==null){
	  listAll.setVisible(false);
	  suggestWindow(Search.getText().trim());
	}else{
      listAll.getItems().clear();
      listAll.getItems().add(data);
      listAll.setVisible(true);
    }
  }
  /**This window will shows up when the use search a item, which is
   * not exist in the list, and ask he/she if he/she want to add*/
  private void suggestWindow(String food)
  {
	message = food;
	Stage Exceptionwin = new Stage();
	Pane box = new Pane();
	box.setStyle("-fx-background-color: black");
	Label text = new Label("Item not found,\nDo you want to add this food");
	Button o = new Button("Yes");
	Button x = new Button("No");
	o.setStyle("-fx-background-color: gold");
	x.setStyle("-fx-background-color: gold");
	Exceptionwin.setTitle("Exception window");
	Exceptionwin.initModality(Modality.APPLICATION_MODAL);
	Exceptionwin.setWidth(350);
	Exceptionwin.setHeight(180);
	o.setLayoutX(200);
	o.setLayoutY(110);
	x.setLayoutX(280);
	x.setLayoutY(110);
	o.setOnAction(e->{adding();Exceptionwin.close();});
	x.setOnAction(e->Exceptionwin.close());
	text.setLayoutX(50);
	text.setLayoutY(30);
	text.setFont(Font.font(18));
	text.setTextFill(Color.GOLD);
	box.getChildren().addAll(o,x,text);
	Exceptionwin.setScene(new Scene(box));
	Exceptionwin.showAndWait();
  }
  /**Save the new food list into the text file*/
  private void save()
  {
	 FoodItems save = new FoodItems();
	 save.setFoodLink(link);
	 System.out.println(food.getCount());
	 System.out.println(list.getCount());
	 System.out.println(link.getCount());
	 food.setCount(link.getCount());
	 save.writeFoods();
  }
  /**this window will shows up when there is an exception*/
  private void exceptionWindow()
  {
	 Stage Exceptionwin = new Stage();
	 Pane box = new Pane();
	 box.setStyle("-fx-background-color: black");
	 Label text = new Label("Null Value");
	 Button o = new Button("OK");
	 o.setStyle("-fx-background-color: gold");
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
	 text.setTextFill(Color.GOLD);
	 box.getChildren().addAll(o,text);
	 Exceptionwin.setScene(new Scene(box));
	 Exceptionwin.showAndWait();
  }
 }

package Restaurant;
import LinkedList.FoodLL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class GraphInterface extends Application{
  private Button button1,button2,button3,button4,button5,button6,button7,button8;
  private Label title,B,C,D,E;
  private ComboBox<String> Search1;
  private BorderPane layout;
  private ListView<Object> listAll,listChoice;
  private Stage addWindow,stage;
  private Pane window;
  private FoodLL<String> foodList;
  private TextField Search2;
  public static void main(String[] args)
  {
	  launch(args);
  }
  public void start(Stage primaryStage) throws Exception {
    stage = new Stage();
    final Scene scene=null;
    stage.setTitle("Chengen Li's restaurant");
    setting(scene);
    button6.setOnAction(e->{listChoice.getItems().clear();
    listAll.getItems().clear();setMenu();
    setLinkedList();Searching(Search1);
    });
    stage.show();
  }
  private void setting(Scene scene)
  {
    window = new Pane();
    Pane win = new Pane();
	layout = new BorderPane();
	Search1 = new ComboBox<>();
	AlertWindow show = new AlertWindow();
	setLabel();
	setMenu();
	setButton();
	setListView();
	setLinkedList();
	setTextField();
	button1.setOnAction(e-> InformationWindow());
	button2.setOnAction(e->System.exit(0));
	button3.setOnAction(e-> {listAll.setVisible(false);
	listChoice.setVisible(true);Searching(Search1);});
	button4.setOnAction(e->addingWindow());
	button5.setOnAction(e->DeleteFood());
	button7.setOnAction(e->show.EditFoodCateWindow());
	button8.setOnAction(e->SendData());
	win.getChildren().addAll(button4,button5,button3,Search1,button7);
	layout.setTop(win);
	layout.setCenter(window);
	window.getChildren().addAll(title,button1,button2,button6,button8,Search2,B,C,D,E);
	window.getChildren().addAll(listAll,listChoice);
    scene = new Scene(layout,360,500,Color.LIGHTGREEN);
	stage.setScene(scene);
  }
  private void SendData() 
  {
	String infor = Search2.getText();
	FoodItem menu = new FoodItem();
	listAll.getItems().clear();
    menu.readFoodCategory();
    for(int i=0; i<menu.getCategoryCount();i++){
      int j=0;
      foodList = menu.getFoodCate().getList(i);
      while(foodList.getData(j)!=null)
      {
    	String[] ary = foodList.getData(j).split("  ");
    	String name = ary[0];
    	if(infor.equalsIgnoreCase(name))
           listAll.getItems().add(foodList.getData(j));
        j++;
      }
    }
    listChoice.setVisible(false);
    listAll.setVisible(true);	
  }
  private void setListView()
  {
    listChoice = new ListView<>();
	listAll = new ListView<>();
    listChoice.setVisible(false);
    listChoice.setLayoutY(70);
    listAll.setLayoutY(70);
    listChoice.setLayoutX(5);
    listAll.setLayoutX(5);
    listChoice.setMaxHeight(350);
    listAll.setMaxHeight(350);
    listChoice.setMinWidth(350);
    listAll.setMinWidth(350);
  }
  private void setLinkedList()
  {
    FoodItem menu = new FoodItem();
    listAll.getItems().clear();
    foodList = new FoodLL<>();
    menu.readFoodCategory();
    for(int i=0; i<menu.getCategoryCount();i++){
      int j=0;
      foodList = menu.getFoodCate().getList(i);
      while(foodList.getData(j)!=null)
      {
    	String[] ary = foodList.getData(j).split(";");
	    listAll.getItems().add(ary[1]+"  "+ary[2]+"  "+ary[3]+"  "+ary[4]);
        j++;
      }
    }
    listAll.getItems().sorted();
    listChoice.setVisible(false);
    listAll.setVisible(true);
  }
  private void setTextField()
  {
	Search2 = new TextField();
	Search2.setLayoutX(5);
	Search2.setLayoutY(440);
	Search2.setMinWidth(120);
	Search2.setText("Searching food");
  }
  private void setMenu()
  {
	FoodItem menu = new FoodItem();
	Search1.setEditable(true);
	Search1.getItems().clear();
	Search1.setValue("Soup");
	menu.readFoodCategory();
	for(int i=0;i<menu.getCategoryCount();i++)
	  Search1.getItems().addAll(menu.getFoodCate().getData(i));
	Search1.getItems().sorted();
    Search1.setLayoutX(200);
    Search1.setMinWidth(110);
    Search1.setMaxWidth(110);
    Search1.setStyle("-fx-background-color: white;");
  }
  private void setLabel()
  {
	title = new Label("Restaurant Menu");
	B = new Label("Name:");
	C = new Label("Price:");
	D = new Label("Quantity:");
	E = new Label("Size:");
	B.setTextFill(Color.GREEN);
	C.setTextFill(Color.GREEN);
	D.setTextFill(Color.GREEN);
	E.setTextFill(Color.GREEN);
	B.setFont(Font.font(14));
	C.setFont(Font.font(14));
	D.setFont(Font.font(14));
	E.setFont(Font.font(14));
	B.setLayoutX(8);
	B.setLayoutY(43);
	C.setLayoutX(80);
	C.setLayoutY(43);
	D.setLayoutX(140);
	D.setLayoutY(43);
	E.setLayoutX(220);
	E.setLayoutY(43);
	title.setFont(Font.font(24));
	title.setLayoutX(80);
	title.setTextFill(Color.GOLD);
  }
  private void setButton()
  {
	button1 = new Button("Information");
	button2 = new Button("Close");
	button3 = new Button("Search");
	button4 = new Button("+");
	button5 = new Button("-");
	button6 = new Button("F5");
	button7 = new Button("Food Category Window");
	button8 = new Button("Send");
	button1.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button2.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button3.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button4.setStyle("-fx-effect:dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button5.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button6.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button7.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button8.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
	button1.setTextFill(Color.DEEPPINK);
    button2.setTextFill(Color.BLUEVIOLET);
	button3.setTextFill(Color.DEEPSKYBLUE);
	button4.setTextFill(Color.DEEPPINK);
	button5.setTextFill(Color.DEEPPINK);
	button6.setTextFill(Color.DEEPPINK);
	button7.setTextFill(Color.DEEPSKYBLUE);
	button8.setTextFill(Color.DEEPPINK);
    button1.setLayoutY(440);
	button1.setLayoutX(220);
	button2.setLayoutY(440);
	button2.setLayoutX(310);
	button3.setLayoutX(310);
	button5.setLayoutX(26);
	button7.setLayoutX(50);
	button8.setLayoutX(160);
	button8.setLayoutY(440);
  }
  private void Searching(ComboBox<String> choice ) 
  {
	String food = choice.getValue();
	FoodItem list = new FoodItem();
	listChoice.getItems().clear();
	list.readFoodCategory();
	String lines = "";
	for(int i=0;i<list.getCategoryCount();i++)
	{
	  lines = list.getFoodCate().getData(i);
	  if(lines.equalsIgnoreCase(food)){
	    int j=0;
	    foodList = list.getFoodCate().getList(i);
	    while(foodList.getData(j)!=null)
	    {
	      String[] ary = foodList.getData(j).split(";");
	      listChoice.getItems().add(ary[1]+"  "+ary[2]+"  "+ary[3]+"  "+ary[4]);
	      j++;
	    }
	  }
	}
  }
  private void confirmDeleteWindow(String message) 
  {
	Stage win = new Stage();
	Pane box = new Pane();
	EditorTwo Del = new EditorTwo();
	Label text = new Label("Are you Sure you want to delete this food?");
	Button o = new Button("Yes");
	Button x = new Button("No");
	win.setTitle("Confirm window");
	win.initModality(Modality.APPLICATION_MODAL);
	win.setWidth(270);
	win.setHeight(150);
	o.setLayoutX(80);
	o.setLayoutY(70);
	x.setLayoutX(130);
	x.setLayoutY(70);
	x.setOnAction(e->win.close());
	o.setOnAction(e->{Del.DeleteMenu(message);
	win.close();});
	text.setLayoutY(30);
	text.setLayoutX(8);
	text.setFont(Font.font(12));
	text.setTextFill(Color.RED);
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
  }
  private void DeleteFood() 
  {
	String message="";
	if(listAll.isVisible())
	  message = (String) listAll.getSelectionModel().getSelectedItem();
	else
	if(listChoice.isVisible())
	  message = (String) listChoice.getSelectionModel().getSelectedItem();
	try{
		if(message.equals(""))
		  throw new Exception("");
		confirmDeleteWindow(message);
	}
	catch(Exception e)
	{
		e.getMessage();
		AlertWindow show = new AlertWindow();
		show.ExceptionWindow();
	}
  }
  public void InformationWindow() 
  {
	AlertWindow show = new AlertWindow();
	String food="";
	if(listChoice.isVisible())
	  food = (String) listChoice.getSelectionModel().getSelectedItem();
	else
	  food = (String) listAll.getSelectionModel().getSelectedItem();
	try{
		if(food.equals(""))
		  throw new Exception("");
	    show.InforWindow(food);
	}
	catch(Exception e)
	{
	  show.ExceptionWindow();
	}
  }
  public void addingWindow() 
  {
	addWindow = new Stage();
	TextField a,b,c,d;
	TextArea New;
	a = new TextField();
	b = new TextField();
	c = new TextField();
	d = new TextField();
	New = new TextArea();
	Pane addPane = new Pane();
	ComboBox<String> cate = new ComboBox<>();
	cate.setEditable(true);
	addWindow.setTitle("Adding window");
	addWindow.initModality(Modality.APPLICATION_MODAL);
	Button one = new Button("Submit");
	Button two = new Button("Cancel");
	FoodItem menu = new FoodItem();
	cate.getItems().clear();
	menu.readFoodCategory();
	for(int i=0;i<menu.getCategoryCount();i++)
       cate.getItems().addAll((String) menu.getFoodCate().getData(i));
	cate.setValue("Soup");
	one.setOnAction(e->{
	if(a.getText().equals(""))
	  a.setText("?");
	if(b.getText().equals(""))
	  b.setText("?");	
	if(c.getText().equals(""))
	  c.setText("?");
	if(d.getText().equals(""))
	  d.setText("?");
	if(New.getText().equals(""))
	  New.setText("No description");
	String Message = cate.getValue()+";"+a.getText()+";"+b.getText()+";"+c.getText()+";"+d.getText()+";"+New.getText();
	ConfirmAddingWindow(Message);});
	two.setOnAction(e->addWindow.close());
	Label first = new Label("Name:");
	Label second = new Label("Price:");
	Label third = new Label("Quailty:");
	Label fourth = new Label("Size:");
	Label last = new Label("Edit Pane");
	last.setLayoutX(200);
	last.setTextFill(Color.ORANGERED);
	last.setFont(Font.font(20));
	New.setWrapText(true);
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
 	a.setLayoutX(70);
 	a.setLayoutY(50);
 	b.setLayoutX(310);
 	b.setLayoutY(50);
 	c.setLayoutX(70);
 	c.setLayoutY(80);
 	d.setLayoutX(310);
 	d.setLayoutY(80);
 	New.setLayoutX(15);
 	New.setLayoutY(120);
 	cate.setMinWidth(120);
 	addWindow.setHeight(390);
 	addWindow.setWidth(500);
    addPane.getChildren().addAll(cate,one,two,first,second,third,fourth,a,b,c,d,New,last);
 	addWindow.setScene(new Scene(addPane));
 	addWindow.showAndWait();
  }
  private void ConfirmAddingWindow(String Message) {
	Stage win = new Stage();
	Pane box = new Pane();
	EditorThree Add = new EditorThree();
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
	o.setOnAction(e->{Add.addMenu(Message);win.close();
	addWindow.close();});
	text.setLayoutX(10);
	text.setLayoutY(30);
	text.setFont(Font.font(18));
	text.setTextFill(Color.RED);
	box.getChildren().addAll(o,x,text);
	win.setScene(new Scene(box));
	win.showAndWait();
  }
  public FoodLL<String> getFoodList()
  {
	  return foodList;
  }
}

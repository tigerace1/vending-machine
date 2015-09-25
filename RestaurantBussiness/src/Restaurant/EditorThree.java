package Restaurant;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class EditorThree{
  private String Message;
  private String NewFood;
  public EditorThree()
  {
	 Message="";
	 NewFood = "";
  }
  private void setMessage(String newMessage)
  {
	  this.Message = newMessage;
  }
  private void setNewFood(String newFood)
  {
	  this.NewFood = newFood;
  }
  public void addMenu(String message)
  {
	  setMessage(message);
	  writeMenu();
  }
  public void AddCate(String newFood)
  {
	  setNewFood(newFood);
	  writeCate();
  }
  private void writeMenu() 
  {
	 setMessage(Message);
     String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
	try{
	  PrintWriter OutputStream = new PrintWriter(new FileOutputStream(fileName,true));
	  OutputStream.println(Message);
	  OutputStream.close();
	}
	catch(FileNotFoundException e)
	{
		System.exit(0);
	}
  }
  private void writeCate() 
  {
	String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodCategorise.txt";
    try{
	  PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName,true));
	  outputStream.println(NewFood);
	  outputStream.close();
	}
	catch(FileNotFoundException e)
	{
	  System.out.println("Cannot find the file "+fileName);
	  System.exit(0);
	}
  }
  public String getNewFood()
  {
	  return NewFood;
  }
  public String getMessage()
  {
	  return Message;
  }
}

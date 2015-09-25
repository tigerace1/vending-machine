package Restaurant;
import java.util.Scanner;
import LinkedList.FoodLL;
public class Driver {
  public static void main(String[] args)
  {
	  System.out.println("Enter 1 for GUI, enter 2 for simulator");
	  Scanner keyboard = new Scanner(System.in);
	  int num = keyboard.nextInt();
	  if(num==1)
	  {
		  GraphInterface GUI = new GraphInterface();
		  GUI.main(args);
	  }
	  else{
		  Test test = new Test();
		  test.Restaurant();
		  test.adding();
		  test.editing();
		  test.deleting();
		  test.addCate();
		  test.editCate();
		  test.deleteCate();
		  test.remove();
		  test.removeCate();
	  }
  }

 }


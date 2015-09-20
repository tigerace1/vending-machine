package Restaurant;

import java.util.Scanner;

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
		  Restaurant();
	  }
  }
  private static void Restaurant() 
  {
	  System.out.println("Here is the menu:");  
	  FoodItem menu = new FoodItem();
	  menu.readFoodLines();
	  String Menu="";
	  int i =0;
	  for(i=0; i<menu.getFoodLines();i++)
	  {
		 Menu = menu.getFoodList().getData(i);
	     String[]ary = Menu.split(";");
	     String cate = ary[0];
	     String name = ary[1];
	     String prize = ary[2];
	     String quality = ary[3];
	     String size = ary[4];
	     System.out.println((i+1)+". Category: "+cate+" name: "+name+" prize: "+prize+" quality: "+quality+" size: "+size);
	  } 
  }
}

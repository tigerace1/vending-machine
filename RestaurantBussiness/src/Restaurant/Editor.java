package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import LinkedList.FoodLL;
public class Editor {
  private String Category,Name,Prize,Quality,Size,Description;
  public Editor()
  {
	Category = "";
	Name = "";
	Prize = "";
	Quality = "";
	Size = "";
	Description ="";
  }
  public void EditMenu(String c,String n, String p, String q, String s, String d,String m) 
  {
	 Category =c;
	 Name = n;
	 Prize = p;
	 Quality = q;
	 Size = s;
	 Description = d;
	 EditInfor(m);
  }
  private void EditInfor(String message) 
  {
     int count =0;
     FoodLL<String> foodList = new FoodLL<>();
	 String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
	 try{
		 Scanner inputStream = new Scanner(new File(fileName));
		 while(inputStream.hasNextLine())
		 {
		   String line = inputStream.nextLine();
		   String newLine = setString(line);
		   if(newLine.equals(message)){
			 line = toString();
			 foodList.addLast(line);
		   }else
		     foodList.addLast(line);
		   count++;
	     }
		 inputStream.close();
	 }
	 catch(FileNotFoundException e)
	 {
	     System.out.println("Cannot find the file "+fileName);
		 System.exit(0);
	 }
	 try{
		 PrintWriter outputStream = new PrintWriter(fileName);
		 for(int i=0; i<count; i++)
		   outputStream.println(foodList.getData(i));
		 outputStream.close();
	 }
	 catch(FileNotFoundException e)
	 {
	     System.out.println("Cannot find the file "+fileName);
		 System.exit(0);
	 }
  }
  private String setString(String line) 
  {
	String[] ary = line.split(";");
	String newName = ary[1];
	String newPrize= ary[2];
	String newQuality=ary[3];
	String newSize = ary[4];
	return newName+"  "+newPrize+"  "+newQuality+"  "+newSize;
  }
  public String toString()
  {
	 return Category+";"+Name+";"+Prize+";"+Quality+";"+Size+";"+Description;
  }
  public String getDescription()
  {
	  return Description;
  }
  void EditCate(String message,String food) 
  {
	String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodCategorise.txt";
	int index = 0;
	FoodLL<String> foodCa = new FoodLL<>();
	try{
		Scanner inputStream = new Scanner(new File(fileName));
		while(inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			if(food.equals(line))
			   foodCa.addLast(message);
			else
			   foodCa.addLast(line);
			index++;
		}
		inputStream.close();
	}
	catch(FileNotFoundException e)
	{
		System.exit(0);
	}
	try{
		PrintWriter outputStream = new PrintWriter(fileName);
		for(int i = 0; i<index; i++)
			outputStream.println(foodCa.getData(i));
		outputStream.close();
	}
	catch(FileNotFoundException e)
	{
		System.exit(0);
	}
  }
}
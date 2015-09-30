package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import LinkedList.CateList;
import LinkedList.FoodLL;
public class Editor {
  private String newFood;
  private String newCategory;
  public Editor()
  {
	newFood = "";
	newCategory = "";
  }
  private void setFood(String newfood)
  {
	this.newFood = newfood;
  }
  private void setCategory(String line)
  {
	this.newCategory = line;
  }
  public void EditMenu(String newfood, String m) 
  {
	 setFood(newfood); 
	 writeMenu(m);
  }
  public void EditCate(String line, String m)
  {
	setCategory(line);
	writeCategory(m); 
  }
  private void writeMenu(String message) 
  {
     int count =0;
     FoodLL<String> foodList = new FoodLL<>();
	 String fileName = "FoodItems.txt";
	 try{
		 Scanner inputStream = new Scanner(new File(fileName));
		 while(inputStream.hasNextLine())
		 {
		   String line = inputStream.nextLine();
		   String newLine = setString(line);
		   if(newLine.equals(message)){
			 foodList.addLast(getNewFood());
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
  private void writeCategory(String message) 
  {
	String fileName = "FoodCategorise.txt";
	int index = 0;
	FoodLL<Object> foodCa = new FoodLL<>();
	try{
		Scanner inputStream = new Scanner(new File(fileName));
		while(inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			if(message.equals(line)){
			   foodCa.addLast(newCategory);
			}else
			   foodCa.addLast(line);
			index++;
		}
		changeFood(getNewCate(),message);
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
  private void changeFood(String newCate,String oldCate)
  {
	int count =0;
    FoodLL<String> foodList = new FoodLL<>();
    String fileName = "FoodItems.txt";
	try{
	  Scanner inputStream = new Scanner(new File(fileName));
	  while(inputStream.hasNextLine())
	  {
		String line = inputStream.nextLine();
		String[] ary = line.split(";");
		String cate = ary[0];
		String name = ary[1];
		String price = ary[2];
		String quality = ary[3];
		String size = ary[4];
		String des = ary[5];
		if(oldCate.equals(cate)){
		  foodList.addLast(newCate+";"+name+";"+price+";"+quality+";"+size+";"+des);
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
  public String getNewFood() 
  {
	  return newFood;
  }
  public String getNewCate()
  {
	  return newCategory;
  }
  public String getDescription()
  {
	  String[]ary = newFood.split(";");
	  String des = ary[5];
	  return des;
  }
}

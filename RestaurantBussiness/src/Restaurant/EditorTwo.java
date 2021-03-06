package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import LinkedList.FoodLL;
public class EditorTwo {
  private String category;
  public EditorTwo()
  {
	category="";
  }
  public void setCategory(String newCategory)
  {
	this.category = newCategory;
  }
  public void deleteMenu(String message) 
  {
    int count = 0;
	FoodLL<String> foodList = new FoodLL<>(); 
	String fileName = "FoodItems.txt";
    try{
	  Scanner inputStream = new Scanner(new File(fileName));
	  String line="";
	  while(inputStream.hasNextLine())
	  {
		line = inputStream.nextLine();
		String newline = toString(line); 
		if(newline.equals(message)){
		  String[] ary = line.split(";");
		  setCategory(ary[0]);
		  line = "";
		}else{
		  foodList.addLast(line);
		  count++;
		}
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
	  if(count==0)
		delCate(getCategory());
	}
	catch(FileNotFoundException e)
	{
	  System.out.println("Cannot find the file "+fileName);
	  System.exit(0);
	}
  }
  private String toString(String line) 
  {
	String[] ary = line.split(";");
	String name = ary[1];
	String price = ary[2];
	String quality = ary[3];
	String size = ary[4];
	return name+"  "+price+"  "+quality+"  "+size;
  }
  public void delCate(String message) 
  {
	int count =0;
	FoodLL<String> cateList = new FoodLL<>(); 
	String fileName = "FoodCategorise.txt";
	try{
      Scanner inputStream = new Scanner(new File(fileName));
      while(inputStream.hasNextLine())
	  {
	   String line = inputStream.nextLine();
	   if(line.equals(message)) {
		  line = "";
	   }
	   else{
		  cateList.addLast(line);
		  count++;
		}
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
		outputStream.println(cateList.getData(i));
		outputStream.close();
	}
	catch(FileNotFoundException e)
	{
	   System.out.println("Cannot find the file "+fileName);
	   System.exit(0);
	}
  }
  public String getCategory()
  {
	return category;
  }
 }

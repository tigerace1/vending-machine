package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import LinkedList.FoodLL;
public class EditorThree{
  private String Category,Name,Prize,Quality,Size,Description;
  public EditorThree()
  {
	 Category="";
	 Name = "";
	 Prize ="";
	 Quality = "";
	 Size = "";
	 Description ="";
  }
  void addMenu(String n, String p, String q,String s, String d, String c) 
  {
     Category=c;
     Name = n;
     Prize = p;
     Quality = q;
     Size = s;
     Description = d;
     writeItems();
  }
  private void writeItems() 
  {
     String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
     ArrayList<String> list = new ArrayList<>();
     int index = 0;
	 String line="";
	 try{
		Scanner inputStream = new Scanner(new File(fileName));
		while(inputStream.hasNextLine())
		{
		  line = inputStream.nextLine();
		  list.add(line);
		  index++;
		}
		line = toString();
		list.add(line);
		Collections.sort (list);
		inputStream.close();
	}
	catch(FileNotFoundException e)
	{
		System.exit(0);
	}
	try{
		PrintWriter OutputStream = new PrintWriter(fileName);
		for(int i=0;i<=index;i++)
		  OutputStream.println(list.get(i));
		OutputStream.close();
	}
	catch(FileNotFoundException e)
	{
		System.exit(0);
	}
  }
  public String toString()
  {
	return Category+";"+Name+";"+Prize+";"+Quality+";"+Size+";"+Description;
  }
  void DelCate(String newFood) 
  {
	String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodCategorise.txt";
	ArrayList<String> Catelist = new ArrayList<>();
	int index = 0;
	String line="";
	try{
	  Scanner inputStream = new Scanner(new File(fileName));
	  while(inputStream.hasNextInt())
	  {
		 line = inputStream.nextLine();
		 Catelist.add(line);
		 index++;
	  }
	  Catelist.add(newFood);
	  Collections.sort(Catelist);
	  inputStream.close();
	}
	catch(FileNotFoundException e)
	{
	  System.exit(0);
	}
	try{
	  PrintWriter OutputStream = new PrintWriter(fileName);
	  for(int i=0;i<=index;i++)
		OutputStream.println(Catelist.get(i));
		OutputStream.close();
	}
	catch(FileNotFoundException e)
	{
	  System.exit(0);
	}
  }
}

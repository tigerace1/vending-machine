package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import LinkedList.FoodLL;
public class FoodItem {
   private FoodLL<String> FoodItem;
   private FoodLL<String> foodCa;
   private FoodLL<String> FoodList;
   private int CategoryCount;
   private int FoodCount;
   private int FoodLine;
   public FoodItem()
   {
	   FoodItem = new FoodLL<>();
	   FoodList= new FoodLL<>();
	   foodCa = new FoodLL<>();
	   CategoryCount = 0;
	   FoodCount = 0;
	   FoodLine = 0;
   }
   public void readFoodCategory()
   {
	   String line ="";
	   String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodCategorise.txt";
	   try{
		   Scanner inputStream = new Scanner(new File(fileName));
		   while(inputStream.hasNextLine())
		   {
			  line = inputStream.nextLine();
			  foodCa.addLast(line);
			  CategoryCount++;
		   }
		   inputStream.close();
	   }
	   catch(FileNotFoundException e)
	   {
		   System.out.println("Cannot find the file "+fileName);
		   System.exit(0);
	   }
  }
  public void readFoodItems()
  {
	String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
    try{
		Scanner inputStream = new Scanner(new File(fileName));
		while(inputStream.hasNextLine())
		{
		   String line = inputStream.nextLine();
		   FoodItem.addLast(setString(line));
		   FoodCount++;
	    }
		inputStream.close();
	}
	catch(FileNotFoundException e)
	{
	    System.out.println("Cannot find the file "+fileName);
		System.exit(0);
	}
   }
  public void readFoodLines()
  {
	FoodLine =0 ;
	String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
    try{
		Scanner inputStream = new Scanner(new File(fileName));
		while(inputStream.hasNextLine())
		{
		   String line = inputStream.nextLine();
		   FoodList.addLast(line);
		   FoodLine++;
	    }
		inputStream.close();
	}
	catch(FileNotFoundException e)
	{
	    System.out.println("Cannot find the file "+fileName);
		System.exit(0);
	}
   }
   public String setString(String lines)
   {
	   String[] ary = lines.split(";");
	   String a = ary[0];
	   String name = ary[1];
	   String prize  =ary[2];
	   String quality = ary[3];
	   String size = ary[4];
	   return name+"  "+prize+"  "+quality+"  "+size;
   }
   public FoodLL<String> getFoodItems()
   {
	   return FoodItem;
   }
   public FoodLL<String> getFoodCate()
   {
	   return foodCa;
   }
   public int getcategoryCount()
   {
	   return CategoryCount;
   }
   public int getFoodCount()
   {
	   return FoodCount;
   }
   public int getFoodLines()
   {
	   return FoodLine;
   }
   public FoodLL<String> getFoodList()
   {
	   return FoodList;
   }
}


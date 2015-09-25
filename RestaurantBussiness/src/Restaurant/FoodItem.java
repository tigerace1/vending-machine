package Restaurant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import LinkedList.CateList;
import LinkedList.FoodLL;
public class FoodItem implements Serializable{
   private FoodLL<String> FoodItem;
   private CateList<Object> foodCa;
   private int CategoryCount;
   private int FoodCount;
   public FoodItem()
   {
	 FoodItem = new FoodLL<>();
	 foodCa = new CateList<>();
	 CategoryCount = 0;
	 FoodCount = 0;
   }
   private void setFoodItem(FoodLL<String>FoodItem)
   {
	   this.FoodItem = FoodItem;
   }
   private void setFoodCa(CateList<Object>foodCa)
   {
	   this.foodCa = foodCa;
   }
   private void setCategoryCount(int CategoryCount)
   {
	   this.CategoryCount = CategoryCount;
   }
   private void setFoodCount(int FoodCount)
   {
	   this.FoodCount = FoodCount;
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
		 String file = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
		 try{
		   Scanner input = new Scanner(new File(file));
		   while(input.hasNextLine())
		   {
			 String newLine = input.nextLine();
			 String[] ary = newLine.split(";");
			 String a = ary[0];
			 if(line.equals(a))
			   FoodItem.addLast(newLine);
		   }
		 input.close();
		 foodCa.addLast(line,FoodItem);
		 FoodItem = new FoodLL<>();
		 CategoryCount++;
		}
	    catch(FileNotFoundException e)
	    {
		   System.exit(0);
		}
	   }
	   inputStream.close();
     }
     catch(FileNotFoundException e)
	 {
		System.out.println("Cannot find the file "+fileName);
		System.exit(0);
	 }
  }
   public void writeFoods()
   {
	 ObjectOutputStream outputStream = null;
	 String fileName = "C:\\git\\RestaurantBussiness\\Menu\\Fooddat";
	 try{
	   outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
	 }
	 catch(IOException e)
	 {
	   System.out.println("Cannot find the file "+fileName);
	   System.exit(0);
	 }
	 try{
	   outputStream.writeObject(foodCa); 
	   outputStream.flush();
	   outputStream.close();
	 }
	 catch(IOException e)
	 {
		 System.exit(0);
	 }
   }
   public void readFoods()
   {
	 ObjectInputStream inputStream = null;
     String fileName = "C:\\git\\RestaurantBussiness\\Menu\\Fooddat";
	 try{
	   inputStream = new ObjectInputStream(new FileInputStream(fileName));
	 }
	 catch(IOException e)
	 {
	   System.out.println("Cannot find the file "+fileName);
	   System.exit(0);
	 }
	 try{
	   foodCa = (CateList<Object>) inputStream.readObject(); 
	   inputStream.close();
	 }
	 catch(Exception e)
	 {
		System.exit(0);
	 }
   }
   public FoodLL<String> getFoodItems()
   {
	   return FoodItem;
   }
   public CateList<Object> getFoodCate()
   {
	   return foodCa;
   }
   public int getCategoryCount()
   {
	   return CategoryCount;
   }
   public int getFoodCount()
   {
	   return FoodCount;
   }
}


package Searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**class for saving foods items into a text file 
 * and bring foods' data into the linked list*/
public class FoodItems {
 private FoodList<String> foodList;
 private FoodLL<String> foodLink;
 private int count;
 public FoodItems()
 {
   foodList= new FoodList<>();
   foodLink = new FoodLL<>();
   count=0;
 }
 public void setFoodList(FoodList<String> newList)
 {
   this.foodList=newList;
 }
 public void setFoodLink(FoodLL<String> newLink)
 {
   this.foodLink=newLink;
 }
 public void setCount(int count)
 {
   this.count=count;
 }
 /**Read food items from the text file*/
 public void readFoods()
 {
   String fileName = "Foods";
   Scanner inputStream = null;
   try{
	 inputStream = new Scanner(new FileInputStream(fileName));
	 while(inputStream.hasNextLine())
	 {
	   String line = inputStream.nextLine();
	   foodList.bstAdd(line);
	   count++;
	 }
	 inputStream.close();
   }
   catch(FileNotFoundException e)
   {
	 System.exit(0);
   }
 }
 /**Write food items into the text file*/
 public void writeFoods()
 {
   String fileName = "Foods";
   try{
    PrintWriter outputStream = new PrintWriter(fileName);
    for(int i=0;i<foodLink.getCount();i++)
	  outputStream.println(foodLink.getData(i));
    outputStream.close();
   }
   catch(FileNotFoundException e)
   {
	 System.exit(0);
   }
 }
 public FoodList<String> getList()
 {
    return foodList;
 }
 public FoodLL<String> getLink()
 {
	return foodLink;
 }
 public int getCount(){
	return count;
 }
}

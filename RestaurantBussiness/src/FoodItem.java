import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class FoodItem {
   private  LinkedList foodCa;
   private LinkedList Soup;
   private LinkedList Salad;
   private LinkedList Ontray;
   private LinkedList Desserts;
   private LinkedList WineAndDrinks;
   public FoodItem()
   {
	   foodCa = new LinkedList();
	   Soup = new LinkedList();
	   Salad = new LinkedList();
	   Ontray = new LinkedList();
	   Desserts = new LinkedList();
	   WineAndDrinks = new LinkedList();
   }
   public void readFoodCategory()
   {
	  foodCa.add("Soup");
	  foodCa.add("Salad");
	  foodCa.add("Ontray");
	  foodCa.add("Desserts");
	  foodCa.add("Wine&Drinks");
   }
   public void readSoup()
   {
	   String fileName = "C:\\git\\RestaurantBussiness\\Menu\\Soup.txt";
	   Scanner inputStream = null;
	   try{
		   inputStream = new Scanner(new File(fileName));
		   while(inputStream.hasNextLine())
		   {
			   String line = inputStream.nextLine();
			   Soup.addLast(line);
		   }
	   }
	   catch(FileNotFoundException e)
	   {
		   System.out.println("Cannot find the file "+fileName);
		   System.exit(0);
	   }
   }
   public void readSalad()
   {
	   String fileName = "C:\\git\\RestaurantBussiness\\Menu\\Salad.txt";
	   Scanner inputStream = null;
	   try{
		   inputStream = new Scanner(new File(fileName));
		   while(inputStream.hasNextLine())
		   {
			   String line = inputStream.nextLine();
			   Salad.addLast(line);
		   }
	   }
	   catch(FileNotFoundException e)
	   {
		   System.out.println("Cannot find the file "+fileName);
		   System.exit(0);
	   }
   }
   public void readOntray()
   {
	   String fileName = "C:\\git\\RestaurantBussiness\\Menu\\Ontray.txt";
	   Scanner inputStream = null;
	   try{
		   inputStream = new Scanner(new File(fileName));
		   while(inputStream.hasNextLine())
		   {
			   String line = inputStream.nextLine();
			   Ontray.addLast(line);
		   }
	   }
	   catch(FileNotFoundException e)
	   {
		   System.out.println("Cannot find the file "+fileName);
		   System.exit(0);
	   }
   }
   public void readDesserts()
   {
	   String fileName = "C:\\git\\RestaurantBussiness\\Menu\\Desserts.txt";
	   Scanner inputStream = null;
	   try{
		   inputStream = new Scanner(new File(fileName));
		   while(inputStream.hasNextLine())
		   {
			   String line = inputStream.nextLine();
			   Desserts.addLast(line);
		   }
	   }
	   catch(FileNotFoundException e)
	   {
		   System.out.println("Cannot find the file "+fileName);
		   System.exit(0);
	   }
   }
   public void readWineAndDrinks()
   {
	   String fileName = "C:\\git\\RestaurantBussiness\\Menu\\Wine&Drinks.txt";
	   Scanner inputStream = null;
	   try{
		   inputStream = new Scanner(new File(fileName));
		   while(inputStream.hasNextLine())
		   {
			   String line = inputStream.nextLine();
			   WineAndDrinks.addLast(line);
		   }
	   }
	   catch(FileNotFoundException e)
	   {
		   System.out.println("Cannot find the file "+fileName);
		   System.exit(0);
	   }
   }
   public LinkedList getSoup()
   {
	   return Soup;
   }
}


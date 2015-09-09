import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class FoodInformation {
  private static String[] linesOFSnacks = new String[10];
  private static String[] linesOFDrinks = new String[10];
  private String Date()
  {
     Calendar now = Calendar.getInstance();
     int Y = now.get(Calendar.YEAR); 
     int Mo = now.get(Calendar.MONTH)+1; 
     int D = now.get(Calendar.DATE);
     int H = now.get(Calendar.HOUR);
     int  M = now.get(Calendar.MINUTE);
     int S = now.get(Calendar.SECOND);
     return  Y+"-"+Mo+"-"+D+"    "+H+":"+M+":"+S;
  }
  public void MachineOne()
  {
	 String fileName ="C:\\git\\ProjectVendingMachine\\VendingMachine\\Snack.txt";
	 Scanner inputStream = null;
	 try
	 {
		 inputStream = new Scanner(new File(fileName));
	 }
	 catch(FileNotFoundException e)
	 {
		 System.out.println("Cannot find the file "+fileName);
		 System.exit(0);
	 }
	 int i = 0;
     while(inputStream.hasNextLine())
	 {
		 linesOFSnacks[i] = inputStream.nextLine();
		 System.out.println(linesOFSnacks[i]);
		 i++;
	 }
	 inputStream.close();
  }
  public void MachineTwo()
  {
	 String file = "C:\\git\\ProjectVendingMachine\\VendingMachine\\drink.txt";
	 Scanner inputStream = null;
	 try
	 {
		 inputStream = new Scanner(new File(file));
	 }
	 catch(FileNotFoundException e)
	 {
		 System.out.println("Cannot find the file "+file);
		 System.exit(0);
	 }
	 int i=0;
	 while(inputStream.hasNextLine())
	 {
		 linesOFDrinks[i] = inputStream.nextLine();
		 System.out.println(linesOFDrinks[i]);
		 i++;
	 }
	 inputStream.close();
  }
  public void foods(int num)
  {
	  String name = num+".txt";
	  String file ="C:\\git\\ProjectVendingMachine\\VendingMachine\\"+name;
	  Scanner inputStream = null;
	  try
	  {
		 inputStream = new Scanner(new File(file));
	  }
	  catch(FileNotFoundException e)
	  {
		 System.out.println("Cannot find the file "+file);
		 System.exit(0);
	  }
	  while(inputStream.hasNextLine())
	  {
		 String line = inputStream.nextLine();
		 System.out.println(line);
	  }
	  inputStream.close();	  
  }
  public void DRINK(int num)
  {
	  num=num+10;
	  String name = num+".txt";
	  String file = "C:\\git\\ProjectVendingMachine\\VendingMachine\\"+name;;
	  Scanner inputStream = null;
	  try
	  {
		 inputStream = new Scanner(new File(file));
	  }
	  catch(FileNotFoundException e)
	  {
		 System.out.println("Cannot find the file "+file);
		 System.exit(0);
	  }
	  while(inputStream.hasNextLine())
	  {
		 String line = inputStream.nextLine();
		 System.out.println(line);
	  }
	  inputStream.close();	  
  }
  public void printSnack(int newNumber)
  {
	  String fileName = "C:\\git\\ProjectVendingMachine\\VendingMachine\\Recipe.txt";
	  try{
		  PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName,true));
		  outputStream.println("Item name: "+linesOFSnacks[newNumber]+" (Snack) $1.5  "+Date());
		  outputStream.close();
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file "+fileName);
		  System.exit(0);
	  }
  }
  public void printDrink(int newNumber)
  {
	  String fileName = "C:\\git\\ProjectVendingMachine\\VendingMachine\\Recipe.txt";
	  try{
		  PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName,true));
		  outputStream.println("Item name: "+linesOFDrinks[newNumber]+" (Drink) $2.0  "+Date());
		  outputStream.close();
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file "+fileName);
		  System.exit(0);
	  }
  }
  
}

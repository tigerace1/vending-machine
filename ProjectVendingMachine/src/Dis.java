import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Dis {
  private int[] Dis;
  private String fileName;
  private static int index=0;
  public Dis()
  {
	 Dis = new int[index];
	 fileName = "";
  }
  public void input()
  {
	  fileName = "C:\\git\\ProjectVendingMachine\\VendingMachine\\int.txt";
	  Scanner inputStream = null;
	  try
	  {
		inputStream =  new Scanner(new File(fileName));
		int i=0, line=0;
		while(inputStream.hasNextInt())
		{
		  line = inputStream.nextInt();
		  Dis[i]=line;
		  i++;
		}
		 inputStream.close();
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file "+fileName);
		  VendingMachine DrinkCost = new VendingMachine();
		  System.out.println("Here is your: "+DrinkCost.getMoney()+" Dollars");
		  Driver New = new Driver();
		  New.display();
	  }
  }
  public void setting()
  {
	  fileName = "C:\\git\\ProjectVendingMachine\\VendingMachine\\drink.txt";
	  Scanner inputDrink = null;
	  try
	  {
		  inputDrink =  new Scanner(new File(fileName));
	    while(inputDrink.hasNextLine()){
		    String o = inputDrink.nextLine();
		    index++;
	  }
	   inputDrink.close();
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file");
		  System.exit(0);
	  }
  }
  public void output()
  {
	 fileName = "C:\\git\\ProjectVendingMachine\\VendingMachine\\int.txt";
	 PrintWriter outputStream = null;
	 try
	 {
	    outputStream = new PrintWriter(fileName);
	 }
	 catch(FileNotFoundException e)
	 {
		System.out.println("Cannot find the file "+fileName);
		System.exit(0);
	 }
	 for(int i=0;i<10;i++)
	 {
		outputStream.println(Dis[i]);
	 }
	 outputStream.close();
  }
  public void count(int num)
  {
	  try{
		if(Dis[num]<1)
			throw new Exception("No more");
		  Dis[num]=Dis[num]-1;
		}
		catch(Exception e)
		{
		   System.out.println(e.getMessage());
		   Scanner keyboard = new Scanner(System.in);
		   VendingMachine DrinkCost = new VendingMachine();
	       System.out.println("Do you want another Choice.");
		   int ans = (int)Math.random();;
		   if(ans==0){
			   DrinkCost.choseDrinks();
		   }else{
			  Driver NEW = new Driver();
			  NEW.display();
		   }
		}
  }
  public void DrinksNumber()
  {
	  String fileName = "C:\\git\\ProjectVendingMachine\\VendingMachine\\drink.txt";
	  String file = "C:\\git\\ProjectVendingMachine\\VendingMachine\\sold.txt";
	  String F = "C:\\git\\ProjectVendingMachine\\VendingMachine\\editorTwo.txt";
	  Scanner inputStream =null;
	  PrintWriter outputStream = null;
	  PrintWriter Output = null;
	  String Lines;
	  int i=0;
	  try
	  {
		 inputStream = new Scanner(new File( fileName));
		 outputStream = new PrintWriter(new FileOutputStream(file,true));
		 Output = new PrintWriter(F);
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file "+fileName);
		  System.exit(0);
	  }
	  outputStream.println("Drinks:");
	  while(inputStream.hasNextLine())
	  {
		Lines = inputStream.nextLine();
		outputStream.println(Lines+"    remain: "+Dis[i]);
		Output.println(Lines+"   ramain: "+Dis[i]);
		i++;
	  }
	  inputStream.close();
	  outputStream.close();
	  Output.close();
  }
}

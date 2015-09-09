import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Calendar;
public class VendingMachine {
   private int Mnumber;
   private int itemNumber;
   private static int SnackCount=0;
   private static int DrinkCount=0;
   private float Money;
   public VendingMachine()
   {
      Mnumber=0;
      itemNumber=0;
   }
   private void setVendingMachine(int Num)
   {
      Scanner keyboard = new Scanner(System.in);
      while(Num!=1&&Num!=2)
      {
    	System.out.println("Please enter a correct machine order number:");
    	Num=keyboard.nextInt();
      }
      Mnumber = Num;
   }
   private void setMoneyOne(float money)
   {
     while(money<1.5)
  	 {
  	   System.out.println("Not enough money, do you have more?");
  	   int ans = (int)Math.random();
  	   if(ans==0)
  	   {
  		  System.out.println("Enter the number of money you want to add");
  		  float add = (float)(Math.random()+2);
  		  System.out.println(add);
  		  money = money + add;
  	   }else{
  		  System.out.println("here is your "+money+" dollars,Bye-bye");
  		  Driver E = new Driver();
  		  E.display();
  	  }
  	 }
  	 Money = money;
   }
   private void setMoneyTwo(float money)
    {
      while(money<2)
  	  {
  		System.out.println("Not enough money, do you have more?");
  		int ans = (int)Math.random();
  		if(ans==0)
  		{
  		  System.out.println("Enter the number of money you want to add");
  		  float add = (float) (Math.random()+2);
  		  System.out.println(add);
  		  money = money + add;
  		}else
  		{
  			System.out.println("here is your "+money+" dollars,Bye-bye");
  			Driver D = new Driver();
  			D.display();
  		}
  	  }
  	  Money = money;
  	}
    private void setItemNumber(int num)
    {
    	Scanner keyboard = new Scanner(System.in);
    	while(num<0||num>10)
    	{
    		System.out.println("please enter a correct order number");
    		num = keyboard.nextInt();
    	}
    	itemNumber = num;
    }
    public void chooseVendingMachine(int Num)
    {
    	setVendingMachine(Num);
    	if(Mnumber==1)
    	  InputMoneySnacks();
    	else
    	  InputMoneyDrinks();
    }
    public String MoneyFormat(float money)
    {
    	money = money*100;
    	int dollars = (int)money/100;
    	int cents = (int)money%100;
    	return dollars+"."+cents;
    }
    public void InputMoneySnacks()
    {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter money now please:");
      float money = (float)(Math.random()+1);
      System.out.println("User enter: $"+money);
	  setMoneyOne(money);
	}
    public void choseSnacks()
    {
    	FoodInformation Snacks = new FoodInformation();
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("All snacks we have will show below($1.5 each):");
		Snacks.MachineOne();
		System.out.println("Pree the order number:");
		int num = (int)(Math.random()*10)+1;
		System.out.println(num);
		setItemNumber(num);
	}
    public void showingSnacks()
    {
    	FoodInformation snack = new FoodInformation();
    	System.out.println("Here is the nutrition fact: ");
		snack.foods(itemNumber);
		System.out.println("Here you are, and your $"+MoneyFormat(Money-1.5f)+ " changes.");
	    SnackCount++;
    }
    public void InputMoneyDrinks()
    {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter money now please:");
      float money =(float)(Math.random()+1.5);
      System.out.println("User enter: $"+money);
      setMoneyTwo(money);	
    }
    public void choseDrinks()
    {
    	FoodInformation drinking = new FoodInformation();
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("All drinks we have will show below($2 each):");
		drinking.MachineTwo();
		System.out.println("Pree the order number:");
		int num = (int)(Math.random()*10)+1;
		System.out.println(num);
		setItemNumber(num);
	}
    public void showingDrinks()
    {
    	FoodInformation drinking = new FoodInformation();
    	System.out.println("Here is the nutrition fact: ");
 		drinking.DRINK(itemNumber);
 		System.out.println("Here you are, and your $"+MoneyFormat(Money-2)+ " changes.");
     	DrinkCount++;
    }
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
    public void outputSold()
    {
    	String fileName ="C:\\git\\ProjectVendingMachine\\VendingMachine\\sold.txt";
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
    	outputStream.println(Date());
    	outputStream.println("Today's customer number: "+(DrinkCount+SnackCount));
    	outputStream.println("Today sold "+SnackCount+"($"+(SnackCount*1.5)+")"+" Snacks and "+DrinkCount+"($"+(DrinkCount*2)+")"+" Drinks");
    	outputStream.println("Today's total income: "+(DrinkCount*2+SnackCount*1.5));
    	outputStream.close();
    	System.out.println("Today's customer number: "+(DrinkCount+SnackCount));
    	System.out.println("Today sold "+SnackCount+"($"+(SnackCount*1.5)+")"+" Snacks and "+DrinkCount+"($"+(DrinkCount*2)+")"+" Drinks");
    	System.out.println("Today's total income: $"+(DrinkCount*2+SnackCount*1.5));
     }
     public int getItemNumber()
    {
    	return itemNumber-1;
    }
    public float getMoney()
    {
    	return Money;
    }
    
}

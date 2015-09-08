import java.io.EOFException;
import java.util.Scanner;
public class Driver {
  private static int Ans;
  public Driver()
  {
	  Ans = (int)(Math.random()*10)+1;
  }
  public static void main(String[] args)
  {
	 Dispenser machine = new Dispenser();
	 Dis Ma = new Dis();
	 machine.setting();
	 Ma.setting();
	 Driver a = new Driver();
	 a.display();
     System.out.println("Out of service.");
  }
  public void display()
  {
	  VendingMachine buyer = new VendingMachine();
	  FoodInformation infor = new FoodInformation();
	  Dispenser machine = new Dispenser();
	  Dis Ma = new Dis();
	  Scanner keyboard = new Scanner(System.in);
	  do{
		 machine.Input();
		 Ma.input();
		 System.out.println("Welcome!");
		 System.out.println("Do you want Snacks($1.5) or Drinks($2)(press 1 for Snacks, 2 for Drinks):");
		 int num = (int)(Math.random()*2)+1;
		 System.out.println(num);
	     buyer.chooseVendingMachine(num);
	     if(num==1)
	     {
	    	buyer.choseSnacks();
	        machine.counting(buyer.getItemNumber());
	        buyer.showingSnacks();
	        infor.printSnack(buyer.getItemNumber());
	     }else{
	    	buyer.choseDrinks();
	    	Ma.count(buyer.getItemNumber());
	    	buyer.showingDrinks();
	    	infor.printDrink(buyer.getItemNumber());
	     }
	     machine.Output();
		 Ma.output();
		 buyer.outputSold();
		 machine.SnacksNumber();
		 Ma.DrinksNumber();
	     Ans--;
	  }while(Ans>0);
  }
}

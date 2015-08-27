import java.util.Scanner;
public class Driver {
  public static void main(String[] args)
  {
	  Scanner keyboard = new Scanner(System.in);
	  System.out.println("Enter the minumum quantity for discount:");
	  double min = keyboard.nextDouble();
	  System.out.println("Enter the percent discount(%):");
	  double percent = keyboard.nextDouble();
	  System.out.println("enter the n:");
	  int n = keyboard.nextInt();
	  DiscountPolicy P = new CombinedDiscount(min, percent,n);
	  System.out.println("How many did you buy:");
	  int count = keyboard.nextInt();
	  System.out.println("What is the item cost individully:");
	  double itemCost = keyboard.nextDouble();
	  System.out.println("The maximum discount is: $"+P.computeDiscount(count,itemCost));
  }
}

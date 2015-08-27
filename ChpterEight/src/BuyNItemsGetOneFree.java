import java.util.Scanner;
public class BuyNItemsGetOneFree extends DiscountPolicy implements DicountPolicy{
  private int n;
  private double discount;
  private double cost;
  public BuyNItemsGetOneFree(int N)
  {
	  while(N<0)
	  {
		  Scanner keyboard = new Scanner(System.in);
		  System.out.println("ERROR: using negative number:\n Enter again please:");
		  N=keyboard.nextInt();
	  }
	  n=N;
  }
  public double computeDiscount(int count, double itemCost)
  {
	 discount = itemCost*(count/n);
	  return discount;
  }
}

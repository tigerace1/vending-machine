import java.util.Scanner;
public class CombinedDiscount extends DiscountPolicy implements DicountPolicy{
   DiscountPolicy FirstPurchase;
   DiscountPolicy SecondPurchase;
  public CombinedDiscount(double min, double percent, int n)
  {
	  FirstPurchase = new BulkDiscount(min,percent);
	  SecondPurchase = new BuyNItemsGetOneFree(n);
  }
  public double computeDiscount(int count, double itemCost)
  {
	  if(FirstPurchase.computeDiscount(count,itemCost)>SecondPurchase.computeDiscount(count,itemCost))
	  { 
		  return FirstPurchase.computeDiscount(count,itemCost);
	  }else 
	  if(FirstPurchase.computeDiscount(count,itemCost)<SecondPurchase.computeDiscount(count,itemCost))
	  {
		  return SecondPurchase.computeDiscount(count,itemCost);
	  }
       return 0;
  }
  
}
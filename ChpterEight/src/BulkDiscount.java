
public class BulkDiscount extends DiscountPolicy implements DicountPolicy{
  private double munimum;
  private double percent;
  private double discount;
  public BulkDiscount(double Munimum, double Percent)
  {
	  munimum = Munimum;
	  percent = Percent/100;
  }
  public  double computeDiscount(int count, double itemCost) {
    
	if(count>=munimum)
	  discount = count*itemCost*percent;
    else
    	discount = 0;
    return discount;
  }
 
}

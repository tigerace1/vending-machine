package Cars;

import java.util.Calendar;

public class Lanes extends Thread implements LanesInterface{
  private CarLL<String> Car;
  private String lane;
  public Lanes(String newLane)
  {
   lane=newLane;
   Car = new CarLL<String>();
  }
  private void setLane(String newLane)
  {	
	this.lane = newLane;
  }
  private void Car(CarLL<String> Cars)
  {
	this.Car =Cars;
  }
  private String timing()
  {
   Calendar now = Calendar.getInstance();
   int S = now.get(Calendar.SECOND);
   int h,m,s;
   do{
 	Calendar Now = Calendar.getInstance();
 	h = Now.get(Calendar.HOUR);
 	m = Now.get(Calendar.MINUTE);
 	s = Now.get(Calendar.SECOND); 
   }while(S==s);
   return h+":"+m+":"+s;
  }  
  public void run() 
  {
    int num = (int)(Math.random()*10)+5;
	for(int i=0;i<num;i++)
	{
	  Car.addLast(lane,timing());
	}
  }
  public CarLL<String> getCars()
  {
	return Car;
  }
  public String getLane()
  {
	return lane;
  }
}

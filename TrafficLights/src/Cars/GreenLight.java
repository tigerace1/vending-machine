package Cars;

import java.util.Calendar;
public class GreenLight extends Thread implements GreenLightInterface{
 private Object[] lanes;
 private int index;
 private int num;
 private CarLL<String> greenLight;
 public GreenLight(int Num,Object[] newLane)
 {
  setNum(Num);
  setLanes(newLane);
  index = 0;
  greenLight = new CarLL<String>();
 }
 private void setLanes(Object[] lanes) 
 {
	this.lanes = lanes;
 }
 private void setIndex(int index) 
 {
	this.index = index;
 }
 private void setNum(int num) 
 {
	this.num = num;
 }
 private String timing()
 {
 Calendar now = Calendar.getInstance();
 int H = now.get(Calendar.HOUR);
 int M = now.get(Calendar.MINUTE);
 int S = now.get(Calendar.SECOND);
 int h,m,s;
 do{
	Calendar Now = Calendar.getInstance();
	h = Now.get(Calendar.HOUR);
	m = Now.get(Calendar.MINUTE);
	s = Now.get(Calendar.SECOND); 
 }while((((h-H)*3600)+((m-M)*60)+(s-S))<=2);
 return h+":"+m+":"+s;
 }
 public void run()
 {
   String infor ="";
   index=0;
   greenLight = (CarLL<String>) lanes[num];
   infor = greenLight.getData(0);
   while(greenLight.isEmpty()!=true)
   {
	 System.out.println("Lane: "+greenLight.getData(0)+"  Waited: "+CountTime(greenLight.getTime(0),timing())+" sec");
	 greenLight.remove();
	 index++;
   }
   System.out.println(infor+": "+index);
 }
 private int CountTime(String time,String newTime) 
 {
  String[] ary = time.split(":");
  String hour = ary[0];
  String min = ary[1];
  String sec = ary[2];
  String[]Ary = newTime.split(":");
  String h = Ary[0];
  String m = Ary[1];
  String s = Ary[2];
  int T = (Integer.parseInt(hour)-Integer.parseInt(h))*3600+(Integer.parseInt(m)-Integer.parseInt(min))*60+Integer.parseInt(s)-Integer.parseInt(sec);
  return T;
 }
 public Object[] getLanes() {
	return lanes;
 }
 public int getIndex() {
	return index;
 }
 public int getNum() {
	return num;
 }
}

package Cars;

public class CarLL<T> {
 private CarNodes<T> head;
 private CarNodes<T> tail;
 private int count;
 public CarLL()
 {
	head = new CarNodes<T>(null,null);
	tail = null;
	count = 0; 
 }
 public synchronized void addLast(String data, String string)
 {
	
	CarNodes<T> tmp = new CarNodes<T>(data,string);
	if(tail==null)
		head = tmp;
	else
		tail.setPointer(tmp);
	tail=tmp;
 }
 public synchronized String getData(int index)
 {
	CarNodes<T> current = head;
	 if(index<0)
	  return null;
	for(int i=0;i<index;i++)
	 current = current.getPointer();
    return current.getData();
 }
 public synchronized String getTime(int index)
 {
	CarNodes<T> current = head;
	if(index<0)
	 return null;
	for(int i =0;i<index;i++)
	 current = current.getPointer();
	return current.getTime();
 }
 public String toString()
 { 
	String line = "";
	CarNodes<T> current = head;
	while(current!=null)
	{
	 line+=current.getData().toString()+",";
	 current = current.getPointer();
	}
	return line;
 }
 public synchronized T remove()
 {
	T data1=null,data2=null;
    try{
	if(isEmpty()==true) 
	  throw new Exception("Cannot dequeue from an empty list!");
	data1 = (T) head.getData();
	data2 = (T)head.getTime();
	this.head = head.getPointer();
	}catch(Exception e){
	  e.getMessage();
	  System.out.println(e);
	  System.exit(0);
	}
	return (T) (data1+" "+data2);
  }
  public boolean isEmpty() 
  {
	return head == null;
  }	
  public int getCount()
  {
	return count;
  }
}

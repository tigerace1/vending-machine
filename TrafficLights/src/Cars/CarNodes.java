package Cars;

public class CarNodes<T> {
  private CarNodes<T> pointer;
  private String data;
  private String time;
  public CarNodes(String data, String time) 
  {
	super();
	this.pointer = null;
	this.data = data;
	this.time = time;
  }
  public void setPointer(CarNodes<T> pointer) 
  {
	this.pointer = pointer;
  }
  public void setData(String data,String time) 
  {
	this.data = data;
	this.time = time;
  }
  public CarNodes<T> getPointer() 
  {
	return pointer;
  }
  public String getData() 
  {
	return data;
  }
  public String getTime() 
  {
	return time;
  }
}

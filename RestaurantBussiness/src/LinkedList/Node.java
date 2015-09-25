package LinkedList;
public class Node {
  private String data;
  private Node pointer;
  public Node(String data2)
  {
	  this.data = data2;
	  pointer = null;
  }
  public void setData(String newData)
  {
	  this.data = newData;
  }
  public String getData()
  {
	  return data;
  }
  public Node getNext() 
  {  
	 return pointer;
  }
  public void setNext(Node temp) {
	 this.pointer = temp;
  }
}

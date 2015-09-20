package LinkedList;
public class FoodLL<Object> {
 private Node head;
 private int listCount;
 public FoodLL()
 {
  head = new Node(null);
  listCount = 0;
 }
 public void add(String data)
 {
  Node temp = new Node(data);
  Node current = head;
  this.head = temp;
  this.head.setNext(current);
  listCount++; 
 }
 public void addLast(String data)
 {
  Node temp = new Node(data);
  Node current = head;
  while(current.getNext()!=null)
	  current = current.getNext();
  current.setNext(temp);
  listCount++; 
 }
 public String getData(int index)
 {
  if(index < 0)
	return null;
  Node current = head.getNext();
  for(int i = 0; i < index; i++)
  {
	if(current.getNext() == null)
	  return null;
	current = current.getNext();
  }
  return  current.getData();
 } 
 public String toString()
 {
  Node current = head;
  String output = "";
  while(current != null)
  {
    if(current.getData()!=null)
	  output += current.getData().toString();
	current = current.getNext();
  }
  return output;
 }
}

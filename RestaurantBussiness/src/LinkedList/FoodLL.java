package LinkedList;
public class FoodLL<T> {
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
  if(index <0)
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
 public T remove()
 {
	 T element = null;
	 try{
	 if(isEmpty()) 
			throw new Exception("Cannot dequeue from an empty list!");
	 }
	 catch(Exception e)
	 {
		 e.getMessage();
		 System.exit(0);
	 }
	 element = (T) this.head.getData();
	 this.head = this.head.getNext();
	 return element;
 }
 public String toString()
 {
  Node current = head;
  String output = "";
  while(current != null)
  {
    if(current.getData()!=null)
	  output += current.getData().toString()+"\n";
	current = current.getNext();
  }
  return output;
 }
 public boolean isEmpty()
 {
  return this.head == null;
 }
 public int getCount()
 {
  return listCount;
 }
}

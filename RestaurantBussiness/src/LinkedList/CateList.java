package LinkedList;
public class CateList<T> {
 private CateNode head;
 private int listCount;
 private FoodLL<String> list;
 public CateList()
 {
	head = new CateNode(null,null);
	listCount = 0;
	list = new FoodLL<>();
 }
 public void add(String data,FoodLL<String> newList)
 {
  CateNode temp = new CateNode(data,newList);
  CateNode current = head;
  this.head = temp;
  this.list = newList;
  this.head.setNext(current);
  listCount++; 
 }
 public void addLast(String data,FoodLL<String> newList)
 {
  CateNode temp = new CateNode(data,newList);
  CateNode current = head;
  this.list = newList;
  while(current.getNext()!=null)
	current = current.getNext();
  current.setNext(temp);
  listCount++;
 }
 public String getData(int index)
 {
  if(index < 0)
	return null;
  CateNode current = head.getNext();
  for(int i = 0; i < index; i++)
  {
	if(current.getNext() == null)
	 return null;
	current = current.getNext();
  }
  return  current.getData();
 }
 public FoodLL<String> getList(int index)
 {
  if(index < 0)
	return null;
  CateNode current = head.getNext();
  for(int i = 0; i < index; i++)
  {
	if(current.getNext() == null)
	  return null;
	current = current.getNext();
  }
  return current.getList();	 
 }
 public String toString()
 {
  CateNode current = head;
  String output = "";
  while(current != null)
  {
   if(current.getList()!=null)
	 output += current.getList().toString();
   current = current.getNext();
  }
  return output;
 }
 public boolean isEmpty()
 {
  return this.head == null;
 }
 public T Remove() 
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
 }




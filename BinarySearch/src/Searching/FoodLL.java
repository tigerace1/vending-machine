package Searching;

public class FoodLL<T> {
  private LLNode<T>head;
  private LLNode<T>tail;
  private int count;
  public FoodLL()
  {
	head = null;
	tail = null;
	count=0;
  }
  public void setHead(LLNode<T> head)
  {
	this.head = head;
  }
  public void setTail(LLNode<T> tail)
  {
	this.tail = tail;
  }
  public void setCount(int count)
  {
	this.count = count;
  }
  private T setString(T data)
  {
    String[] ary = ((String)(data)).split("  ");
    return (T)ary[0];
  }
  public String Suggested(T data, int index)
  {
	String data2= (String) setString(getData(index));
	data = (T) ((String) data).toLowerCase();
	data2=data2.toLowerCase();
	int newV = ((String)data).length();
	int Long = 0;
	int a=0;
	if(newV<=1){
	for(int i=0;i<((String) data).length();i++)
	{
	  for(int j=a;j< data2.length();j++){
		if(data2.charAt(j)==((String) data).charAt(i)){
		  Long++;
		  a=i+1;
		  j=data2.length();
		}
	  }
	}
	}else{
	int j=0;
	for(int i=0;i<((String) data).length();i++)
	{
	  for(j=a;j< data2.length();j++){
	   if(data2.charAt(j)==((String) data).charAt(i)){
		 Long++;
		 a=i+1;
		 j=data2.length();
		 i=((String)data).length();
	   }
	  }
	}
	for(int i=1;i<((String)data).length();i++)
	{
	  if(data2.charAt(a)==((String)data).charAt(i)){
	    Long++;
		a++;
	  }else
		break;
	}
   }
   if(Long==((String) data).length())
	 return data2;
   else
	 return null;
 }
 public T getData(int index)
 {
   LLNode<T> node=head;	 
   if(index<0)
	 return null;
   for(int i=0;i<index;i++)
   {
	 node=node.getPointer();
   }
   return node.getData();
 }
 public void inOrderTree(Node<T> root)
 {	
    count=0; 
	inOrder(root);
 }
 public void preOrderTree(Node<T> root)
 {
	preOrder(root);
 }
 public void postOrderTree(Node<T> root)
 {
	postOrder(root);
 }
 private void preOrder(Node<T> tree)
 {
    if(tree==null)
      return;
    enqueue(tree.getData());
    preOrder(tree.getLeft());
    preOrder(tree.getRight());
 }
 private void postOrder (Node<T> tree)
 {
    if(tree==null)
	  return;
	postOrder(tree.getLeft());
	postOrder(tree.getRight());
	enqueue(tree.getData());
 }
 private void inOrder(Node<T> tree)
 {
	 if(tree==null)
	   return;
     inOrder(tree.getLeft());
	 enqueue(tree.getData());
	 inOrder(tree.getRight());
 }
 private void enqueue(T data)
 {
   LLNode<T>newNode = new LLNode<>(data);
   if(tail==null)
     head = newNode;
   else
	 tail.setPointer(newNode);
   tail = newNode;
   count++;
 }
 public String toString()
 {
   String line = "";
   LLNode<T> current = head;
   while(current!=null)
   {
	 line+=current.getData().toString()+",";
     current = current.getPointer();
   }
   return line;
 }
 public LLNode<T> getHead()
 {
   return head;
 }
 public LLNode<T> getTail()
 {
   return tail;
 }
 public int getCount()
 {
   return count;
 }
}

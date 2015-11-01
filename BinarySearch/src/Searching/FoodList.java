package Searching;
public class FoodList<T>{
 private int count;
 private Node<T> root;
 public FoodList()
 {
	root=null;
	count=0;
 }
 public void setRoot(Node<T>root)
 {
	this.root=root;
 }
 public void setCount(int count)
 {
	this.count=count;
 }
 private T setString(T data)
 {
   String[] ary = ((String)(data)).split("  ");
   return (T)ary[0];
 }
 /**Use binary search tree to search a data in the tree,
  * return the data if it is found, else return null*/
 public T bstSearch(T data)
 {
    Node<T> tmp = root;
    if(isEmpty())
    	return null;
    while(!((String)data).equalsIgnoreCase((String)setString(tmp.getData())))
    {
      int compare =((String)data).compareToIgnoreCase((String)setString(tmp.getData()));
      if(compare<0)
        tmp=tmp.getLeft();
      else 
    	tmp=tmp.getRight();
      if(tmp==null)
    	return null;
    }
    return data;
 }
 /**Add a new node into the tree*/
 public void bstAdd(T data)
 {
  Node<T>newNode = new Node<>(data);
  if(root==null){
	root = newNode;
	count++;
  }
  else{
    Node<T> focusNode=root;
    Node<T> parent;
    int compare =0;
	while(true)
	{
	  parent = focusNode;
	  compare = ((String)setString(data)).compareToIgnoreCase((String)setString(focusNode.getData()));
	  if(compare<=0){
		 focusNode = focusNode.getLeft();
		 if(focusNode==null){
			parent.setLeft(newNode);
			count++;
			return;
		 }
	  }else{
		 focusNode = focusNode.getRight();
		 if(focusNode==null){
		   parent.setRight(newNode);
		   count++;
		   return;
		 }
	  }
	}
  }
 }
 /**Remove one node from the tree*/
 public void remove(T data)
 {
   Node<T> preNode=null;
   Node<T>current = root;
   if(isEmpty())
	 return;
   else{
	 while(!((String)data).equalsIgnoreCase((String)setString(current.getData())))
	 {
	   preNode=current;
	   int compare =((String)data).compareToIgnoreCase((String)setString(current.getData()));
	   if(compare<0)
	     current=current.getLeft();
	   else 
	     current=current.getRight();
	   if(current==null)
	    return;
	 }
	 if(current.getLeft()==null&&current.getRight()==null)
	 {
	   if(((String)setString(current.getData())).compareToIgnoreCase((String)setString(preNode.getData()))<=0)
		 preNode.setLeft(null);
	   if(((String)setString(current.getData())).compareToIgnoreCase((String)setString(preNode.getData()))>0)
		 preNode.setRight(null); 
	 }
	 else if(current.getLeft()!=null&&current.getRight()==null)
	 {
	   if(((String)setString(current.getLeft().getData())).compareToIgnoreCase((String)setString(preNode.getData()))<=0)
		 preNode.setLeft(current.getLeft());
	   if(((String)setString(current.getLeft().getData())).compareToIgnoreCase((String)setString(preNode.getData()))>0)
		 preNode.setRight(current.getLeft()); 
	 }
	 else if(current.getRight()!=null&&current.getLeft()==null)
	 {
	   if(((String)setString(current.getRight().getData())).compareToIgnoreCase((String)setString(preNode.getData()))<=0)
		 preNode.setLeft(current.getRight());
	   if(((String)setString(current.getRight().getData())).compareToIgnoreCase((String)setString(preNode.getData()))>0)
		 preNode.setRight(current.getRight()); 
	 }
	 else{
	   Node<T> next = current.getLeft();
	   Node<T> find =null;
	   while(next.getRight()!=null)
	   {
		 find=next;
		 next=next.getRight();
	   }
	   T lines = next.getData();
	   current.setData(lines);
	   find.setRight(null);
	   if(next.getLeft()!=null)
		find.setRight(next.getLeft()); 
	 }
   }
   count--;
 }
 public boolean isEmpty()
 {
   return this.root==null;
 }
 public Node<T> getRoot()
 {
	return root;
 }
 public int getCount()
 {
	return count;
 }
}

package Searching;

public class Node<T> {
 Node<T> left;
 Node<T> right;
 private T data;
 public Node(T data)
 {
	this.data = data;
	left = null;
	right = null;
 }
 public void setLeft(Node<T> front)
 {
	this.left = front;
 }
 public void setRight(Node<T>back)
 {
	 this.right = back;
 }
 public void setData(T data)
 {
	this.data = data;
 }
 public Node<T> getLeft()
 {
	return left;
 }
 public Node<T> getRight()
 {
	 return right;
 }
 public T getData()
 {
   return data;
 }
}

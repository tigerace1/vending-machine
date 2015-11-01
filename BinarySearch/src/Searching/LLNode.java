package Searching;

public class LLNode<T> {
 private LLNode<T> pointer;
 private T data;
 public LLNode(T data)
 {
	this.data = data;
	pointer = null;
 }
 public LLNode<T> getPointer()
 {
	return pointer;
 }
 public void setPointer(LLNode<T> pointer)
 {
	this.pointer = pointer;
 }
 public T getData()
 {
	return data;
 } 
 public void setData(T data) 
 { 
	this.data = data;
 }
}

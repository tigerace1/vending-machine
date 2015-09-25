package LinkedList;
public class CateNode {
 private String data;
 private FoodLL<String> list;
 private CateNode pointer;
 public CateNode(String data2,FoodLL<String> object)
 {
    this.data = data2;
    pointer = null;
    this.list = object;
 }
 public void setData(String newData)
 {
    this.data = newData;
 }
 public void setList(FoodLL<String> newList)
 {
	 this.list = newList;
 }
 public FoodLL<String> getList()
 {
    return list;
 }
 public CateNode getNext() 
 {  
    return pointer;
 }
 public void setNext(CateNode temp) {
	this.pointer = temp;
 }
 public String getData() 
 {
	return data;
 }
}



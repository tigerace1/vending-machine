package Searching;

import static org.junit.Assert.*;

import org.junit.Test;

public class unitTexting {

	@Test
	public void test() {
	  FoodList<String> test1 = new FoodList<>();
	  FoodLL<String>test2; 
	  test2 = new FoodLL<>();
	  test1.bstAdd("d");
	  test1.bstAdd("b");
	  test1.bstAdd("f");
	  test1.bstAdd("a");
	  test1.bstAdd("c");
	  test1.bstAdd("g");
	  System.out.println(test1.getRoot().getLeft().getData());
	  test2.inOrderTree(test1.getRoot());
	  String result1 = test2.toString();
	  assertEquals("a,b,c,d,f,g,",result1);
	  test2 = new FoodLL<>();
	  test2.preOrderTree(test1.getRoot());
	  String result2 = test2.toString();
	  assertEquals("d,b,a,c,f,g,",result2);
	  test2 = new FoodLL<>();
	  test2.postOrderTree(test1.getRoot());
	  String result3 = test2.toString();
	  assertEquals("a,c,b,g,f,d,",result3);
	}

}

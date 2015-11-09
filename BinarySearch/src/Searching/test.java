package Searching;
/**Test class for the linked list*/
public class test {
 public static void main(String[] args) 
 {
   FoodList<String> test = new FoodList<>();
   FoodLL<String> Test = new FoodLL<>();
   test.bstAdd("s");
   test.bstAdd("d");
   test.bstAdd("a");
   test.bstAdd("w");
   test.bstAdd("r");
   test.bstAdd("f");
   test.bstAdd("e");
   System.out.println(test.getRoot().getData());
   System.out.println(test.bstSearch("Z"));
   Test.inOrderTree(test.getRoot());
   test.balance();
   System.out.println(test.bstSearch("Z"));
   System.out.println(test.getCount());
   System.out.println(Test.toString());
   System.out.println(Test.getData(0));
   System.out.println(Test.getData(1));
   System.out.println(Test.getData(2));
   System.out.println(Test.getData(3));
 }
}

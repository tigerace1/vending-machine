package Restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import LinkedList.CateList;
import LinkedList.FoodLL;

public class Test {
 private FoodLL<String>foodList; 
 private CateList<Object> cateList;
 public Test()
 {
	 foodList = new FoodLL<>();
	 cateList = new CateList<>();
 }
 private void setData(FoodLL<String>newList,CateList<Object>newCate)
 {
	this.foodList = newList;
	this.cateList = newCate;
 }
 void Restaurant() 
 {
    System.out.println("Here is the menu:");  
	FoodItem menu = new FoodItem();
    menu.readFoodCategory();
	int count =0;
	for(int i=0; i<menu.getCategoryCount();i++){
	  int j=0;
	  foodList = menu.getFoodCate().getList(i);
      while(foodList.getData(j)!=null)
	  {
	   String[] ary = foodList.getData(j).split(";");
	   System.out.println((count+1)+". Category: "+ary[0]+" name: "+ary[1]+" price: "+ary[2]+" quality: "+ary[3]+" size: "+ary[4]);
	   j++;
	   count++;
	  }
      cateList.addLast(menu.getFoodCate().getData(i), foodList);
      foodList = new FoodLL<>();
    }
 }
 void adding()
 {
    System.out.println("Adding a salad");
	EditorThree add = new EditorThree();
	add.addMenu("Salad;Home Salad;$6.99;Good;big;very good homestyle fresh salad");
	Restaurant();
 }
 void editing()
 {
	System.out.println("Editing the new salad");
	Editor edit = new Editor();
	edit.EditMenu("Salad","Home Salad","$5.69","Very goood","Mid","very good homestyle fresh salad","Home Salad  $6.99  Good  big");
	Restaurant();
 }
 void deleting()
 {
	System.out.println("Delete one salad");
	EditorTwo del = new EditorTwo();
	del.DeleteMenu("Home Salad  $6.99  Good  big");
	Restaurant();
 }
 void addCate()
 {
	System.out.println("Adding cake");
	EditorThree add = new EditorThree();
	add.AddCate("Cakes");
	add.addMenu("Cakes;Cup cake;$1.99;Good;big;very good");
    Restaurant();
 }
 void editCate()
 {
	System.out.println("Editing Cake to PanCake");
	Editor edit = new Editor();
	edit.EditCate("PanCake","Cakes");
	edit.EditMenu("PanCake","Egg Pan cake","$5.69","Very goood","Mid","very good pan cake","Cup cake  $1.99  Good  big");
	Restaurant();
 }
 void deleteCate()
 {
	System.out.println("Delete PanCake");
	EditorTwo del = new EditorTwo();
	del.DelCate("PanCake");
	Restaurant();
 }
 void remove()
 {
	String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
	int i=0;
	try{
	  Scanner inputStream = new Scanner(new File(fileName));
	  foodList = new FoodLL<>();
      while(inputStream.hasNextLine())
	  {
		  String line = inputStream.nextLine();
		  foodList.addLast(line);
		  System.out.println(line);
		  i++;
	  }
      inputStream.close();
	}
	catch(FileNotFoundException e)
	{
		System.exit(0);
	}
	System.out.println("Remove one line");
	foodList.Remove();
	for(int j=0;j<i-1;j++)
		System.out.println(foodList.getData(j));
 }
 void removeCate()
 {
    String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodCategorise.txt";
    int i =0;
	try{
	  Scanner inputStream = new Scanner(new File(fileName));
	  while(inputStream.hasNextLine())
	  {
		String line = inputStream.nextLine();
		cateList.addLast(line,null);
		System.out.println(line);
		i++;
	  }
	  inputStream.close();
	}
	catch(FileNotFoundException e)
	{
	 System.exit(0);
	}
	System.out.println("Remove one category");
	cateList.Remove();
    for(int j=0;j<i-1;j++)
    	System.out.println(cateList.getData(j));
 }
 public FoodLL<String> getFoodList()
 {
	 return foodList;
 }
 public CateList<Object> getCateList()
 {
	 return cateList;
 }
}

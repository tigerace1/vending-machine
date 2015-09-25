package LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testing {
  public static void main(String[] args)
  {
	  FoodLL foodCa = new FoodLL();
	  foodCa.addLast("ss");
	  foodCa.addLast("dd");
	  foodCa.addLast("gg");
	  System.out.println(foodCa.getData(3));
	  }
}

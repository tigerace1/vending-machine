package LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testing {
  public static void main(String[] args)
  {
	  FoodLL food = new FoodLL();
	  food.addLast("ss");
	  food.addLast("dd");
	  food.addLast("gg");
	  System.out.println(food.getData(2));
	  }
}

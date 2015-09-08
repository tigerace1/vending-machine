import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
public class Editing {
	private int[] SnackAmount;
	private int[] DrinkAmount;
	private int adding;
	private int num;
	public Editing()
	{
		SnackAmount = new int[10];
		DrinkAmount = new int[10];
		adding =0;
		num=0;
	}
	public void readSnackInfor()
	{
		String fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\editorOne.txt";
		Scanner inputStream =null;
		try{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file "+fileName);
			System.exit(0);
		}
		System.out.println("Snacks:");
		while(inputStream.hasNextLine())
		{
		   String line = inputStream.nextLine();
		   System.out.println(line);
		}
		inputStream.close();
	}
	public void readDrinkInfor()
	{
		String fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\editorTwo.txt";
		Scanner inputStream =null;
		try{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file "+fileName);
			System.exit(0);
		}
		System.out.println("Drinks: ");
		while(inputStream.hasNextLine())
		{
		   String line = inputStream.nextLine();
		   System.out.println(line);
		}
		inputStream.close();
	}
	public void readNumber()
	{
		String fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\out.txt";
		String file = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\int.txt";
		Scanner inputOne = null; 
		Scanner inputTwo = null;
		try{
			inputOne =new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the file "+fileName);
			System.exit(0);
		}
		try{
		    inputTwo = new Scanner(new File(file));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the file "+fileName);
			System.exit(0);
		}
		while(inputOne.hasNextInt())
		{
			for(int i=0;i<10;i++){
				int a = inputOne.nextInt();
				SnackAmount[i]=a;
			}
		}
		while(inputTwo.hasNextInt())
		{
			for(int i=0;i<10;i++){
				int b = inputTwo.nextInt();
				DrinkAmount[i]=b;
			}
		}
		inputOne.close();
		inputTwo.close();
	}
	private void setting(int NewNum, int NewAdding)
	{
		Scanner keyboard = new Scanner(System.in);
		int A=NewAdding+SnackAmount[NewNum-1];
		while(A>20)
		{
			System.out.println("Dispenser cannot hold more than 20\nEnter again:");
			NewAdding = keyboard.nextInt();
		}
		num=NewNum;
		NewAdding = adding;
    }
	public void Edit(String type)
	{
		Scanner keyboard = new Scanner(System.in);
	    switch(type){
		case "S":
		case "s":
			System.out.println("Enter the order number:");
			int NewNum = keyboard.nextInt();
			System.out.println("How many do you want to add:");
			int NewAdding = keyboard.nextInt();
			setting(NewNum,NewAdding);
			SnackAmount[num-1]=adding+SnackAmount[num-1];
			break;
		case "D":
		case "d":
			System.out.println("Enter the order number:");
			int newNum = keyboard.nextInt();
			System.out.println("How many do you want to add:");
			int newAdding = keyboard.nextInt();
			setting(newNum,newAdding);
			DrinkAmount[num-1]=adding+DrinkAmount[num-1];
			break;
		case "A":
		case "a":
			allFull();
			break;
	    default: 
	    	System.out.println("Unkonwn Command.");
	    	System.exit(0);
	    	break;
		}
	}
	public void allFull()
	{
		for(int i=0; i<10; i++)
		{
			SnackAmount[i]=20;
			DrinkAmount[i]=20;
		}
	}
	public void writeSnackInfor()
	{
		String fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\Snack.txt";
		String F = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\editorOne.txt";
		Scanner inputStream =null;
		PrintWriter Output = null;
		String Lines;
		int i=0;
		try
		{
		   inputStream = new Scanner(new File( fileName));
		   Output = new PrintWriter(F);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the file "+fileName);
			System.exit(0);
	    }
		while(inputStream.hasNextLine())
		{
		   Lines = inputStream.nextLine();
		   Output.println(Lines+"   ramain: "+SnackAmount[i]);
		   i++;
		  }
		  inputStream.close();
		  Output.close();
	}
	public void writeDrinkInfor()
	{
		String fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\Drink.txt";
		String F = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\editorTwo.txt";
		Scanner inputStream =null;
		PrintWriter Output = null;
		String Lines;
		int i=0;
		try
		{
		   inputStream = new Scanner(new File( fileName));
		   Output = new PrintWriter(F);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the file "+fileName);
			System.exit(0);
	    }
		while(inputStream.hasNextLine())
		{
		   Lines = inputStream.nextLine();
		   Output.println(Lines+"   ramain: "+DrinkAmount[i]);
		   i++;
		  }
		  inputStream.close();
		  Output.close();
		  System.out.println("Date has been written in");
	}
	public void writeNumber()
	{
		 String fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\out.txt";
		 PrintWriter outputOne = null;
		 try
		 {
			 outputOne = new PrintWriter(fileName);
		 }
		 catch(FileNotFoundException e)
		 {
			System.out.println("Cannot find the file "+fileName);
			System.exit(0);
		 }
		 for(int i=0;i<10;i++)
		 {
			 outputOne.println(SnackAmount[i]);
		 }
		 outputOne.close();
		 String FileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\int.txt";
		 PrintWriter outputStream = null;
		 try
		 {
		    outputStream = new PrintWriter(FileName);
		 }
		 catch(FileNotFoundException e)
		 {
			System.out.println("Cannot find the file "+FileName);
			System.exit(0);
		 }
		 for(int i=0;i<10;i++)
		 {
			outputStream.println(DrinkAmount[i]);
		 }
		 outputStream.close();
		System.out.println("Date has been written in: "+fileName+" and "+FileName);
	}
	public static void main(String[] args)
	{
		Editing edit = new Editing();
		Scanner keyboard = new Scanner(System.in);
		String Ans="";
		do{
		  edit.readSnackInfor();
		  edit.readSnackInfor();
		  edit.readNumber();
		  System.out.println("Which machine do you want to edit(enter S or D).\nOr Press A for all full:");
		  String ans =keyboard.next();
          edit.Edit(ans);
  		  edit.writeSnackInfor();
  		  edit.writeDrinkInfor();
  		  edit.writeNumber();
          System.out.println("Continute?");
		  Ans = keyboard.next();
		}while(Ans.equalsIgnoreCase("Y"));
        System.out.println("Snacks Machine:");
		edit.readSnackInfor();
		System.out.println("Drinks Machine:");
		edit.readDrinkInfor();
	}
	
}

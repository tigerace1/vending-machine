import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Dispenser {
  private int[] Dispenser;
  private String fileName;
  private static int index=0;
  public Dispenser()
  {
	  fileName="";
	  Dispenser = new int[index];
  }
  public void Input()
  {
	  fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\out.txt";
	  Scanner inputSnack = null;
	  try
	  {
		  inputSnack =  new Scanner(new File(fileName));
		int line=0, i=0; 
		while(inputSnack.hasNextInt())
		{
			line = inputSnack.nextInt();
			Dispenser[i]=line;
			i++;
		}
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file");
		  System.exit(0);
	  }
	  inputSnack.close();
  }
  public void setting()
  {
	  fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\Snack.txt";
	  Scanner inputStream = null;
	  try
	  {
		inputStream =  new Scanner(new File(fileName));
		while(inputStream.hasNextLine()){
	         index++;
	         String o=inputStream.nextLine();
	    }
		inputStream.close();
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file");
		  System.exit(0);
	  }
  }
  public void Output()
  {
	 fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\out.txt";
	 PrintWriter outputStream = null;
	 try
	 {
	    outputStream = new PrintWriter(fileName);
	 }
	 catch(FileNotFoundException e)
	 {
		System.out.println("Cannot find the file "+fileName);
		System.exit(0);
	 }
	 for(int i=0;i<10;i++)
	 {
		outputStream.println(Dispenser[i]);
	 }
	 outputStream.close();
  }
  public void counting(int num)
  {
	try{
		if(Dispenser[num]<1)
			throw new Exception("No more");
	    Dispenser[num]=Dispenser[num]-1;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		Scanner keyboard = new Scanner(System.in);
		VendingMachine SnackCost = new VendingMachine();
		System.out.println("Do you want another Choice.");
		int ans = (int)(Math.random());
		if(ans==0){
			SnackCost.choseSnacks();
		}else{
			Driver NEW = new Driver();
			NEW.display();
		}
	}
  }
  public void SnacksNumber()
  {
	  String fileName = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\Snack.txt";
	  String file = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\sold.txt";
	  String F = "C:\\Users\\Chengen\\Desktop\\VendingMachine\\editorOne.txt";
	  Scanner inputStream =null;
	  PrintWriter outputStream = null;
	  PrintWriter Output = null;
	  String Lines;
	  int i=0;
	  try
	  {
		 inputStream = new Scanner(new File( fileName));
		 outputStream = new PrintWriter(new FileOutputStream(file,true));
		 Output = new PrintWriter(F);
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("Cannot find the file "+fileName);
		  System.exit(0);
	  }
	  outputStream.println("Snacks:");
	  while(inputStream.hasNextLine())
	  {
		Lines = inputStream.nextLine();
		outputStream.println(Lines+"    remain: "+Dispenser[i]);
		Output.println(Lines+"   ramain: "+Dispenser[i]);
		i++;
	  }
	  inputStream.close();
	  outputStream.close();
	  Output.close();
  }
}

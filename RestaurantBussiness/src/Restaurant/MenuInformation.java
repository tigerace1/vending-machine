package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MenuInformation {
  private static String line;
  public MenuInformation()
  {
	  line = "";
  }
  private void setLine(String newLine)
  {
	  this.line = newLine;
  }
  public String displayInfor(String message)
  {
	 String file = "FoodItems.txt";
	 try{
	  Scanner input = new Scanner(new File(file));
	  while(input.hasNextLine())
	  {
		String newLine = input.nextLine();
		String[] ary = newLine.split(";");
		String d = ary[5];
		if(message.equals(setString(newLine)))
		  setLine(d);
	  }
	  input.close();
	 }
	 catch(FileNotFoundException e)
	 {
	  System.out.println("Cannot find the file "+file);
	  System.exit(0);
	 }
	 return line;
  }
  private String setString(String lines) 
  {
     String[] ary = lines.split(";");
     String name = ary[1];
     String price = ary[2];
     String quality = ary[3];
     String size = ary[4];
	 return name+"  "+price+"  "+quality+"  "+size;
  }
  public static String getLine()
  {
	  return line;
  }
  
}

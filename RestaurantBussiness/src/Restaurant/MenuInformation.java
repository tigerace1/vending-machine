package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MenuInformation {
  private static String line="";
  private String Description="";
  public String DisplayInfor(String message)
  {
	String fileName = "C:\\git\\RestaurantBussiness\\Menu\\FoodItems.txt";
	Scanner inputStream = null;
	try{
	  inputStream = new Scanner(new File(fileName));
	  while(inputStream.hasNextLine())
	  {
		String lines = inputStream.nextLine();
		String newlines = setString(lines);
		if(newlines.equals(message)){
		  String[] ary = lines.split(";");
		  line = ary[5];
		}
	  }
	  inputStream.close();
	}
	catch(FileNotFoundException e)
	{
	  System.out.println("Cannot find the file "+fileName);
	  System.exit(0);
	} 
    return line;
  }
  private String setString(String lines) 
  {
     String[] ary = lines.split(";");
     String name = ary[1];
     String prize = ary[2];
     String quality = ary[3];
     String size = ary[4];
	 return name+"  "+prize+"  "+quality+"  "+size;
  }
  public static String getLine()
  {
	  return line;
  }
  
}

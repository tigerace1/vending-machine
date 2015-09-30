package Restaurant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.record.formula.functions.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import LinkedList.CateList;
import LinkedList.FoodLL;
public class FoodItem implements Serializable{
  private FoodLL<String> FoodItem;
  private CateList<Object> foodCa;
  private int CategoryCount;
  private int FoodCount;
  public FoodItem()
  {
	FoodItem = new FoodLL<>();
	foodCa = new CateList<>();
	CategoryCount = 0;
	FoodCount = 0;
  }
  private void setFoodItem(FoodLL<String>FoodItem)
  {
    this.FoodItem = FoodItem;
  }
  private void setFoodCa(CateList<Object>foodCa)
  {
    this.foodCa = foodCa;
  }
  private void setCategoryCount(int CategoryCount)
  {
	this.CategoryCount = CategoryCount;
  }
  private void setFoodCount(int FoodCount)
  {
    this.FoodCount = FoodCount;
  }
  public void readFoodCategory()
  {
	String fileName = "FoodCategorise.txt";
	String file = "FoodItems.txt";
	try{
	  Scanner inputStream = new Scanner(new File(fileName));
	  while(inputStream.hasNextLine())
	  {
		String line = inputStream.nextLine();
		FoodCount=0;
		try{
		  Scanner input = new Scanner(new File(file));
		  while(input.hasNextLine())
		  {
			String newLine = input.nextLine();
			String[] ary = newLine.split(";");
			String a = ary[0];
			if(line.equals(a))
			  FoodItem.addLast(newLine);
			FoodCount++;
		  }
		  foodCa.addLast(line,FoodItem);
		  input.close();
		  FoodItem = new FoodLL<>();
		}
		catch(FileNotFoundException e)
		{
		  System.exit(0);
		}
		CategoryCount++;
	  }
	  inputStream.close();
	 }
	 catch(FileNotFoundException e)
	 {
	  System.out.println("Cannot find the file "+fileName);
	  System.exit(0);
	 }
  }
  public void readExcel()
  {
	  String fileName = "Menu.xls";
	  List sheetData = new ArrayList();
	  FileInputStream inputStream = null;
	  try{
		inputStream = new FileInputStream(fileName);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator rows = sheet.rowIterator();
		while(rows.hasNext())
		{
		  HSSFRow row = (HSSFRow) rows.next();
		  Iterator cells = row.cellIterator();
		  List data = new ArrayList();
		  while(cells.hasNext())
		  {
			HSSFCell cell = (HSSFCell)cells.next();
			data.add(cell);
		  }
		  sheetData.add(data);
		}
		inputStream.close();
	  }
	  catch(IOException e)
	  {
		e.printStackTrace();
	  }
	  showExcelData(sheetData);
  }
  public void readFoods()
  {
	 ObjectInputStream inputStream = null;
	 String fileName = "Food.dat";
	 try{
		inputStream = new ObjectInputStream(new FileInputStream(fileName));
	 }
	 catch(IOException e)
	 {
		System.out.println("Cannot find the file "+fileName);
		System.exit(0);
	 }
	 try{
		String f = (String) inputStream.readObject(); 
		System.out.println(f);
		inputStream.close();
	 }
	 catch(Exception e)
	 {
		System.exit(0);
	 }
  }
  public void writeExcel()
  {
	 String fileName = "Menu.xls";
	 FileOutputStream outputStream = null;
	 try{
	   outputStream = new FileOutputStream(fileName);
	   HSSFWorkbook book = new HSSFWorkbook();
	   HSSFSheet sheet = book.createSheet("Menu");
	   int k=0;
	   for(int i=0;i<getCategoryCount();i++)
	   {
	     FoodItem=foodCa.getList(i);
	     int j=0;
	     while(FoodItem.getData(j)!=null)
	     {
	      HSSFRow heading = sheet.createRow(k);
	      String[] ary = FoodItem.getData(j).split(";");
	      heading.createCell(0).setCellValue(ary[0]);
	      heading.createCell(1).setCellValue(ary[1]);
	      heading.createCell(2).setCellValue(ary[2]);
	      heading.createCell(3).setCellValue(ary[3]);
	      heading.createCell(4).setCellValue(ary[4]);
	      heading.createCell(5).setCellValue(ary[5]);
	      j++;
	      k++;
	    }
	  }
	  book.write(outputStream);
	  outputStream.close();
	 }
	 catch(IOException e)
	 {
	   System.out.println("Cannot write in Execl");
	   System.exit(0);
	 }
  }
  public void writeFoods()
  {
	 ObjectOutputStream outputStream = null;
	 String fileName = "Food.dat";
	 try{
		outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
	 }
	 catch(IOException e)
	 {
	    System.out.println("Cannot find the file "+fileName);
		System.exit(0);
	 }
	 try{
		outputStream.writeObject(foodCa.toString()); 
		outputStream.flush();
		outputStream.close();
	 }
	 catch(IOException e)
	 {
		System.exit(0);
	 }
  }
  private static void showExcelData(List sheetData) 
  { 
	for (int i = 0; i < sheetData.size(); i++) 
	{
	 List list = (List) sheetData.get(i);
	 for (int j = 0; j < list.size(); j++) 
	 {
	   Cell cell = (Cell) list.get(j);
	   if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
		 System.out.print(cell.getNumericCellValue());
	   } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
		 System.out.print(cell.getRichStringCellValue());
	   } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
		 System.out.print(cell.getBooleanCellValue());
	   }
	   if (j < list.size() - 1) {
		 System.out.print(", ");
	   }
	 }
	 System.out.println("");
    }
  }
 
  public FoodLL<String> getFoodItems()
  {
	 return FoodItem;
  }
  public CateList<Object> getFoodCate()
  {
	 return foodCa;
  }
  public int getCategoryCount()
  {
	 return CategoryCount;
  }
  public int getFoodCount()
  {
	 return FoodCount;
  } 
}


public class polymorphismDemo {
  public static void main(String[] args)
  {
	  Employee[] person = new Employee[3];
	  person[0]  = new Employee(9527,"Math and secience");
	  person[1]  = new Staff(8653,"Fine art",10);
	  person[2]  = new Faculty(8693,"Computer secience",12,"Professor of Computer secience");
	  for(Employee p: person)
	  {
		  p.writeOutput();
		  System.out.println();
	  }
  }
}

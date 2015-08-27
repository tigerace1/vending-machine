
public class Employee {
  private int ID;
  private String department;
  public Employee()
  {
	  ID=0;
	  department = "";
  }
  public Employee(int newID, String newDepartment)
  {
	  ID = newID;
	  department = newDepartment;
  }
  public void setData(int newID, String newDepartment)
  {
	  ID = newID;
	  department = newDepartment;
  }
  public int getID()
  {
	  return ID;
  }
  public String getDepartment()
  {
	  return department;
  }
  public void writeOutput()
  {
	  System.out.println("ID: "+ID);
	  System.out.println("Department: "+department);
  }
}


public class student extends Person implements Comparable{
  private String studentNumber;
  public student()
  {
	  super();
	  studentNumber = "";
  }
  public student(String newName, String newNumber)
  {
	  super(newName);
	  studentNumber =newNumber;
  }
  public void reset(String newName, String newNumber)
  {
	  setName(newName);
	  studentNumber = newNumber;
  }
  public String getStudentNumber()
  {
	  return studentNumber;
  }
  public void setStudentNumber(String newStudentNumber)
  {
	  studentNumber = newStudentNumber;
  }
  public void writeOutput()
  {
	  writeOutput();
	  System.out.println("Student Number: "+ getStudentNumber());
  }
  
  public int compareTo(Object o)
  {
	
	 if((o!=null)&& o instanceof student)
	 {
		 student other = (student)o;
		 return(getStudentNumber().compareTo(other.getStudentNumber()));
	 }
	 return -1;
  }
 
}

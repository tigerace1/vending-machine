
public class Faculty extends Staff{
  private String title;
  public Faculty()
  {
	  super();
  }
  public Faculty(int newID, String newDepartment, int newPayGrade, String newTitle)
  {
	  super(newID, newDepartment, newPayGrade);
	  title = newTitle;
  }
  public void reset(int newID, String newDepartment, int newPayGrade, String newTitle)
  {
	  super.reset(newID, newDepartment, newPayGrade);
	  title = newTitle;
  }
  public void setTitle(String newTitle)
  {
	  title = newTitle;
  }
  public String getTitle()
  {
	  return title;
  }
  public void writeOutput()
  {
	  super.writeOutput();
	  System.out.println("Title: "+title);
  }
}

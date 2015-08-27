import java.util.Scanner;
public class SchoolKid {
  private String name;
  private int age;
  private String teacherName;
  private String greeting;
  public SchoolKid()
  {
	  name = "";
	  age = 0;
	  teacherName ="";
	  greeting = "";
  }
  public SchoolKid(String newName, int newAge, String newTeacher, String newGreeting)
  {
	  setData(newName, newAge, newTeacher, newGreeting);
  }
  public void setName(String newName)
  {
	  setData(newName,age,teacherName, greeting);
  }
  public void setAge(int newAge)
  {
	  setData(name,newAge,teacherName, greeting);
  }
  public void setTeacher(String newTeacher)
  {
	  setData(name,age, newTeacher,greeting);
  }
  public void setGreeting(String newGreeting)
  {
	  setData(name, age, teacherName, newGreeting);
  }
  private void setData(String newName, int newAge, String newTeacher, String newGreeting)
  {
	  Scanner keyboard = new Scanner(System.in);
	  name = newName;
	  while(newAge<0)
	  {
		  System.out.println("ERROR: age cannot be negative!");
		  System.out.println("Enter again:");
		  newAge = keyboard.nextInt();
	  }
	  age = newAge;
	  teacherName = newTeacher;
	  greeting = newGreeting;
  }
  public String getName()
  {
	  return name;
  }
  public int getAge()
  {
	  return age;
  }
  public String getTeacherName()
  {
	  return teacherName;
  }
  public String getGreeting()
  {
	  return greeting;
  }
  public void WriteOutput()
  {
	  System.out.println("Kid's name: "+ name);
	  System.out.println("Kid's age: "+ age);
	  System.out.println("The teacher's name: "+ teacherName);
	  System.out.println("Greeting: "+ greeting);
  }
}

import java.util.Scanner;
public class ExaggeratingKid extends SchoolKid {
  public ExaggeratingKid()
  {
	 super();
  }
  public ExaggeratingKid(String newName, int newAge, String newTeacher, String newGreeting)
  {
	  super(newName, newAge, newTeacher, newGreeting);
  }
  public int getAge()
  {
	 return super.getAge()+2;
  }
  public String getGreeting()
  {
	  return "I am the best "+super.getGreeting();
  }
  public void WriteOutput()
  {
	  super.WriteOutput();
	  System.out.println("ExageratingKid's age: "+getAge());
	  System.out.println("ExageratingKid;s greeting: "+ getGreeting());
  }
  public static void main(String[] args)
  {
	  Scanner keyboard = new Scanner(System.in);
	  SchoolKid oneKid = new ExaggeratingKid();
	  System.out.println("Kid's name:");
	  String newName = keyboard.nextLine();
	  oneKid.setName(newName);
	  System.out.println("The teacher's name:");
	  String newTeacher = keyboard.nextLine();
	  oneKid.setTeacher(newTeacher);
	  System.out.println("Kid's age: ");
	  int newAge = keyboard.nextInt();
	  oneKid.setAge(newAge);
	  System.out.println("The Greeting:");
	  String greeting = keyboard.nextLine();
	  String newGreeting = keyboard.nextLine();
	  oneKid.setGreeting(newGreeting);
	  oneKid.WriteOutput();
  }
}

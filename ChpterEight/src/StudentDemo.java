import java.util.Arrays;
public class StudentDemo {
  public static void main(String[] args)
  {
	  Person[] schooler = new student[5];
	  schooler[0] = new student("Warren Pease", "1236");
	  schooler[1] = new student("Manny Cotty","9932");
	  schooler[2] = new student("Anita kick", "8812");
	  schooler[3] = new student("June Bugg", "9901");
	  schooler[4] = new student("Robin DeBanque","4910");
	  Arrays.sort(schooler);
	  for(Person s: schooler)
	  {
		 System.out.println(s.getName());
		 System.out.println(((student) s).getStudentNumber());
	  }
	  
  }
}

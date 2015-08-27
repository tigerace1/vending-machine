
public class Staff extends Employee{
	private int payGrade;
	public Staff()
	{
		super();
		payGrade = 0;
	}
	public Staff(int newID, String newDepartment, int newPayGrade)
	{
		super(newID,newDepartment);
		payGrade = newPayGrade;
	}
	public void reset(int newID, String newDepartment, int newPayGrade)
	{
		super.setData(newID, newDepartment);
		setPayGrade(newPayGrade);
	}
	public void set(int newPayGrade)
	{
		payGrade = newPayGrade;
	}
	private void setPayGrade(int newPayGrade)
	{
		if(newPayGrade<1||newPayGrade>20)
		{
			System.out.println("ERROR!");
			System.exit(0);
		}
		else
			payGrade =newPayGrade;
    }
	public int getPayGrade()
	{
		return payGrade;
	}
	public void writeOutput()
	{
		super.writeOutput();
		System.out.println("Pay grade: " +payGrade);
	}
}

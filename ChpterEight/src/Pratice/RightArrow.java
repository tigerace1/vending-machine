package Pratice;

 public class RightArrow extends ShapeBase{
	private char[][] star = new char[7][21];
	public RightArrow()
    {
	 super();
    }
	public void wirteArrowHead()
	{
		for(int j=0;j<7;j++)
		{
		  if(j<3)
			star[j][14+j*2]='*';
		  else if(j>3)
			star[j][26-j*2]='*';
		}
		for(int i=0; i<7;i++)
	      star[i][14]='*';
	    star[3][20]='*';
	}
	public void writeArrowTail()
	{
	   for(int J=0;J<=14;J++)
	      star[3][J]='*';
	}
	public void writeBlank()
	{
		for(int i = 0; i<=20;i++)
		{
			for(int j=0;j<7;j++)
			{
			   if(star[j][i]!='*')
				  star[j][i]=' ';
			}
		}
	}
    public void writeOutput()
    {
	  wirteArrowHead();
	  writeArrowTail();
	  writeBlank();
	  for(int j=0;j<7;j++)
	  {
		 for(int i=0;i<=20;i++)
		    System.out.print(star[j][i]);
		 System.out.println();
	  }
   }
   public void setOffset(int newOffset) {
	// TODO Auto-generated method stub
	
   }
   public int getOffset() {
	// TODO Auto-generated method stub
	return 0;
   }
   public void drawHere() {
	// TODO Auto-generated method stub
   }
   public static void main(String[] args)
   {
	 RightArrow one = new RightArrow();
	 one.writeOutput();
   }
}

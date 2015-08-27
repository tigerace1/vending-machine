package Pratice;

public abstract class ShapeBase implements ShapeInterFace {
  private int offset;
  public abstract void drawHere();
  public void drawAt(int lineNumber)
  {
	  for(int count = 0; count <lineNumber; count++)
		  System.out.println();
	  drawHere();
  }
}

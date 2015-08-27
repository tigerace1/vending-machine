package Pratice;
public class SubstitutionCipher implements MessageEncoder{
	private int shift;
	private char[] code;
	private String Text="";
	public SubstitutionCipher(int Shift)
	{
		shift = Shift;
	}
	public void setShift(int newShift)
	{
		shift = newShift;
	}
    private void setCode(String newPlainText)
	{
    	code = new char[newPlainText.length()];
	    for(int i =0; i<code.length;i++)
	    {
	    	code[i]=newPlainText.charAt(i);
	    	code[i] =(char)((int)code[i]+shift);
	    	Text+=code[i];
	    }
	}
	public String encode(String plainText) {
	    setCode(plainText);
		return Text;
	}
}

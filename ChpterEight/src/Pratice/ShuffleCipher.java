package Pratice;

public class ShuffleCipher implements MessageEncoder{
  private int n;
  private char[] letter;
  private char[] newLetter;
  private int middle;
  private String Text="";
  public ShuffleCipher(int N)
  {
	  n = N;
  }

  public String encode(String plainText) 
  {
	  int J=0;
	  while(J<=n)
	  {
		 setLetter(plainText);
		 for(int i=0;i<letter.length;i++)
		 {
	       if(i%2!=0)
	         newLetter[i]=letter[middle+i-i/2];
	       else
	         newLetter[i]=letter[i/2];
	     }
		 for(int j=0;j<letter.length;j++)
		 {
		   Text+=newLetter[j];
		 }
		 plainText = Text;
		 Text ="";
		 J++;
	  }
	  return plainText;
  }
  private void setLetter(String newPlainText)
  {
	  letter = new char[newPlainText.length()];
	  newLetter = new char[newPlainText.length()+1];
	  double Middle = newPlainText.length()/2;
	  middle = (int)Math.ceil(Middle);
	  for(int i=0;i<letter.length;i++)
		  letter[i]=newPlainText.charAt(i);
  }
   public static void main(String[] args)
  {
	  ShuffleCipher one = new ShuffleCipher(2);
	  String plainText ="abcdefghi";
	  System.out.println(one.encode(plainText));
	  
  }
}

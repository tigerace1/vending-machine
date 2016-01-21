package TexingTwo;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
public class NodeJSText {
   Aggression aggData;
   public static void main(String[] args){
	 String b="abcd";
	 String c="picture";
	 String d="(9.00,9.08)";
	 Aggression data = new Aggression(10,b,c,d);
     Gson gson = new Gson();
     String string = gson.toJson(data);
     System.out.println(string.toString());
     Aggression output=gson.fromJson(string, Aggression.class);
     System.out.println(output.getId());
     try{
       URL url = new URL("http://45.55.182.4:3000/setJsonAggression");
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	   conn.setDoOutput(true);
       conn.setRequestMethod("POST");
	   OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
	   writer.write(string);
	   writer.flush();
	   writer.close();
     }catch(Exception e){
    	 e.printStackTrace();
     }
  }
 }
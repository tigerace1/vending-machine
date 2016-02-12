package TexingTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import com.google.gson.Gson;
public class NodeJSText{
   Aggression aggData;
   public static void main(String[] args) throws Exception{
	 String b="abcd";
	 String c="picture";
	 String d="(9.00,9.08)";
      try{
    	 KeyStore keystore = KeyStore.getInstance("JKS");;
    	 String algorithm = TrustManagerFactory.getDefaultAlgorithm();
    	 TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
    	 tmf.init(keystore);
         SSLContext context = SSLContext.getInstance("TLS");
    	 context.init(null, tmf.getTrustManagers(), null);
         Aggression data = new Aggression(b,10,c,d);
         Gson gson = new Gson(); 
         String string = gson.toJson(data);
         System.out.println(string);
         URL url = new URL("https://crowdsafes.com/androidTest");
         HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
         conn.setRequestMethod("POST");
         conn.setRequestMethod("GET");
         conn.setDoOutput(true);
         conn.setDoInput(true);
         OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
         writer.write(string);
         writer.flush();
         writer.close();
         String inputLine="09";
         BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         while ((inputLine = in.readLine())!= null) 
        	 System.out.println("Haha: "+inputLine);
         in.close();
         conn.disconnect();
     }catch(IOException e){
         e.printStackTrace();
     }
  }
 }
 
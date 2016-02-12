package TexingTwo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import com.google.gson.Gson;
public class HttpsTest {
	public static void main(String[] args){
		try {
			withoutCertTest("https://crowdsafes.com/androidTest");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void withoutCertTest(String urlStr) throws Exception {  
	    SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
	    TrustManager[] tms = { ignoreCertificationTrustManger };  
	    sslContext.init(null, tms, new java.security.SecureRandom());  
	    SSLSocketFactory ssf = sslContext.getSocketFactory();  
	    URL url = new URL(urlStr);    
	    HttpsURLConnection conn = ((HttpsURLConnection) url.openConnection());  
	    conn.setSSLSocketFactory(ssf);
	    conn.setDoOutput(true);
	    conn.setRequestMethod("POST");
	    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(),"GBK");
	    Aggression data = new Aggression("AA",10,"OO","KOKL");
        Gson gson = new Gson(); 
        String string = gson.toJson(data);
        System.out.println(string);
	    writer.write(string);
        writer.flush();
        writer.close();
        HttpsURLConnection conn2 = ((HttpsURLConnection) url.openConnection());  
	    conn2.setSSLSocketFactory(ssf);
	    conn2.setDoInput(true);
	    conn2.setRequestMethod("GET");
	    InputStreamReader im = new InputStreamReader(conn2.getInputStream(),"GBK");  
	    BufferedReader reader = new BufferedReader(im);  
	    StringBuffer sb = new StringBuffer();  
	    String line = "";  
	    while ((line = reader.readLine()) != null) {  
	        sb.append(line + "\r\n");  
	    }  
	    System.out.println(sb);
	    im.close();
	}  
	private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {  
	  
	    private X509Certificate[] certificates;  
	    @Override  
	    public void checkClientTrusted(X509Certificate certificates[],  
	            String authType) throws CertificateException {  
	        if (this.certificates == null) {  
	            this.certificates = certificates;  
	        }  
	    }  
	    @Override  
	    public void checkServerTrusted(X509Certificate[] ax509certificate,  
	            String s) throws CertificateException {  
	        if (this.certificates == null) {  
	            this.certificates = ax509certificate;  
	        }  
	    }  
	    @Override  
	    public X509Certificate[] getAcceptedIssuers() {  
	        return null;  
	    }  
	    
	};  
}

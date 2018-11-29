package global_utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Random;


public class random_email {
	
	public String random_email_genrator()
	{
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		String randomemail="userchandna"+ randomInt +"@mailinator.com";
		return randomemail;
	}

	public String random_email_registor()
	{
		String randomemail = null;
		 try {
			String url = "https://www.mailinator.com/manyauth/many_signup";
			 randomemail=random_email_genrator();
			 String urlParameters = "email="+randomemail+"&password=abc@123&optin=true";
			 byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			
			 URL myurl = new URL(url);
			 HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
			 con.setDoOutput(true);
			 con.setRequestMethod("POST");
			 con.setRequestProperty("User-Agent", "Java client");
			 con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			 try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
			     wr.write(postData);
			 }
			 
			 StringBuilder content;

			 try (BufferedReader in = new BufferedReader(
			         new InputStreamReader(con.getInputStream()))) {

			     String line;
			     content = new StringBuilder();

			     while ((line = in.readLine()) != null) {
			         content.append(line);
			         content.append(System.lineSeparator());
			     }
			 }

			 System.out.println(content.toString());
			 con.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return randomemail;
		 
		 
	}
}

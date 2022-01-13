package ud3.practica1.e2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ReadW3 {
	
	public static void main(String[] args) {
		
		try {
			
			URL url = new URL("http://google.com");
			URLConnection urlConnection = url.openConnection();
			InputStream inputStream = urlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = bufferedReader.readLine()) != null) {
				System.out.println(inputLine);
			}
			bufferedReader.close();
		
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
	}

}

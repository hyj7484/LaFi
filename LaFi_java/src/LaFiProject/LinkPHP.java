package LaFiProject;

import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

public class LinkPHP {	
	private static String urlFile = "http://localhost:8080/lafi/JAVAPHP/";
	
	static String con(String getURL) {

		URL url = null;
		HttpURLConnection conn = null;
		String jsonData = "";
		BufferedReader br = null;
		StringBuffer sb = null;
		String returnText = "";

		try {
			url = new URL(getURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("POST");
			conn.connect();

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			sb = new StringBuffer();
			while((jsonData = br.readLine()) != null) {
				sb.append(jsonData);
			}

			returnText = sb.toString();


		}catch(IOException e) {
			e.printStackTrace();

		}finally {
			try {
				if(br != null) br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(returnText);
		return returnText;
	}
	
	static String postCon(String getURL) {
		String urlPHP = urlFile+getURL+".php";
		System.out.println(urlPHP);
		String returnText = con(urlPHP);
		return returnText;
	}
	
	static String getCon(String getURL, String get) {
		String urlPHP = urlFile+getURL+".php?"+get;
		String returnText = con(urlPHP);
		return returnText;
	}

}

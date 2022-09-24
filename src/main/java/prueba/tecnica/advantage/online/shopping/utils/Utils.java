package Prueba.Tecnica.Advantage.Online.Shopping.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Utils {
	
	public static JSONObject jsonObject;
	
	public static void generarData() {
		try {

			URL url = new URL("https://random-data-api.com/api/users/random_user?size=1");// your url i.e fetch data from .
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				jsonObject = new JSONObject(output.replace("[", "").replace("]", ""));
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
	}
	
	public static void main(String[] args) {
		generarData();
	}

}

package TAA.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


public class GetMeteo {
	
	public static void GetByCity(String cityName) {
		
		String url = "https://www.prevision-meteo.ch/services/json/";
		
		url += cityName;
		
		try (CloseableHttpClient client = HttpClientBuilder.create().build()){
			
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			
			if(response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("HTTP error code : "
				+ response.getStatusLine().getStatusCode());
			}
			
			BufferedReader br =
					new BufferedReader(
							new InputStreamReader(
									(response.getEntity().getContent())));
			
			String output;
			System.out.println("Output fro server : \n");
			while ((output = br.readLine())!= null) {
				System.out.println(output);
			}
			
			client.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}

}

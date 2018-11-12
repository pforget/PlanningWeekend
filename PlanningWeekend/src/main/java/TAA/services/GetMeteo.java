package TAA.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meteo")
@CrossOrigin
public class GetMeteo {
	
	public static String GetByCity(String cityName) {
		
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
			int cpt =0;
		    StringBuilder sb = new StringBuilder();
			while ((output = br.readLine())!= null) {
				System.out.println(cpt);
				System.out.println(output);
				System.out.println("BLEEEEEEEEEEEEEEEH");
				sb.append(output);
			}			
			JSONObject json = new JSONObject(sb.toString());
			System.out.println(json);
			System.out.println("fdsfs");
			System.out.println(json.get("city_info").toString());
			//json.writeJSONString(sb);
			client.close();

			return br.toString(); // json.getAsString("city_info");
			
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@RequestMapping(value="/concarn",method=RequestMethod.GET, produces="application/json")
	public String GetConcarnMeteo() {
		return GetByCity("concarneau");
	}

}

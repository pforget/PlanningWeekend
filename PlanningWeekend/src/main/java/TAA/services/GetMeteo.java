package TAA.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import TAA.entities.Location;
import TAA.entities.Weather;

@RestController
@RequestMapping("/meteo")
@CrossOrigin
public class GetMeteo {
	@Autowired 
	LocationService loc;
	
	public static Weather GetByCity(String cityName) {
		
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
			//json.writeJSONString(sb);
			JSONObject wenInfo = (JSONObject)json.get("fcst_day_4"); //J+4 because we call this wednersday
			System.out.println("wednersday");

			System.out.println(wenInfo.toString());
			JSONObject hourlyData = (JSONObject) wenInfo.get("hourly_data");
			System.out.println("byhour");

			System.out.println(hourlyData);

			JSONObject h10 = (JSONObject) hourlyData.get("10H00");
			
			System.out.println("10h");

			System.out.println(h10);

			String condition = h10.getString("CONDITION");
			int winSpeed = h10.getInt("WNDSPD10m");
			int temp = h10.getInt("TMP2m");//.toString();
			String image = h10.getString("ICON");
			
			Weather weather = new Weather(temp, winSpeed, condition, image);


			client.close();
			return weather;
		//	return h10; //br.toString(); // json.getAsString("city_info");
			
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@RequestMapping(value="/concarn",method=RequestMethod.GET, produces="application/json")
	public void GetConcarnMeteo() {
		 Weather concarnWeather = GetByCity("concarneau");
		 Location concarneau = loc.getByCityName("concarneau");
		 concarneau.setWeather(concarnWeather);
		 return;
	}

}

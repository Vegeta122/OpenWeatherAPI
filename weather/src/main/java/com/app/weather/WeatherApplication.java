package com.app.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.net.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.*;

@SpringBootApplication
public class WeatherApplication {

	public static Map<String,Object> jsonToMap(String str){
		Map<String,Object> map=new Gson().fromJson(str,new TypeToken<HashMap<String,Object>>(){}.getType());
		return map;
	}
	
	public static void main(String args[]){
		SpringApplication.run(WeatherApplication.class, args);
		String API_KEY="453a89695cfd505d694bdce149a5fbd4";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a city name");
		String LOCATION=sc.nextLine();
		sc.close();
		String urlString="http://api.openweathermap.org/data/2.5/weather?q="+ LOCATION +"&appid="+ API_KEY +"&units=metric";
		try{
			StringBuilder result = new StringBuilder();
			URL url=new URL(urlString);
			URLConnection conn=url.openConnection();
			BufferedReader rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
		while((line=rd.readLine()) != null){
			result.append(line);
		}
		rd.close();
		// System.out.println(result);
		
		Map<String,Object> respMap=jsonToMap(result.toString());
		Map<String,Object> mainMap=jsonToMap(respMap.get("main").toString());
		Map<String,Object> windMap=jsonToMap(respMap.get("wind").toString());
		
		System.out.println("Current Temperature: "+mainMap.get("temp"));
		System.out.println("Pressure: "+mainMap.get("pressure"));
		System.out.println("Humidity: "+mainMap.get("humidity"));
		System.out.println("Speed of Wind: "+windMap.get("speed"));
		System.out.println("Gust: "+windMap.get("gust"));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}

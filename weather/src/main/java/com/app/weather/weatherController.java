package com.app.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class weatherController {

    @RequestMapping(value="/getJson", method=RequestMethod.GET)
    public Map<String,Object> getJson(@RequestParam String city) {
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
            return respMap;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }  
    }

    public static Map<String,Object> jsonToMap(String str){
		Map<String,Object> map=new Gson().fromJson(str,new TypeToken<HashMap<String,Object>>(){}.getType());
		return map;
	}
    
    
}

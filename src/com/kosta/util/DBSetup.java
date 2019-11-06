
package com.kosta.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class DBSetup {
		
    public static void main(String[] args) {
    	
    	
        BufferedReader br = null;
        try{            
            String urlstr = "http://openapi.seoul.go.kr:8088/6f57446b58616e663130316d764b4157/json/octastatapi581/1/5/";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
   
            
            String line = null;
            String str = null;
            while ((line = br.readLine()) != null) {
               str = line;             
               
               }

        	JsonParser parser = new JsonParser();
        	JsonObject obj = (JsonObject) parser.parse(str);
        	JsonObject parse_response = (JsonObject) obj.get("octastatapi581");
        	JsonArray parse_item = (JsonArray) parse_response.get("row");
        	JsonObject weather = (JsonObject) parse_item.get(0);
        	
        	
        	Connection con = DbUtil.getConnection(); 
        	
//        	String[] strArray = {"합계","강력범,","절도범","폭력범","지능범","풍속범","기타형사범","특별법범"};
//        	List<a> list = new ArrayList<a>();
        	
        	for(int i =0; i<8 ;i++) {
        		
        		String temp1 = weather.get("BALSAENG_"+i).toString();
        		String temp2 = weather.get("GEOMGEO_"+i).toString();
        		
        		

        		String sql = "insert into IDNAME values (?,?,?)";
            	PreparedStatement ps = con.prepareStatement(sql);
            	
            	if(i==0) {
            		ps.setString(1,"99");
            	} else {
                	ps.setString(1,Integer.toString(i-1));
            	}
            	
            	ps.setInt(2, Integer.parseInt(temp1.replace("\"","")) );
            	ps.setInt(3, Integer.parseInt(temp2.replace("\"","")) );
            	
            	ps.executeUpdate();
        		
//        		list.add(new a(i,temp3,temp4));  
        	}
        	
//        	for(a aa : list) {
//        		System.out.println(aa);
//        	}
        	
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
    }
}



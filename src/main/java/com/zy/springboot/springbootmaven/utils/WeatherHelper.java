package com.zy.springboot.springbootmaven.utils;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WeatherHelper {

    public static void main(String[] args) throws Exception{
        System.out.println(getWeather("101120301"));
    }

    /**
     * 获取网站
     * @param cityid
     * @return
     * @throws Exception
     */

    public static Map<String,String> getWeather(String cityid) throws Exception{
        String weather = "";
        URLConnection connection;
        BufferedReader br ;
        StringBuilder sb = null;

        //连接中央气象台
        URL url = new URL("http://www.weather.com.cn/data/cityinfo/" + cityid + ".html");
        connection = url.openConnection();
        connection.setConnectTimeout(1000);
        try{
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            sb = new StringBuilder();
            String line = br.readLine();
            while(line != null){
                sb.append(line);
                line = br.readLine();
            }
        }catch (Exception e){
                e.printStackTrace();
        }
        weather = sb.toString();
        System.out.println(weather);
        JSONObject jsonObject = JSONObject.parseObject(weather);
        JSONObject jsonWeather = jsonObject.getJSONObject("weatherinfo");
        Map<String,String> weatherInfo = new HashMap<String,String>();
        weatherInfo.put("cityId",jsonWeather.getString("cityid"));
        weatherInfo.put("cityName",jsonWeather.getString("city"));
        weatherInfo.put("weather", jsonWeather.getString("weather"));
        return weatherInfo;
    }
}

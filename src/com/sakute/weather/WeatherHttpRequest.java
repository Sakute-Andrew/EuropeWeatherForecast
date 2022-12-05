package com.sakute.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpRequest {

  public static boolean weatherRequets(String city) {
    String requestPath = "https://api.openweathermap.org/data/2.5/weather?q=" + city
        + "&limit=1&appid=3ab8bb892479dae143abd99020ed6f53&lang=ua&units=metric";
    HttpURLConnection request = null;
    try {
      request = (HttpURLConnection) new URL(requestPath).openConnection();
      request.setRequestMethod("GET");
      request.setUseCaches(false);
      request.connect();
      StringBuilder sb = new StringBuilder();
      if (HttpURLConnection.HTTP_OK == request.getResponseCode()) {
        BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
          sb.append(line);
        }
        CityWeather.displayCityWeather(sb.toString(), city);
        return true;
      } else {
        System.out.println(
            "Request error " + request.getResponseCode() + ", " + request.getResponseMessage());
        return false;
      }
    } catch (Throwable cause) {
      System.out.println("No internet connection!");
    } finally {
      if (request != null) {
        request.disconnect();

      }
    }
    return true;
  }
}

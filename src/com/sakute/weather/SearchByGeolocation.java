package com.sakute.weather;

import io.ipgeolocation.api.IPGeolocationAPI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SearchByGeolocation {
  public static void getIpAddress() {

    try {
      IPGeolocationAPI api = new IPGeolocationAPI("d82ebadf91bd45619baa54cda0dec43b");
      URL ipApi = new URL("https://ipapi.co/" +api.getGeolocation().getIPAddress()+ "/city/");
      URLConnection connection = ipApi.openConnection();
      connection.setRequestProperty("User-Agent", "java-ipapi-v1.02");
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      WeatherHttpRequest.weatherRequets(reader.readLine());
      reader.close();
    } catch (MalformedURLException e) {
      System.out.println("Не вдалося встановити зв'язок з сервером");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}

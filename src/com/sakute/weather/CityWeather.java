package com.sakute.weather;

import com.sakute.entities.User.AutConfirm;
import com.sakute.entities.WeatherObjects;
import java.io.IOException;
import java.text.SimpleDateFormat;
import com.google.gson.Gson;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class CityWeather extends WeatherObjects {
  public static boolean displayCityWeather(String sb, String city) throws IOException {
    Gson gson = new Gson();
    Root gatherRootData = gson.fromJson(sb, Root.class);
    Date dateNow = new Date();
    SimpleDateFormat nowDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss zzz");
    final DateTimeFormatter geoInfo = DateTimeFormatter.ofPattern("HH:mm:ss zzz");

    for (String s : Arrays.asList(
        "Wether in " + gatherRootData.getName() + ", " + gatherRootData.getSys().getCountry() + " as of " + nowDateFormat.format(dateNow),
        gatherRootData.getWeather().toString(),
        "Temperature now: " + Math.round(gatherRootData.getMain().getTemp()) + "°C",
        "Feels like: " + Math.round(gatherRootData.getMain().getFeels_like()) + "°C",
        "Night temperature: " + Math.round(gatherRootData.getMain().getTemp_min()) + "°C",
        "Day temperature: " + Math.round(gatherRootData.getMain().getTemp_max()) + "°C",
        "Pressure: " + gatherRootData.getMain().getPressure() + "mm by mercury column",
        "Humidity: " + gatherRootData.getMain().getHumidity() + "%",
        "Wind speed: " + gatherRootData.getWind().getSpeed() + " m/s",
        "Wind direction: " + gatherRootData.getWind().getDeg() + "° by azimuth",
        "Gusts of wind: " + gatherRootData.getWind().getGust() + " м/с",
        "Sunrise: " + Instant.ofEpochSecond(gatherRootData.getSys().getSunrise()).atZone(ZoneId.of("GMT+2")).format(geoInfo),
        "Sunset: " + Instant.ofEpochSecond(gatherRootData.getSys().getSunset()).atZone(ZoneId.of("GMT+2")).format(geoInfo),
        "Atmospheric visibility: " + gatherRootData.getVisibility() / 1000 + " Km",
        "")){
      System.out.println(s);
    }

    if (AutConfirm.isConfirmed() != true){
      System.out.println("History not recorded.User is unauthorized!");
      return false;
    }
    if (!HistoryWriter.isWriteValid(gatherRootData, dateNow, nowDateFormat)){
      return false;
    }
    return true;
  }

}

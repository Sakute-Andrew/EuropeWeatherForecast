package com.sakute.weather;

import com.sakute.entities.User;
import com.sakute.entities.User.AutConfirm;
import com.sakute.entities.WeatherObjects;
import java.io.File;
import java.io.FileWriter;
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
        "Погода в " + city + ", " + gatherRootData.getSys().getCountry() + " станом на " + nowDateFormat.format(dateNow),
        gatherRootData.getWeather().toString(),
        "Температура повітря зараз: " + Math.round(gatherRootData.getMain().getTemp()) + "°C",
        "Відчувається як: " + Math.round(gatherRootData.getMain().getFeels_like()) + "°C",
        "Температура вночі: " + Math.round(gatherRootData.getMain().getTemp_min()) + "°C",
        "Температура вдень: " + Math.round(gatherRootData.getMain().getTemp_max()) + "°C",
        "Тиск: " + gatherRootData.getMain().getPressure() + "мм за ртутним стовпчиком",
        "Вологість повітря: " + gatherRootData.getMain().getHumidity() + "%",
        "Швидкість вітру: " + gatherRootData.getWind().getSpeed() + " м/с",
        "Напрямок вітру: " + gatherRootData.getWind().getDeg() + "° по азимуту",
        "Пориви вітру: " + gatherRootData.getWind().getDeg() + " м/с",
        "Схід сонця: " + Instant.ofEpochSecond(gatherRootData.getSys().getSunrise()).atZone(ZoneId.of("GMT+2")).format(geoInfo),
        "Захід сонця: " + Instant.ofEpochSecond(gatherRootData.getSys().getSunset()).atZone(ZoneId.of("GMT+2")).format(geoInfo),
        "Атмосферна видимість: " + gatherRootData.getVisibility() / 1000 + " км",
        "")){
      System.out.println(s);
    }

    if (AutConfirm.isConfirmed() != true){
      return false;
    }
    File folder = new File("historyview");
    if (!folder.exists()) {
      folder.mkdir();
    }
    String filename =  "historyview\\" + User.getLogin() + ".txt";
    System.out.println(filename);
    FileWriter fr = new FileWriter(filename,true);
    fr.write(city +", "+gatherRootData.getSys().getCountry()+ ", " +  nowDateFormat.format(dateNow) + "\n");
    fr.close();
    return true;
  }

}

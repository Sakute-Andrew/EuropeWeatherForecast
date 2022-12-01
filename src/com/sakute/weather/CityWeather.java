package com.sakute.weather;

import static java.nio.file.StandardOpenOption.APPEND;

import com.sakute.entities.User;
import com.sakute.entities.User.AutConfirm;
import com.sakute.entities.WeatherObjects.Root;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import com.google.gson.Gson;
import java.util.Arrays;

public class CityWeather {
  public static boolean displayCityWeather(String sb, String city) throws IOException {
    Gson gson = new Gson();
    Root gatherRootData = gson.fromJson(sb, Root.class);

    LocalDate date = LocalDate.now();
    int day = date.getDayOfMonth();
    int month = date.getMonthValue();
    int year = date.getYear();

    for (String s : Arrays.asList(
        "Погода в " + city + ", " + gatherRootData.getSys().getCountry() + " станом на " + day + "."
            + month + "." + year,
        "Температура повітря зараз: " + Math.round(gatherRootData.getMain().getTemp()) + "°C",
        "Відчувається як: " + Math.round(gatherRootData.getMain().getFeels_like()) + "°C",
        "Температура вночі: " + Math.round(gatherRootData.getMain().getTemp_min()) + "°C",
        "Температура вдень: " + Math.round(gatherRootData.getMain().getTemp_max()) + "°C",
        "Тиск: " + gatherRootData.getMain().getPressure() + "мм за ртутним стовпчиком",
        "Вологість повітря: " + gatherRootData.getMain().getHumidity() + "%",
        "Швидкість вітру: " + gatherRootData.getWind().getSpeed() + " м/с")) {
      System.out.println(s);
    }

    if (AutConfirm.isConfirmed() != true){
      return false;
    }
    String filename =  "src/com/sakute/historyview/"+ User.getLogin() + ".txt";
    FileWriter fr = new FileWriter(filename,true);
    fr.write(city +", "+gatherRootData.getSys().getCountry()+ ", " + day + "." + month+ "." + year +"\n");
    fr.close();
    return true;
  }

}

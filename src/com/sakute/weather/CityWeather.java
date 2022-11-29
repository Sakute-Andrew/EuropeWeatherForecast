package com.sakute.weather;

import com.sakute.entities.WeatherObjects.Root;
import java.time.LocalDate;

import com.google.gson.Gson;

public class CityWeather {
  public static void displayCityWeather(String sb) {
    Gson gson = new Gson();
    Root gatherRootData = gson.fromJson(sb, Root.class);

    LocalDate date = LocalDate.now();
    int day = date.getDayOfMonth();
    int month = date.getMonthValue();
    int year = date.getYear();

    System.out.println("Погода в " + gatherRootData.getName() +", "+gatherRootData.getSys().getCountry()+" станом на " + day + "." + month+ "." + year);
    System.out.println("Температура повітря зараз: " + Math.round(gatherRootData.getMain().getTemp()) + "°C");
    System.out.println("Відчувається як: " + Math.round(gatherRootData.getMain().getFeels_like()) + "°C");
    System.out.println("Температура вночі: " + Math.round(gatherRootData.getMain().getTemp_min()) + "°C");
    System.out.println("Температура вдень: " + Math.round(gatherRootData.getMain().getTemp_max()) + "°C");
    System.out.println("Тиск: " + gatherRootData.getMain().getPressure() + "мм за ртутним стовпчиком");
    System.out.println("Вологість повітря: " + gatherRootData.getMain().getHumidity() + "%");
    System.out.println("Швидкість вітру: " + gatherRootData.getWind().getSpeed() + "%");








  }

}

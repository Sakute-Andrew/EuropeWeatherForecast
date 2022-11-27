package com.sakute.json;

import com.google.gson.Gson;
import com.sakute.entities.City;
import java.io.FileReader;

public class LocationReader {
  public City parsing() {
    Gson gson = new Gson();
    try(FileReader reader = new FileReader("coordinates.json")){
      City city = gson.fromJson(reader, City.class);
      System.out.println(city);
      return city;

    }
    catch (Exception e){
      System.out.println("Помилка читання файлу JSON" + e.toString());
    }
    return null;
  }

}

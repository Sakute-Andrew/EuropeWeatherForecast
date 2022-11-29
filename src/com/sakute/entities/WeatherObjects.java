package com.sakute.entities;

import java.util.ArrayList;

public class WeatherObjects {
  // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
  public class Clouds{
    public int all;

    public int getAll() {
      return all;
    }

    public void setAll(int all) {
      this.all = all;
    }
  }

  public class Coord{
    public double lon;
    public double lat;

    public double getLat() {
      return lat;
    }

  }

  public class Main{
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;

    public double getTemp() {
      return temp;
    }

    public double getFeels_like() {
      return feels_like;
    }

    public double getTemp_min() {
      return temp_min;
    }

    public double getTemp_max() {
      return temp_max;
    }

    public int getPressure() {
      return pressure;
    }

    public int getHumidity() {
      return humidity;
    }

    public void setTemp(double temp) {
      this.temp = temp;
    }

    public void setFeels_like(double feels_like) {
      this.feels_like = feels_like;
    }

    public void setTemp_min(double temp_min) {
      this.temp_min = temp_min;
    }

    public void setTemp_max(double temp_max) {
      this.temp_max = temp_max;
    }

    public void setPressure(int pressure) {
      this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
      this.humidity = humidity;
    }
  }

  public class Root{
    Coord coord;
    public ArrayList<Weather> weather;
    public String base;
     Main main;
    public int visibility;
     Wind wind;
     Clouds clouds;
    public int dt;
     Sys sys;
    public int timezone;
    public int id;
     String name;
    public int cod;

    public Coord getCoord() {
      return coord;
    }

    public ArrayList<Weather> getWeather() {
      return weather;
    }

    public String getBase() {
      return base;
    }

    public Main getMain() {
      return main;
    }

    public int getVisibility() {
      return visibility;
    }

    public Wind getWind() {
      return wind;
    }

    public Clouds getClouds() {
      return clouds;
    }

    public int getDt() {
      return dt;
    }

    public Sys getSys() {
      return sys;
    }

    public int getTimezone() {
      return timezone;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public int getCod() {
      return cod;
    }

    public void setCoord(Coord coord) {
      this.coord = coord;
    }

    public void setWeather(ArrayList<Weather> weather) {
      this.weather = weather;
    }

    public void setBase(String base) {
      this.base = base;
    }

    public void setMain(Main main) {
      this.main = main;
    }

    public void setVisibility(int visibility) {
      this.visibility = visibility;
    }

    public void setWind(Wind wind) {
      this.wind = wind;
    }

    public void setClouds(Clouds clouds) {
      this.clouds = clouds;
    }

    public void setDt(int dt) {
      this.dt = dt;
    }

    public void setSys(Sys sys) {
      this.sys = sys;
    }

    public void setTimezone(int timezone) {
      this.timezone = timezone;
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setCod(int cod) {
      this.cod = cod;
    }
  }

  public class Sys{
    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public int getSunrise() {
      return sunrise;
    }

    public void setSunrise(int sunrise) {
      this.sunrise = sunrise;
    }

    public int getSunset() {
      return sunset;
    }

    public void setSunset(int sunset) {
      this.sunset = sunset;
    }
  }

  public class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getMain() {
      return main;
    }

    public void setMain(String main) {
      this.main = main;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getIcon() {
      return icon;
    }

    public void setIcon(String icon) {
      this.icon = icon;
    }
  }

  public class Wind{
    public double speed;
    public int deg;

    public double getSpeed() {
      return speed;
    }

    public void setSpeed(double speed) {
      this.speed = speed;
    }

    public int getDeg() {
      return deg;
    }

    public void setDeg(int deg) {
      this.deg = deg;
    }
  }



}
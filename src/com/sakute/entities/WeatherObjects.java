package com.sakute.entities;

import java.util.ArrayList;

public class WeatherObjects {
  public class Clouds{
    private int all;

    public int getAll() {
      return all;
    }

    public void setAll(int all) {
      this.all = all;
    }
  }

  public class Main{
    private  double temp;
    private  double feelsLike;
    private  double temp_min;
    private  double temp_max;
    private  int pressure;
    private  int humidity;

    public double getTemp() {
      return temp;
    }

    public double getFeels_like() {
      return feelsLike;
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

    public void setFeelsLike(double feels_like) {
      this.feelsLike = feelsLike;
    }

    public void setTempMin(double temp_min) {
      this.temp_min = temp_min;
    }

    public void setTempMax(double temp_max) {
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
    private  ArrayList<Weather> weather;
    private  String base;
     Main main;
    private  int visibility;
     Wind wind;
     Clouds clouds;
    public int dt;
     Sys sys;
    private int timezone;
    private  int id;
     String name;
    private  int cod;

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
    private  int type;
    private  int id;
    private  String country;
    private  int sunrise;
    private  int sunset;

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

    private  String main;
    private  String description;

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

  }

  public class Wind{
    private  double speed;
    private  int deg;

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

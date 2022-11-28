package com.sakute.entities;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class City {

  @SerializedName("name")
  private String cityName;
  @SerializedName("local_names")
  ArrayList<String> localNames;
  private  String lat;
  private String lon;
  private  String country;

  private String state;

  City(String lat,String lon,String country,String cityName, ArrayList<String> localNames,String state){
    this.cityName = cityName;
    this.localNames = localNames;
    this.lat = lat;
    this.lon = lon;
    this.country = country;
    this.state = state;
  }

  public City() {

  }

  public String getState() {
    return state;
  }

  public String getLat() {
    return lat;
  }

  public String getLon() {
    return lon;
  }

  public String getCityName() {
    return cityName;
  }

  public String getCountry() {
    return country;
  }

  public ArrayList<String> getLocalNames() {
    return localNames;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setLocalNames(ArrayList<String> localNames) {
    this.localNames = localNames;
  }

}

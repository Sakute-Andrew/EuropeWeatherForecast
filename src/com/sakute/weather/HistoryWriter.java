package com.sakute.weather;

import com.sakute.entities.User;
import com.sakute.entities.WeatherObjects;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryWriter extends WeatherObjects {
  public  static boolean isWriteValid(Root gatherRootData,  Date dateNow,
      SimpleDateFormat nowDateFormat){
    try {
    File folder = new File("historyview");
    if (!folder.exists()) {
      folder.mkdir();
    }
    String filename =  "historyview\\" + User.getLogin() + ".txt";
    FileWriter fr = new FileWriter(filename,true);
    fr.write(gatherRootData.getName() +", "+ gatherRootData.getSys().getCountry() + ", " +  nowDateFormat.format(dateNow) + "\n");
    fr.close();
    return true;
    }catch (IOException ex){
      return false;
    }
  }

}

package com.sakute.json;

import com.google.gson.Gson;
import com.sakute.authentification.User;
import java.io.FileReader;

public class GsonParser {
  public User parse() {
    Gson gson = new Gson();
    try(FileReader reader = new FileReader("users.json")){
      User user = gson.fromJson(reader, User.class);
      System.out.println(user);
      return user;

    }
    catch (Exception e){
      System.out.println("Помилка читання файлу JSON" + e.toString());
    }
    return null;
  }

}

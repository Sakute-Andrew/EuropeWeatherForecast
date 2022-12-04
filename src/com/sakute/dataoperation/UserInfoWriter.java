package com.sakute.dataoperation;

import com.sakute.entities.User;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserInfoWriter {
  public static boolean writeUserInfo(String userLogin, String hashedPassword) {
    try {
      String filename = "users.txt";
      Path path = Paths.get(filename);

      FileWriter writer = new FileWriter(filename,true);

      InputStream reader = Files.newInputStream(path);
      BufferedReader userReader = new BufferedReader(new InputStreamReader(reader));

      String userData;
      String login;

      while ((userData = userReader.readLine()) != null) {
        String[] account = userData.split(",");
        login = account[0];
        if (login.equals(userLogin)) {
          System.out.println("Такий акаунт існує!!!!");
          return false;
        }
      }

      writer.write(userLogin + "," + hashedPassword + "\n");
      User.setLogin(userLogin);
      writer.close();
      reader.close();
      userReader.close();
      System.out.println("Ви зареєструвались як користувач:" + userLogin);
      return true;

      }catch (Exception e){
      System.out.println("Помилка запису!!!");
      return false;
    }

  }
}

package com.sakute.data_operation;

import com.sakute.entities.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserInfoWriter {
  public static boolean writeUserInfo(User newUser) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
      String filename = "users.txt";
      Path path = Paths.get(filename.toString());
      InputStream reader = Files.newInputStream(path);
      BufferedReader userReader = new BufferedReader(new InputStreamReader(reader));
      String userData, login;
      while ((userData = userReader.readLine()) != null) {
        String[] account = userData.split(",");
        login = account[0];
        if (login.equals(newUser.getLogin())) {
          System.out.println("Такий акаунт існує!!!!");
          return false;
        }
      }
      writer.write(newUser.getLogin() + "," + newUser.getPassword() + "\n");
      writer.close();
        System.out.println("Ви зареєструвались як користувач:" + newUser.getLogin());
        return true;
      }catch (Exception e){
      System.out.println("Помилка запису!!!");
      return false;
    }

  }
}

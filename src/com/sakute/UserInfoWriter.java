package com.sakute;

import com.sakute.authentification.User;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class UserInfoWriter {
  public static boolean writeUserInfo(User newUser) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
      writer.write(newUser.getLogin());
      writer.write("\n" + newUser.getPassword() + "\n");
      writer.close();
        System.out.println("Ви зареєструвались як користувач:" + newUser.getLogin());
        return true;
      }catch (Exception e){
      System.out.println("Помилка запису!!!");
      return false;
    }

  }
}

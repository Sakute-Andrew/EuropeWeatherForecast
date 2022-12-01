package com.sakute.dataoperation;

import static java.nio.file.StandardOpenOption.APPEND;

import com.sakute.entities.User;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UserInfoWriter {
  public static boolean writeUserInfo(User newUser) {
    try {
      String filename = "users.txt";
      Path path = Paths.get(filename);

      OutputStream output = new BufferedOutputStream(Files.newOutputStream(Path.of(filename), new StandardOpenOption[]{APPEND}));
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

      InputStream reader = Files.newInputStream(path);
      BufferedReader userReader = new BufferedReader(new InputStreamReader(reader));

      String userData;
      String login;

      while ((userData = userReader.readLine()) != null) {
        String[] account = userData.split(",");
        login = account[0];
        if (login.equals(newUser.getLogin())) {
          System.out.println("Такий акаунт існує!!!!");
          return false;
        }
      }

      writer.write(newUser.getLogin() + "," + newUser.getPassword());
      User.setLogin(newUser.getLogin());
      writer.newLine();
      writer.close();
      reader.close();
      userReader.close();
      output.close();
      System.out.println("Ви зареєструвались як користувач:" + newUser.getLogin());
      return true;

      }catch (Exception e){
      System.out.println("Помилка запису!!!");
      return false;
    }

  }
}

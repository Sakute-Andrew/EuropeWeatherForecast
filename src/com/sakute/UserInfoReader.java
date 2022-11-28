package com.sakute;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserInfoReader {

  public static boolean readFile(String userLogin, String hashedUserPassword) {
    try {
        String filename = "users.txt";
        Path path = Paths.get(filename.toString());
        InputStream reader = Files.newInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(reader));
        String line, user, pass;
      while ((line = br.readLine()) != null) {
        String[] account = line.split(",");
        user = account[0];
        pass = account[1];
        if (user.equals(userLogin) && pass.equals(hashedUserPassword)) {
          System.out.println("Успішний вхід в аккаунт! Вітаємо " + userLogin);
          return true;
        }else {System.out.println("Неправильний логін чи пароль!Спробуйте ще раз!");
        return false;
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Файл не знайдено!Створюю файл...");
      try {
        FileWriter fw = new FileWriter("users.txt");
      } catch (IOException e) {
        System.out.println("Не можу створити файл!");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return false;
  }

}

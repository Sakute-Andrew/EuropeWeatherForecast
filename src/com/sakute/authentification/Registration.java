package com.sakute.authentification;

import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.IOException;

public class Registration {
  public static void registrationProcess(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введіть логін: ");
    String userLogin = scanner.nextLine();
    System.out.println("Введіть пароль: ");
    String userPassword = scanner.next();
    if (UserPasswordValidation.isValidPassword(userPassword, userLogin)){
      String sha256hex = Hashing.sha256()
          .hashString(userPassword, StandardCharsets.UTF_8)
          .toString();
      User newUser = new User(userLogin, sha256hex);
      Registration.userRegistration(newUser);
    }
  }
  public static void userRegistration(User newUser){
    String filePath = "users.json";
    Gson gson = new GsonBuilder().create();
    String text = gson.toJson(newUser);
    System.out.println(newUser);
    File file = new File(filePath);
    FileWriter fr = null;
      try {
        fr = new FileWriter(file,true);
        fr.write(text);

      } catch (IOException e) {
        System.err.println("Помилка в записі!!!Перевірьте цілісніть JSON файлу!!!");
        e.printStackTrace();
      }finally{
        try {
          fr.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }



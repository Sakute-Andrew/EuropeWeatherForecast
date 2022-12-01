package com.sakute.authentification;

import com.google.common.hash.Hashing;
import com.sakute.dataoperation.UserInfoReader;
import java.nio.charset.StandardCharsets;

public class Authentication {
  public static boolean authentificationProcess(String userLogin,String userPassword) {
    if (userLogin == null || userPassword == null){
      System.out.println("Пароль і логін не можуть бути пусті!!!");
      return false;
    }
    String hashedUserPassword = Hashing.sha256().hashString(userPassword, StandardCharsets.UTF_8).toString();
    return UserInfoReader.readFile(userLogin, hashedUserPassword);
  }
}

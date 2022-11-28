package com.sakute.authentification;

import com.google.common.hash.Hashing;
import com.sakute.UserInfoReader;
import java.nio.charset.StandardCharsets;

public class Authentification {
  public static boolean authentificationProcess(String userLogin,String userPassword) {
    System.out.println("Stage2");
    String hashedUserPassword = Hashing.sha256().hashString(userPassword, StandardCharsets.UTF_8).toString();
    if (!UserInfoReader.readFile(userLogin, hashedUserPassword)){
      return false;
    }else {
      return true;
    }






  }
}

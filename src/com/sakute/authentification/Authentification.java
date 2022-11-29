package com.sakute.authentification;

import com.google.common.hash.Hashing;
import com.sakute.data_operation.UserInfoReader;
import java.nio.charset.StandardCharsets;

public class Authentification {
  public static boolean authentificationProcess(String userLogin,String userPassword) {
    String hashedUserPassword = Hashing.sha256().hashString(userPassword, StandardCharsets.UTF_8).toString();
    if (!UserInfoReader.readFile(userLogin, hashedUserPassword)){
      return false;
    }
      return true;
  }
}

package com.sakute.authentification;

import com.google.common.hash.Hashing;
import com.sakute.UserInfoWriter;
import java.nio.charset.StandardCharsets;


public class Registration {
  public static boolean registrationProcess(String userLogin,String userPassword){
    if (!UserPasswordValidation.isValidPassword(userPassword, userLogin)){
      return false;
    }else {
      String sha256hex = Hashing.sha256()
          .hashString(userPassword, StandardCharsets.UTF_8)
          .toString();
      User newUser = new User(userLogin, sha256hex);
      UserInfoWriter.writeUserInfo(newUser);
      return true;
    }
  }
  }



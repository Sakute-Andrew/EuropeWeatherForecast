package com.sakute.authentification;

import com.google.common.hash.Hashing;
import com.sakute.dataoperation.UserInfoWriter;
import com.sakute.dataoperation.UserPasswordValidation;
import com.sakute.entities.User;
import java.nio.charset.StandardCharsets;


public class Registration {
  public static boolean registrationProcess(String userLogin, String userPassword){
    if (!UserPasswordValidation.isValidPassword(userPassword, userLogin)){
      return false;
    }
      String hashedPassword = Hashing.sha256().hashString(userPassword, StandardCharsets.UTF_8).toString();
    User newUser = new User(userPassword, hashedPassword);
     if (!UserInfoWriter.writeUserInfo(newUser)) {
       return false;
     }
      return true;
  }
  }



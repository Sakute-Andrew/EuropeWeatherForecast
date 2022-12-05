package com.sakute.dataoperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPasswordValidation {
  public static boolean isValidPassword(String password, String login)
  {
    if (password.equals(login)) {
      System.out.println("Password and Login cannot be the same!!!");
      return false;
    }
    if (password.length() < 8 || login.length() <= 4) {
      System.out.println("Password and Login cannot be less than 8 and 4 values, respectively!!!");
      return false;
    }
    if (password.length() > 20 || login.length() > 20) {
      System.out.println("Password and Login cannot be more than 20 values respectively!!!");
      return false;
    }
    String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(password);
    return m.matches();
  }


}

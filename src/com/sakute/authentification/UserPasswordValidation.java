package com.sakute.authentification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPasswordValidation {
  public static boolean isValidPassword(String password, String login)
  {
    if (password.length() < 8 || login.length() < 4) {
      System.out.println("Пароль та Логін не можуть бути меншими за 8 та 4 значень відповідно!!!");
      return false;
    }
    // Regex to check valid password.
    String regex = "^(?=.*[0-9])"
        + "(?=.*[a-z])(?=.*[A-Z])"
        + "(?=.*[@#$%^&+=])"
        + "(?=\\S+$).{8,20}$";
    // Compile the ReGex
    Pattern p = Pattern.compile(regex);
    // Pattern class contains matcher() method
    // to find matching between given password
    // and regular expression.
    Matcher m = p.matcher(password);
    // Return if the password
    // matched the ReGex
    return m.matches();

  }


}

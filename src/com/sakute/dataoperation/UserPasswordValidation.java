package com.sakute.dataoperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPasswordValidation {
  public static boolean isValidPassword(String password, String login)
  {
    if (password.length() < 8 || login.length() < 4) {
      System.out.println("Пароль та Логін не можуть бути меншими за 8 та 4 значень відповідно!!!");
      return false;
    }
    if (password.length() > 20 || login.length() > 20) {
      System.out.println("Пароль та Логін не можуть бути меншими за 20 значень відповідно!!!");
      return false;
    }
    if (password.equals(login)) {
      System.out.println("Пароль та Логін не можуть бути однаковими!!!");
      return false;
    }
    String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(password);
    return m.matches();
  }


}

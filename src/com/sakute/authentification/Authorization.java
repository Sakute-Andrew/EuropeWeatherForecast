package com.sakute.authentification;

import com.sakute.json.GsonParser;
import java.util.Scanner;

public class Authorization {
  public static void authorizationProcess() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введіть логін: ");
    String userLogin = scanner.nextLine();
    System.out.println("Введіть пароль: ");
    String userPassword = scanner.next();
    GsonParser parser = new GsonParser();
    User user = parser.parse();



  }
}

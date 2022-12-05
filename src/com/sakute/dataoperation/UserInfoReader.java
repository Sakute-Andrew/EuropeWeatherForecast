package com.sakute.dataoperation;

import com.sakute.entities.User;
import java.io.BufferedReader;
import java.io.FileReader;

public class UserInfoReader {

  public static boolean readFile(String userLogin, String hashedUserPassword) {

    try {
      FileReader fileReader = new FileReader("users.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String currentLine;
      String data[];
      while ((currentLine = bufferedReader.readLine()) != null) {
        data = currentLine.split(",");
        if (data[0].equals(userLogin) && data[1].equals(hashedUserPassword)) {
          User.setLogin(userLogin);
          return true;
        }else if (data[0].equals(userLogin)){
          System.out.println("Wrong password or login!");
          return false;
        }


      }
      return false;
    } catch (Exception e){
      System.out.println("No user is registered! Do this to log in!");
    }
    return false;
  }
}

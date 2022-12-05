package com.sakute.weather;

import com.sakute.entities.User;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchHistory {
  public static boolean historyDisplay(){
    try {
      FileReader list = new FileReader("historyview\\"+ User.getLogin() + ".txt");
      String symbol = ",";
      String[] listdata;
      Scanner scan = new Scanner(list);
      while (scan.hasNextLine()) {
        listdata = scan.nextLine().split(symbol);
        System.out.println(
            " | Date " + listdata[2] + " | Country: " + listdata[1] + " | City/Region: " + listdata[0]);
      }
      list.close();
    } catch (IOException e) {
      System.out.println("History is cleared, or been already!!!");
    }
    return true;
  }

}

package com.sakute.weather;

import com.sakute.entities.User;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchHistory {
  public static boolean historyDisplay(){
    try {
      FileReader list = new FileReader("src/com/sakute/historyview/"+ User.getLogin() + ".txt");
      String symbol = ",";
      String[] listdata;
      Scanner scan = new Scanner(list);
      try {
        while (scan.hasNextLine()) {
          listdata = scan.nextLine().split(symbol);
          System.out.println(
              " | Місто/Регіон: " + listdata[0] + " | Країна: " + listdata[1] + " | Дата: "
                  + listdata[2]);
        }
      }catch (IOException){
        System.out.println("Історія порожня!");
      }

      list.close();

    } catch (IOException e) {
      System.out.println("Файл користувача не знайдено або історфю вже було очищено!!!");
    }
    return true;
  }

}

package com.sakute;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserInfoReader {
  void readFile(){
    try {
      FileReader fr = new FileReader("users.txt");

    }catch (FileNotFoundException ex){
      System.out.println("Файл не знайдено!Створюю файл...");
      try {
        FileWriter fw = new FileWriter("users.txt");
      } catch (IOException e) {
        System.out.println("Не можу створити файл!");
      }
    }
  }

}

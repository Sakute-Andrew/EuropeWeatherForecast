package com.sakute.menu;

import com.sakute.entities.User;
import com.sakute.weather.SearchByGeolocation;
import com.sakute.weather.SearchHistory;
import java.io.File;
import java.util.Scanner;

public class MainMenu {

  public static void printMenu(String[] options) {
    for (String option : options) {
      System.out.println(option);
    }
    System.out.print("Вітаємо, користувач " + ": ");
  }

  public static void menu() {
    //Меню опцій
    String[] options = {"___________________________________________",
        "[1] " +"📍" + " Перегляд за поточним місцерозташуванням",
        "[2] " +"🌦" +" - Перегляд погоди за містом",
        "[2] " +"🧾" +" - Історія пошуку",
        "[4] " +"🗑" +" - Видалення історії",
        "[5] " +"❌" +" - Вихід",
        "___________________________________________"
    };
    //Зчитування вибору користувача
    Scanner scanner = new Scanner(System.in);
    int option = 0;
    //Поки користувач не вибирає меню вихід, доти програма буде працювати
    while (option != 4) {
      printMenu(options);
      try {
        option = scanner.nextInt();
        switch (option) {
          case 1:
            option1();
            break;
          case 2:
            option2();
            break;
          case 3:
            option3();
            break;
          case 4:
            option4();
          case 5:
            option5();
        }
      } catch (Exception ex) {
        System.out.println("Такої опції нема!Виберіть між 1 та 4");
        scanner.next();
      }
    }
  }
  private static void option1() {
    SearchByGeolocation.getIpAddress();
  }
  // Опції
  private static void option2() {
    PrimaryMenu.option3();
  }

  private static void option3() {
    SearchHistory.historyDisplay();
  }

  private static void option4() {
    File file = new File("historyview/" + User.getLogin() + ".txt");
    if (file.delete()) {
      System.out.println("Історію очищено!");
    } else {
      System.out.println("Історію вже було очищено!");
    }
  }
  private static void option5() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ви точно бажаєте вийти? Y/N");
    String confirm = scanner.nextLine();
    if (confirm == "Y" || confirm == "y"){
      System.out.println("До Зустрічі!");
      System.exit(0);
    }
    menu();
  }

}

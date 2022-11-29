package com.sakute.menu;

import com.sakute.menu.PrimaryMenu;
import java.util.Scanner;

public class MainMenu {
  public static void printMenu(String[] options) {
    for (String option : options) {
      System.out.println(option);
    }
    System.out.print("Ласкаво Просимо у EWF!Виберіть опцію : ");
  }

  public static void menu() {
    //Меню опцій
    String[] options = {"___________________________________________",
        "1- Перегляд погоди за містом",
        "2- Історія пошуку;",
        "3- Видалення Історії",
        "4- Вихід",
        "___________________________________________"
    };
    //Зчитування вибору користувача
    Scanner scanner = new Scanner(System.in);
    int option = 1;
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
        }
      } catch (Exception ex) {
        System.out.println("Такої опції нема!Виберіть між 1 та 4");
        scanner.next();
      }
    }
  }

  // Опції
  private static void option1() {
    PrimaryMenu.option3();
  }

  private static void option2() {

  }

  private static void option3() {

  }

  private static void option4() {
    System.out.println("Ви точно бажаєте вийти? Y/N");



  }

}

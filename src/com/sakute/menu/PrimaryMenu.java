package com.sakute.menu;

import com.sakute.authentification.Authorization;
import com.sakute.authentification.Registration;
import com.sakute.entities.WeatherHttpRequest;
import java.util.Scanner;

public class PrimaryMenu {

  public static void printMenu(String[] options) {
    for (String option : options) {
      System.out.println(option);
    }
    System.out.print("Ласкаво Просимо у EWF!Виберіть опцію : ");
  }

  public static void menu() {
    //Меню опцій
      String[] options = {"___________________________________________",
          "1- Авторизація;",
          "2- Реєстрація;",
          "3- Перегляд погоди за містом.",
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
      System.out.println("Введіть оцінку:");
      Authorization.authorizationProcess();


    }

    private static void option2() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введіть логін: ");
      String userLogin = scanner.nextLine();
      System.out.println("Введіть пароль: ");
      String userPassword = scanner.next();
      if (!Registration.registrationProcess(userLogin, userPassword)){
        System.out.println("Помилка реєстрації!");
      }
    }

    private static void option3() {
      System.out.println("Введіть кількість студентів:");
      WeatherHttpRequest.weatherRequets();

    }

  private static void option4() {
    System.out.println("Ви точно бажаете вийти? Y/N");


  }

  }






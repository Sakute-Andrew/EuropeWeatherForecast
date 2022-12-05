package com.sakute.menu;

import com.sakute.authentification.Authentication;
import com.sakute.authentification.Registration;
import com.sakute.entities.User;
import com.sakute.weather.WeatherHttpRequest;
import java.util.Scanner;

public class PrimaryMenu {
  public static void printMenu(String[] options) {
    for (String option : options) {
      System.out.println(option);
    }
    System.out.print("Welcome to EuropeWeatherForecast!Select an option : ");
  }

  public static void menu() {
    //Меню опцій
      String[] menuOptions = {"___________________________________________",
          "[1] "  +" - Authentification",
          "[2] "  +" - Registration",
          "[3] "  +" - Forecast by city name",
          "[4] "  +" - Exit",
          "___________________________________________"
      };
      //Зчитування вибору користувача
      Scanner scanner = new Scanner(System.in);
      int option = 1;
      //Поки користувач не вибирає меню вихід, доти програма буде працювати
      while (option != 4) {
        printMenu(menuOptions);
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
          System.out.println("There's no such option!Select between 1 and 4");
          scanner.next();
        }
      }
    }

    // Опції
    private static void option1() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter login: ");
      String userLogin = scanner.nextLine();
      System.out.println("Enter password: ");
      String userPassword = scanner.nextLine();
      if (!Authentication.authentificationProcess(userLogin, userPassword)){
        System.out.println("Failed to log in!");
      }else {
        System.out.println("Successful authentification! Welcome " + userLogin);
        User.AutConfirm.setConfirmed(true);
        MainMenu.menu();
      }
    }

    private static void option2() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter login: ");
      String userLogin = scanner.nextLine();
      System.out.println("Enter password: ");
      String userPassword = scanner.next();
      if (!Registration.registrationProcess(userLogin, userPassword)){
        System.out.println(String.join("\n", "Registration error!",
            "Please note that your password must be:",
            "- Compile independently from LATIN LETTERS!!", "- Contain numbers (from 0-9)",
            "- Consist of upper and lower case letters", "- Contain symbols:[@#$%^&+=]"));
      }else {
        System.out.println("Successesful registration!");
        User.AutConfirm.setConfirmed(true);
        MainMenu.menu();
      }
    }

    public static void option3() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter city name:");
      String city =  scanner.next();
      System.out.println("Wait, please!");
      WeatherHttpRequest.weatherRequets(city);

    }

  private static void option4() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("You sure, you want to exit? Y/N");
    String confirm = scanner.nextLine();
    if (confirm == "Y" || confirm == "y"){
      System.out.println("See you later!");
      System.exit(0);
    }
    menu();
  }

  }






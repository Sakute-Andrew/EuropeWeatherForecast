package com.sakute;

import java.io.Console;
import java.util.Scanner;

public class ProgramConsole  {
  Console console = System.console();
  Scanner scanner = new Scanner(System.in);
  public static void clear(){
      try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } catch (Exception E) {
        System.out.println(E);
      }
    }

}

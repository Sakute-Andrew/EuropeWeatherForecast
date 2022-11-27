package com.sakute.entities;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherHttpRequest {
  public static void weatherRequets() {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введіть назву Міста чи Регіону");
    String city = scanner.next();
    System.out.println("Зачекайте, будь ласка!");
    String requestPath = "https://api.openweathermap.org/data/2.5/weather?q="+ city +"&limit=1&appid=3ab8bb892479dae143abd99020ed6f53";
    HttpURLConnection request = null;
    try {
      request = (HttpURLConnection) new URL(requestPath).openConnection();
      request.setRequestMethod("GET");
      request.setUseCaches(false);
      request.connect();
      StringBuilder sb = new StringBuilder();
      if (HttpURLConnection.HTTP_OK == request.getResponseCode()){
        BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream(), "CP1251"));
        String line;
        while ((line = in.readLine()) != null){
          sb.append(line);
          sb.append("\n");
        }
        if (sb.length() == 3){
          System.out.println("Некоректна назва Міста чи Регіону, спробуйте ще раз!");
        }else {
          System.out.println("Результат пошуку: " + sb);
        }
        //Gson g = new Gson();
        //City newCity = g.fromJson(sb.toString(), City.class);
      }else {
        System.out.println("ПОМИЛКА ЗАПИТУ" + request.getResponseCode() + "," + request.getResponseMessage());
      }

    } catch (Throwable cause){
      cause.printStackTrace();
    }finally {
      if (request != null){
        request.disconnect();

      }
    }


  }
}

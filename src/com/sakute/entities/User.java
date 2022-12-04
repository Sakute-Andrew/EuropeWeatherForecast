package com.sakute.entities;

public class User {
  private static String login;
  private String password;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public static String getLogin() {
    return login;
  }

  public  String getPassword() {

    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }

  public static void setLogin(String login) {
    User.login = login;
  }

  @Override
  public String toString() {
    return new StringBuffer()
        .append(this.login)
        .append("\n")
        .append(this.password)
        .append("\n")
        .toString();
  }
  public class AutConfirm{

    private static boolean isConfirmed;

    public static boolean isConfirmed() {
      return isConfirmed;
    }

    public static void setConfirmed(boolean confirmed) {
      isConfirmed = confirmed;
    }
  }

}

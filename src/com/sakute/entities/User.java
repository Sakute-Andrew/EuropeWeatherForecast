package com.sakute.entities;

import java.util.ArrayList;

public class User {
  String login;
  String password;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setLogin(String login) {
    this.login = login;
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

}

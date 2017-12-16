package com.Scenarios;

import org.testng.annotations.Test;

public class Login {
  @Test
  public void f(String Username,String password) {
	  System.out.println("Login");
	  System.out.println(Username);
	  System.out.println(password);
  }
}

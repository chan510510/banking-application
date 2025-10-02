package com.mybank.BankingApplication.exception;

public class InValidUserDetails extends RuntimeException {
  public InValidUserDetails(String message) {
    super(message);
  }
}

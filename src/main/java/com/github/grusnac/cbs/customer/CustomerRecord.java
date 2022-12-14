package com.github.grusnac.cbs.customer;

public record CustomerRecord(String firstName, String lastName, String email) {
  public CustomerRecord(Customer customer) {
    this(customer.getFirstName(), customer.getLastName(), customer.getEmail());
  }
}

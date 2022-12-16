package com.github.grusnac.cbs.customer;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "customer")
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(generator = "customers_seq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "customers_seq", allocationSize = 1)
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(email, customer.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

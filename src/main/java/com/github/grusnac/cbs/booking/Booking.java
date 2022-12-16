package com.github.grusnac.cbs.booking;

import com.github.grusnac.cbs.customer.Customer;
import com.github.grusnac.cbs.screening.Screening;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Booking")
@Table(name = "bookings")
public class Booking {
  @Id
  @GeneratedValue(generator = "bookings_seq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "bookings_seq", allocationSize = 1)
  private long id;

  @ManyToOne
  @JoinColumn(name = "screening_id")
  private Screening screening;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public long getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Booking booking = (Booking) o;
    return Objects.equals(screening, booking.screening)
        && Objects.equals(customer, booking.customer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(screening, customer);
  }

  public Screening getScreening() {
    return screening;
  }

  public void setScreening(Screening screening) {
    this.screening = screening;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}

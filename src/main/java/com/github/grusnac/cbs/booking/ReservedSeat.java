package com.github.grusnac.cbs.booking;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "ReservedSeat")
@Table(name = "reserved_seats")
public class ReservedSeat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "booking_id")
  private Booking booking;

  @ManyToOne
  @JoinColumn(name = "seat_id")
  private Seat seat;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReservedSeat that = (ReservedSeat) o;
    return Objects.equals(booking, that.booking) && Objects.equals(seat, that.seat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(booking, seat);
  }

  public long getId() {
    return id;
  }

  public Booking getBooking() {
    return booking;
  }

  public void setBooking(Booking booking) {
    this.booking = booking;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }
}

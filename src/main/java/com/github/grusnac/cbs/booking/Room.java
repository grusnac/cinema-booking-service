package com.github.grusnac.cbs.booking;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Room")
@Table(name = "rooms")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "number_of_seats")
  private int numberOfSeats;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Room room = (Room) o;
    return numberOfSeats == room.numberOfSeats && Objects.equals(name, room.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, numberOfSeats);
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }
}

package com.github.grusnac.cbs.booking;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Seat")
@Table(name = "seats")
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "row")
  private char row;

  @Column(name = "number")
  private int number;

  @ManyToOne
  @JoinColumn(name = "room_id")
  private Room room;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Seat seat = (Seat) o;
    return row == seat.row && number == seat.number && Objects.equals(room, seat.room);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, number, room);
  }

  public long getId() {
    return id;
  }

  public char getRow() {
    return row;
  }

  public void setRow(char row) {
    this.row = row;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room roomId) {
    this.room = roomId;
  }
}

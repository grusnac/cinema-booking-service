package com.github.grusnac.cbs.film;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Film")
@Table(name = "films")
public class Film {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "length_in_minutes")
  private int lengthInMinutes;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Film film = (Film) o;
    return Objects.equals(name, film.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
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

  public int getLengthInMinutes() {
    return lengthInMinutes;
  }

  public void setLengthInMinutes(int lengthInMinutes) {
    this.lengthInMinutes = lengthInMinutes;
  }
}

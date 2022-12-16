package com.github.grusnac.cbs.screening;

import com.github.grusnac.cbs.booking.Room;
import com.github.grusnac.cbs.film.Film;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Screening")
@Table(name = "screenings")
public class Screening {
  @Id
  @GeneratedValue(generator = "screenings_seq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "screenings_seq", allocationSize = 1)
  private long id;

  @ManyToOne
  @JoinColumn(name = "film_id")
  private Film film;

  @ManyToOne
  @JoinColumn(name = "room_id")
  private Room room;

  @Column(name = "start_time")
  private LocalDateTime startTime;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Screening screening = (Screening) o;
    return Objects.equals(film, screening.film)
        && Objects.equals(room, screening.room)
        && Objects.equals(startTime, screening.startTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(film, room, startTime);
  }

  public long getId() {
    return id;
  }

  public Film getFilm() {
    return film;
  }

  public void setFilm(Film filmId) {
    this.film = filmId;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room roomId) {
    this.room = roomId;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }
}

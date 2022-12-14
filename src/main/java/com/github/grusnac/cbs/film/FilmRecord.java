package com.github.grusnac.cbs.film;

public record FilmRecord(String name, long length_in_minutes) {
  public FilmRecord(Film film) {
    this(film.getName(), film.getLengthInMinutes());
  }
}

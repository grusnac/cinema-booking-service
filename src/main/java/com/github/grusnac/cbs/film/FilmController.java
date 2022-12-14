package com.github.grusnac.cbs.film;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("films")
public class FilmController {

  private final FilmRepository filmRepository;

  public FilmController(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  @GetMapping
  public Iterable<FilmRecord> getFilms() {
    return filmRepository.findAll().stream().map(FilmRecord::new).toList();
  }
}

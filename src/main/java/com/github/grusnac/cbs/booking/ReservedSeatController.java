package com.github.grusnac.cbs.booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reserved-seats")
public class ReservedSeatController {
  private final ReservedSeatRepository reservedSeatRepository;

  public ReservedSeatController(ReservedSeatRepository reservedSeatRepository) {
    this.reservedSeatRepository = reservedSeatRepository;
  }

  @GetMapping
  private Iterable<?> getReservedSeats() {
    return reservedSeatRepository.findAll();
  }
}

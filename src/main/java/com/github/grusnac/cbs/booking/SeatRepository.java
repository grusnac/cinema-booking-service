package com.github.grusnac.cbs.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SeatRepository extends JpaRepository<Seat, Long> {}

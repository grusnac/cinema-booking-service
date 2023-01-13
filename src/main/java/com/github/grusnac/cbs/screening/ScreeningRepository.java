package com.github.grusnac.cbs.screening;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {}

package ru.mbkcapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mbkcapital.model.CoolEntity;

/**
 * Created by orbot on 02.04.16.
 */
public interface CoolRepository extends JpaRepository<CoolEntity, Long> {
}

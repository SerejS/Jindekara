package com.jindekara.repo;

import com.jindekara.models.Personage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonageRepository extends CrudRepository<Personage, Long> {
}

package com.jindekara.repo;

import com.jindekara.models.Event;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    Iterable<Event> findAll(Sort yearStart);
}

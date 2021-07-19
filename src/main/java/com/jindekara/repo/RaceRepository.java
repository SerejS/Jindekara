package com.jindekara.repo;

import com.jindekara.enums.SectionBestiary;
import com.jindekara.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    List<Race> findAllBySectionBestiary(SectionBestiary sectionBestiary);
}

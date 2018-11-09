package edu.hawaii.its.casdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.hawaii.its.casdemo.type.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

    @Override
    Optional<Holiday> findById(Integer id);

    @Override
    Page<Holiday> findAll(Pageable pageable);

    List<Holiday> findAllByOrderByObservedDateDesc();

}

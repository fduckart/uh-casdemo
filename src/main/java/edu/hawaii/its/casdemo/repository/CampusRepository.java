package edu.hawaii.its.casdemo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.casdemo.type.Campus;

public interface CampusRepository extends JpaRepository<Campus, Integer> {

    Campus findById(Integer id);

    List<Campus> findAllByActual(String actual, Sort sort);

}

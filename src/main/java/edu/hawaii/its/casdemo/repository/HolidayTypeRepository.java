package edu.hawaii.its.casdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.hawaii.its.casdemo.type.Type;

@Repository
public interface HolidayTypeRepository extends JpaRepository<Type, Integer> {

    @Override
    Optional<Type> findById(Integer id);

}

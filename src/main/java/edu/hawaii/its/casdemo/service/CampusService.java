package edu.hawaii.its.casdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.casdemo.repository.CampusRepository;
import edu.hawaii.its.casdemo.type.Campus;

@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

    @Transactional(readOnly = true)
    public long count() {
        return campusRepository.count();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "campusesAll")
    public List<Campus> findAll() {
        return campusRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "campusesActualAll")
    public List<Campus> findActualAll() {
        return campusRepository.findAllByActual("Y", Sort.by("id"));
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "campusesById", key = "#id")
    public Campus find(Integer id) {
        Optional<Campus> campus = campusRepository.findById(id);
        return campus.isPresent() ? campus.get() : null;
    }

    @Transactional
    @Caching(put = @CachePut(value = "campusesById", key = "#result.id"),
            evict = {
                    @CacheEvict(value = "campusesAll", allEntries = true),
                    @CacheEvict(value = "campusesActualAll", allEntries = true) })
    public Campus addCampus(Campus campus) {
        return campusRepository.save(campus);
    }

    public CampusRepository getCampusRepository() {
        return campusRepository;
    }

    public void setCampusRepository(CampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }
}

package edu.hawaii.its.casdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.casdemo.type.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Override
    @Cacheable(value = "rolesCache")
    List<Role> findAll();

    @Override
    @Cacheable(value = "rolesByIdCache")
    Optional<Role> findById(Integer id);

    Role findByRole(String role);
}

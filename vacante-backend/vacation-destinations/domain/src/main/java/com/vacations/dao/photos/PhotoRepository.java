package com.vacations.dao.photos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

    Optional<PhotoEntity> findById(long id);
}

package com.vacations.dao.accommodation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationFeatureRepository extends JpaRepository<AccommodationFeatureEntity, Long> {
}

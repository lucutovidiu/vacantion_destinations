package com.vacations.dao.accommodation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationEntityRepository extends JpaRepository<AccommodationEntity, Long> {
}

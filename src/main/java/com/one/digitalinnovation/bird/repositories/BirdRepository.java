package com.one.digitalinnovation.bird.repositories;

import com.one.digitalinnovation.bird.entities.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {
}

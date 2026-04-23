package com.developmentTracking.developtrack.repository;

import com.developmentTracking.developtrack.model.Develop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevelopRepository extends JpaRepository<Develop,Long> {
}

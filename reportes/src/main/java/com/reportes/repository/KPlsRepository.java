package com.reportes.repository;

import com.reportes.models.KPls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface KPlsRepository extends JpaRepository<KPls, Integer> {
}

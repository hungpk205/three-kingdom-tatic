package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.RecommendedWarManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendedWarManualRepository extends JpaRepository<RecommendedWarManual, Long> {

}

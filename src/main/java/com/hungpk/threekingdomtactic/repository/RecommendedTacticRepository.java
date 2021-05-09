package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.RecommendedTactic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendedTacticRepository extends JpaRepository<RecommendedTactic, Long> {

}

package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Lineup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineupRepository extends JpaRepository<Lineup, Long> {

}

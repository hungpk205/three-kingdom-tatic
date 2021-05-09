package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.TacticLineup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacticLineupRepository extends JpaRepository<TacticLineup, Long> {

}

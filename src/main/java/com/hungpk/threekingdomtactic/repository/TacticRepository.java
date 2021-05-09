package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Tactic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacticRepository extends JpaRepository<Tactic, Long> {

}

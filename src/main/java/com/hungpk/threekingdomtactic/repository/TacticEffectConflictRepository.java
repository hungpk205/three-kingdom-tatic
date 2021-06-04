package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.TacticEffectConflict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacticEffectConflictRepository extends JpaRepository<TacticEffectConflict, Long> {

}

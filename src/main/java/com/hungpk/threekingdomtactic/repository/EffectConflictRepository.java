package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.EffectConflict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectConflictRepository extends JpaRepository<EffectConflict, Long> {

}

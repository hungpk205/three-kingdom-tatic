package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.WarManualEffectConflict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarManualEffectConflictRepository extends JpaRepository<WarManualEffectConflict, Long> {

}

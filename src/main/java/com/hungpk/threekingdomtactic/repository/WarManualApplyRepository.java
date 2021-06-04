package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.WarManualApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarManualApplyRepository extends JpaRepository<WarManualApply, Long> {

}

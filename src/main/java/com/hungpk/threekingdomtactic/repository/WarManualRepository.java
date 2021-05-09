package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.WarManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarManualRepository extends JpaRepository<WarManual, Long> {

}

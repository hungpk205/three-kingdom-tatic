package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.ReplacementOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementOfficerRepository extends JpaRepository<ReplacementOfficer, Long> {

}

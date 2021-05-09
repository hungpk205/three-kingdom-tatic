package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepository extends JpaRepository<Target, Long> {

}

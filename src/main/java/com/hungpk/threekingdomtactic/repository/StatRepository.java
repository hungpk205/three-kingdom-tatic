package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

}

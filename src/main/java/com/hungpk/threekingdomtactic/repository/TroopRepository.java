package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Troop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TroopRepository extends JpaRepository<Troop, Long> {

}

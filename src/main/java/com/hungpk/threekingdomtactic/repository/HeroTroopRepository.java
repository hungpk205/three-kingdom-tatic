package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.HeroTroop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroTroopRepository extends JpaRepository<HeroTroop, Long> {

}

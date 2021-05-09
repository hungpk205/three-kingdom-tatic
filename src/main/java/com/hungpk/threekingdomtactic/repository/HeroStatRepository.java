package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.HeroStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroStatRepository extends JpaRepository<HeroStat, Long> {

}

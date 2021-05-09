package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.AffinityHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffinityHeroRepository extends JpaRepository<AffinityHero, Long> {

}
